package com.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyPivotTable {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream out = new FileOutputStream("workbook.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet s = wb.createSheet();

    }
}
