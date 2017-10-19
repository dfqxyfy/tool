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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OfficeDemoChange {
    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet();
            XSSFSheet pivotSheet = wb.createSheet();

            //Create some data to build the pivot table on
            setCellData(sheet);

            AreaReference source = new AreaReference("A1:D4", SpreadsheetVersion.EXCEL2007);
            CellReference position = new CellReference("A5");
            // Create a pivot table on this sheet, with H5 as the top-left cell..
            // The pivot table's data source is on the same sheet in A1:D4
            XSSFPivotTable pivotTable = pivotSheet.createPivotTable(source, position,sheet);
            //Configure the pivot table
            //Use first column as row label
            pivotTable.addRowLabel(0);
            //Sum up the second column
            pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
            //Set the third column as filter
            pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
            //Add filter on forth column
            pivotTable.addReportFilter(3);

            try (FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable.xlsx")) {
                wb.write(fileOut);
            }
        }
    }

    public static void setCellData(XSSFSheet sheet){
        Row row1 = sheet.createRow(0);
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("Names");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("#");
        Cell cell13 = row1.createCell(2);
        cell13.setCellValue("%");
        Cell cell14 = row1.createCell(3);
        cell14.setCellValue("Human");

        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("Jane");
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(10);
        Cell cell23 = row2.createCell(2);
        cell23.setCellValue(100);
        Cell cell24 = row2.createCell(3);
        cell24.setCellValue("Yes");

        Row row3 = sheet.createRow(2);
        Cell cell31 = row3.createCell(0);
        cell31.setCellValue("Tarzan");
        Cell cell32 = row3.createCell(1);
        cell32.setCellValue(5);
        Cell cell33 = row3.createCell(2);
        cell33.setCellValue(90);
        Cell cell34 = row3.createCell(3);
        cell34.setCellValue("Yes");

        Row row4 = sheet.createRow(3);
        Cell cell41 = row4.createCell(0);
        cell41.setCellValue("Terk");
        Cell cell42 = row4.createCell(1);
        cell42.setCellValue(10);
        Cell cell43 = row4.createCell(2);
        cell43.setCellValue(90);
        Cell cell44 = row4.createCell(3);
        cell44.setCellValue("No");

        Row row5 = sheet.createRow(4);
        Cell cell51 = row4.createCell(0);
        cell51.setCellValue("Terk");
        Cell cell52 = row4.createCell(1);
        cell52.setCellValue(10);
        Cell cell53 = row4.createCell(2);
        cell53.setCellValue(90);
        Cell cell54 = row4.createCell(3);
        cell54.setCellValue("No");
    }
}
