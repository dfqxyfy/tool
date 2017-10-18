package cn.ccs.sunlands.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePivotTable_bak {

    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet();
            XSSFSheet sheetPivot = wb.createSheet();
            //Create some data to build the pivot table on
            setCellData(sheet);

            AreaReference source = new AreaReference("A1:E5", SpreadsheetVersion.EXCEL2007);
            CellReference position = new CellReference("A5");
            // Create a pivot table on this sheet, with H5 as the top-left cell..
            // The pivot table's data source is on the same sheet in A1:D4
            XSSFPivotTable pivotTable = sheetPivot.createPivotTable(source, position,sheet);
            //Configure the pivot table
            //Use first column as row label
            pivotTable.addRowLabel(0);
            //Sum up the second column
            pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1,"距离");
            //Set the third column as filter
            pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 2,"时间");
            pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 4,"速度");
            //Add filter on forth column
            pivotTable.addReportFilter(1);
            //pivotTable.addColumnLabel(DataConsolidateFunction.PRODUCT,2,"mySum");

            //pivotTable.addDataColumn(4,true);
            //pivotTable.addDataColumn(0,false);
            //pivotTable.addRowLabel(3);

            if(true) {

                CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
                CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
                ctCacheField.setName("真实平均速度bak");
                ctCacheField.setFormula("距离/时间");
                ctCacheField.setNumFmtId(0);
                ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray());//!!! update count of fields directly

                CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
                pivotField.setDataField(true);
                pivotField.setDragToCol(false);
                pivotField.setDragToPage(false);
                pivotField.setDragToRow(false);
                pivotField.setShowAll(false);
                pivotField.setDefaultSubtotal(false);

                CTDataFields dataFields;
                if (pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
                    dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
                } else {
                    // can be null if we have not added any column labels yet
                    dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
                }
                CTDataField dataField = dataFields.addNewDataField();
                dataField.setName("平均处理Processed");
                // set index of cached field with formula - it is the last one!!!
                dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount() - 1);
                dataField.setBaseItem(0);
                dataField.setBaseField(0);

            }


            try (FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable_chufa_shengcheng.xlsx")) {
                wb.write(fileOut);
            }
        }
    }

    public static void setCellData(XSSFSheet sheet){
        Row row1 = sheet.createRow(0);
        // Create a cell and put a value in it.
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("姓名");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("距离");
        Cell cell13 = row1.createCell(2);
        cell13.setCellValue("时间");
        Cell cell14 = row1.createCell(3);
        cell14.setCellValue("是否汽车");
        Cell cell15 = row1.createCell(4);
        cell15.setCellValue("速度");
        //sheet.add

        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("关二哥");
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(1000);
        Cell cell23 = row2.createCell(2);
        cell23.setCellValue(100);
        Cell cell24 = row2.createCell(3);
        cell24.setCellValue("Yes");
        Cell cell25= row2.createCell(4);
        cell25.setCellFormula("B2/C2");

        Row row3 = sheet.createRow(2);
        Cell cell31 = row3.createCell(0);
        cell31.setCellValue("Tarzan");
        Cell cell32 = row3.createCell(1);
        cell32.setCellValue(100);
        Cell cell33 = row3.createCell(2);
        cell33.setCellValue(90);
        Cell cell34 = row3.createCell(3);
        cell34.setCellValue("Yes");
        Cell cell35= row3.createCell(4);
        cell35.setCellFormula("B3/C3");


        Row row4 = sheet.createRow(3);
        Cell cell41 = row4.createCell(0);
        cell41.setCellValue("Terk");
        Cell cell42 = row4.createCell(1);
        cell42.setCellValue(90);
        Cell cell43 = row4.createCell(2);
        cell43.setCellValue(50);
        Cell cell44 = row4.createCell(3);
        cell44.setCellValue("No");
        Cell cell45= row4.createCell(4);
        cell45.setCellFormula("B4/C4");

        Row row5 = sheet.createRow(4);
        Cell cell51 = row5.createCell(0);
        cell51.setCellValue("关二哥");
        Cell cell52 = row5.createCell(1);
        cell52.setCellValue(2000);
        Cell cell53 = row5.createCell(2);
        cell53.setCellValue(50);
        Cell cell54 = row5.createCell(3);
        cell54.setCellValue("No");
        Cell cell55= row5.createCell(4);
        cell55.setCellFormula("B5/C5");
    }
}
