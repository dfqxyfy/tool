package cn.ccs.sunlands.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePivotTableSec {

    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet pivotSheet = workbook.createSheet("Pivot");
        XSSFSheet dataSheet = workbook.createSheet("dataSheet");
        CreatePivotTable.setCellData(dataSheet);
        XSSFPivotTable pivotTable = ((XSSFSheet)pivotSheet).createPivotTable(new AreaReference("A1:E5",SpreadsheetVersion.EXCEL2007), new CellReference("A1"), dataSheet);
        CTPivotTableDefinition ctPivotTableDefinition = pivotTable.getCTPivotTableDefinition();
        CTPivotTableStyle ctPivotTableStyle = ctPivotTableDefinition.getPivotTableStyleInfo();
        ctPivotTableStyle.setName("PivotStyleMedium4");



        CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
        CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
        ctCacheField.setName("Avg Pct Processed");
        ctCacheField.setFormula("'Ended' / 'Generated' * 100");

        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 2, "Sum of Generated");
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 3, "Sum of Ended");
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 4, "Sum of Unended");
        //pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 5, "Average of Processed Percent");

        pivotTable.addRowLabel(0);
// 1. Add Formula to cache
        addFormulaToCache(pivotTable);
// 2. Add PivotField for Formula column
        addPivotFieldForNewColumn(pivotTable);
// 3. Add all column labels before our function..
        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
        //Set the third column as filter
        pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
// 4. Add formula column
        addFormulaColumn(pivotTable);


        try (FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable10.xlsx")) {
            workbook.write(fileOut);
        }
    }

    private static void addFormulaToCache(XSSFPivotTable pivotTable) {
        CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
        CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
        ctCacheField.setName("Field1"); // Any field name
        ctCacheField.setFormula("'Ended' / 'Generated' * 100");
        ctCacheField.setDatabaseField(false);
        ctCacheField.setNumFmtId(0);
        ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray()); //!!! update count of fields directly
    }
    private static void addPivotFieldForNewColumn(XSSFPivotTable pivotTable) {
        CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
        pivotField.setDataField(true);
        pivotField.setDragToCol(false);
        pivotField.setDragToPage(false);
        pivotField.setDragToRow(false);
        pivotField.setShowAll(false);
        pivotField.setDefaultSubtotal(false);
    }

    private static void addFormulaColumn(XSSFPivotTable pivotTable) {
        CTDataFields dataFields;
        if(pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
            dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
        } else {
            // can be null if we have not added any column labels yet
            dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
        }
        CTDataField dataField = dataFields.addNewDataField();
        dataField.setName("Avg Pct Processed");
        // set index of cached field with formula - it is the last one!!!
        dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount()-1);
        dataField.setBaseItem(0);
        dataField.setBaseField(0);
    }


}
