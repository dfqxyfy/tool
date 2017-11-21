package com.ccs.excel;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportExcel<T> {

    private final Logger logger = LoggerFactory.getLogger(ExportExcel.class);

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title   表格标题名
     * @param headers 表格属性列名数组
     * @param orders  表格属性值的列表
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public XSSFSheet createDataSheet( String title, String[] headers,String[] orders,
                            Collection<T> dataset, String pattern,Class<T> t)  {

        // 声明一个工作薄
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        //sheet.setDefaultColumnWidth((short) 15);

        //初始化顺序
        initOutOrder(orders,t);
        
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            //XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            //cell.setCellValue(text);
            cell.setCellValue(headers[i]);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            addOneRow(sheet,index,it.next(),"yyyy-MM-dd");
        }
        return sheet;
    }

    /***
     * 按顺序增加sheet上的行
     */
    private <T> void addOneRow(XSSFSheet sheet,int index,T data,String pattern){
        XSSFRow row  = sheet.createRow(index);
        // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
        for (short i = 0; i < methodList.size(); i++) {
            XSSFCell cell = row.createCell(i);

            Object value = null;
            try {
                value = methodList.get(i).invoke(data, new Object[]{});
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 判断值的类型后进行强制类型转换
            String textValue = null;
            if (value instanceof Boolean) {
                boolean bValue = (Boolean) value;
                textValue = "是";
                if (!bValue) {
                    textValue = "否";
                }
            } else if (value instanceof Date) {
                Date date = (Date) value;
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                textValue = sdf.format(date);
            } else {//删除掉数据
                // 其它数据类型都当作字符串简单处理
                if(value!=null)
                    textValue = value.toString();
            }
            // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
            if (textValue != null) {
                Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
                Matcher matcher = p.matcher(textValue);
                if (matcher.matches()) {
                    // 是数字当作double处理
                    cell.setCellValue(Double.parseDouble(textValue));
                } else {
                    //XSSFRichTextString richString = new XSSFRichTextString(textValue);
                    //cell.setCellValue(richString);
                    cell.setCellValue(textValue);
                }
            }
        }
    }


    private void initOutOrder(String[] orders ,Class<T> t) {

        try {
            for (String prop : orders) {
                String getMethodName = "get" + prop.substring(0, 1).toUpperCase() + prop.substring(1);
                Method method = t.getMethod(getMethodName, new Class[]{});
                methodList.add(method);
            }
        }catch (NoSuchMethodException e) {
            throw new RuntimeException(e);//改为
        }
    }

    private List<Method> methodList = new ArrayList<>();


    /**
     *
     * @param sourceSheet       sheet源
     * @param areaReference     格式区域,如: "A1:E5"
     * @param cellReference     起始位置,如："A5"
     */
    public XSSFPivotTable createPivotTable(String sheetName ,XSSFSheet sourceSheet, String areaReference, String cellReference){
        XSSFSheet pivotSheet = null;
        if(sheetName == null)
            pivotSheet = workbook.createSheet();
        else
            pivotSheet = workbook.createSheet(sheetName);
        AreaReference source = new AreaReference(areaReference, SpreadsheetVersion.EXCEL2007);
        CellReference position = new CellReference(cellReference);
        // Create a pivot table on this sheet, with H5 as the top-left cell..
        // The pivot table's data source is on the same sheet in A1:D4
        XSSFPivotTable pivotTable = pivotSheet.createPivotTable(source, position,sourceSheet);

        return pivotTable;

    }

    /**
     *
     * @param pivotSheet        sheet区域
     * @param sourceSheet       sheet源
     * @param areaReference     格式区域,如: "A1:E5"
     * @param cellReference     起始位置,如："A5"
     */
    public XSSFPivotTable createAndFillPivotTable(XSSFSheet pivotSheet, XSSFSheet sourceSheet, String areaReference, String cellReference){
        AreaReference source = new AreaReference(areaReference, SpreadsheetVersion.EXCEL2007);
        CellReference position = new CellReference(cellReference);
        // Create a pivot table on this sheet, with H5 as the top-left cell..
        // The pivot table's data source is on the same sheet in A1:D4
        XSSFPivotTable pivotTable = pivotSheet.createPivotTable(source, position,sourceSheet);


        pivotTable.addRowLabel(0);
        //Sum up the second column
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, new Integer(1),"距离");
        //Set the third column as filter
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 2,"时间");
        //pivotTable.addDataColumn(4, true);
        //Add filter on forth column
        //pivotTable.addReportFilter(1);
        //pivotTable.addColumnLabel(DataConsolidateFunction.PRODUCT,2,"mySum");

        //pivotTable.addDataColumn(4,true);
        //pivotTable.addDataColumn(0,false);
        pivotTable.addReportFilter(3);


        CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
        CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
        ctCacheField.setName("真实平均速度bak");
        ctCacheField.setFormula("距离/时间");
        ctCacheField.setDatabaseField(false);
        ctCacheField.setNumFmtId(0);
        ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray());//!!! update count of fields directly

        CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
        pivotField.setDataField(true);
        pivotField.setDragToCol(false);
        pivotField.setDragToPage(false);
        pivotField.setDragToRow(false);
        pivotField.setShowAll(false);
        pivotField.setDefaultSubtotal(false);

        //pivotField.setAutoShow(true);
        //pivotField.setName("平均速度");


        CTDataFields dataFields;
        if (pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
            dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
        } else {
            // can be null if we have not added any column labels yet
            dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
        }
        System.out.println(dataFields.getCount());
        CTDataField dataField = dataFields.addNewDataField();
        //CTDataField dataField = dataFields.insertNewDataField(4);
        dataField.setName("平均处理Processed");
        // set index of cached field with formula - it is the last one!!!
        dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount() - 1);
        dataField.setBaseItem(0);
        dataField.setBaseField(0);
        System.out.println(dataFields.getCount());

        return pivotTable;

    }

    /**
     * @param pivotTable        透视表
     * @param rowLabelList      显示某几行
     * @param columnLabelList   符合条件
     * @param reportFilterList  过滤列表
     */
    public void setRowList(XSSFPivotTable pivotTable,
                            List<Integer> rowLabelList,
                            List<InsideColum> columnLabelList,
                            List<Integer> reportFilterList){
        //Configure the pivot table
        //Use first column as row label
        //pivotTable.addRowLabel(0);
        if(rowLabelList!=null && rowLabelList.size() > 0){
            for(Integer rowLabel:rowLabelList)
                pivotTable.addRowLabel(rowLabel);
        }
        //Sum up the second column
        //pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1,"距离");
        if(columnLabelList != null && columnLabelList.size() > 0){
            int i = 0;
            for(InsideColum colum : columnLabelList){
                i++;
                pivotTable.addColumnLabel(colum.getFunction(), colum.getColumn(), colum.getDesc());
//                System.out.println(colum.getColumn()+colum.getDesc());
//                if(i%2 == 0) {
//                    fillPivotTable(pivotTable, "真实平均速度"+i, "距离/时间", "距离dsf时间"+i);
//                }
            }
        }


        //Add filter on forth column
        //pivotTable.addReportFilter(1);
        if(reportFilterList !=null && reportFilterList.size() > 0){
            for(Integer filter:reportFilterList){
                pivotTable.addReportFilter(filter.intValue());
            }
        }

    }

    public void addColumnAndPivotTable(){

    }

    public void fillPivotTable(XSSFPivotTable pivotTable, String fieldName, String formula, String displayName) {
        addFormulaToCache(pivotTable,fieldName,formula);
        addPivotFieldForNewColumn(pivotTable,fieldName);
        addFormulaColumn(pivotTable,displayName);
    }

    private static void addFormulaToCache(XSSFPivotTable pivotTable, String fieldName, String formula) {
        CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
        CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
        ctCacheField.setName(fieldName); // Any field name
        ctCacheField.setFormula(formula);
        ctCacheField.setDatabaseField(false);
        ctCacheField.setNumFmtId(0);
        ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray()); //!!! update count of fields directly
    }
    private static void addPivotFieldForNewColumn(XSSFPivotTable pivotTable, String fieldName) {
        CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
        pivotField.setDataField(true);
        pivotField.setDragToCol(false);
        pivotField.setDragToPage(false);
        pivotField.setDragToRow(false);
        pivotField.setShowAll(false);
        pivotField.setDefaultSubtotal(false);

        //pivotField.setAutoShow(true);
        //pivotField.setName(fieldName);
    }
    private static void addFormulaColumn(XSSFPivotTable pivotTable,String displayName) {
        CTDataFields dataFields;
        if(pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
            dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
        } else {
            // can be null if we have not added any column labels yet
            dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
        }
        CTDataField dataField = dataFields.addNewDataField();
        dataField.setName(displayName);
        // set index of cached field with formula - it is the last one!!!
        dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount()-1);
        dataField.setBaseItem(0);
        dataField.setBaseField(0);
    }

    public static class InsideColum{
        private DataConsolidateFunction function;
        private Integer column;
        private String desc;

        public InsideColum(DataConsolidateFunction function ,Integer column, String desc){
            this.function = function;
            this.column = column;
            this.desc = desc;
        }
        public DataConsolidateFunction getFunction() {
            return function;
        }
        public Integer getColumn() {
            return column;
        }
        public String getDesc() {
            return desc;
        }
    }


    public String getAreaReference(XSSFSheet dataSheet){

        Integer columns = dataSheet.getRow(0).getPhysicalNumberOfCells();
        Integer rows = dataSheet.getLastRowNum();
        Integer front = columns/26;
        String end = (front==0?"":String.valueOf((char)('A'+front-1)))+String.valueOf((char)('A'+columns%26-1));
        String areaReference = "A1"+":"+end+""+(rows+1);
        return areaReference;
    }

    private XSSFWorkbook workbook = new XSSFWorkbook();

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    //    public void createExcel(){
//
//        XSSFSheet dataSheet = createDataSheet(workbook,"sheetData",headers,orders,siteDailyEntities,"yyyy-MM-dd",SiteDailyEntity.class);
//        XSSFSheet pivotTableSheet = workbook.createSheet();
//        Integer columns = dataSheet.getRow(0).getPhysicalNumberOfCells();
//
//        Integer rows = dataSheet.getLastRowNum();
//        char c = 'A';
//        String areaReference = "A1"+":"+String.valueOf((char)(c+columns-1))+""+(rows+1);
//
//        XSSFPivotTable pivotTable = createPivotTable(pivotTableSheet,dataSheet,areaReference,"A6");
//        setRowList(pivotTable,
//                new ArrayList<Integer>(){{
//                    add(0);
//                    //add(3);
//                }},
//                //null,
//                new ArrayList<ExportExcel.InsideColum>(){{
//                    add(new ExportExcel.InsideColum(DataConsolidateFunction.SUM,1,"距离"));
//                    add(new ExportExcel.InsideColum(DataConsolidateFunction.SUM,2,"时间"));
//                }},
//                new ArrayList<Integer>(){{add(3);}}
//        );
//        fillPivotTable(pivotTable,"真实平均速度bak","距离/时间","距离dsf时间");
//
//    }
}
