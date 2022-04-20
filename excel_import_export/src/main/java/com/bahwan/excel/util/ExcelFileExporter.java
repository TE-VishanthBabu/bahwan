package com.bahwan.excel.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bahwan.excel.model.ExcelModel;
import com.bahwan.excel.model.HeaderModel;

public class ExcelFileExporter {

	public static ByteArrayInputStream contactListToExcelFile(List<Object> customers) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Product");
			
			XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 15);
			font.setFontName("Times New Roman");
			font.setBold(true);
			
			XSSFFont font2 = workbook.createFont();
			font2.setFontHeightInPoints((short) 10);
			font2.setFontName("Times New Roman");
			
			CellStyle cellStyle2=workbook.createCellStyle();
			cellStyle2.setShrinkToFit(true);
			cellStyle2.setBorderTop(BorderStyle.MEDIUM);
			cellStyle2.setBorderBottom(BorderStyle.MEDIUM);
			cellStyle2.setBorderLeft(BorderStyle.MEDIUM);
			cellStyle2.setBorderRight(BorderStyle.MEDIUM);
			cellStyle2.setAlignment(HorizontalAlignment.CENTER);
			cellStyle2.setFont(font2);
			
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setShrinkToFit(true);
			cellStyle.setBorderTop(BorderStyle.MEDIUM);
			cellStyle.setBorderBottom(BorderStyle.MEDIUM);
			cellStyle.setBorderLeft(BorderStyle.MEDIUM);
			cellStyle.setBorderRight(BorderStyle.MEDIUM);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setFont(font);
			// Creating data rows for each customer
			for (int i = 0; i < customers.size(); i++) {
				Row dataRow = sheet.createRow(i);
				if (i == 0) {
					dataRow.createCell(0).setCellValue(((HeaderModel) customers.get(i)).getProductid());
					dataRow.getCell(0).setCellStyle(cellStyle);
					dataRow.createCell(1).setCellValue(((HeaderModel) customers.get(i)).getName());
					dataRow.getCell(1).setCellStyle(cellStyle);
					dataRow.createCell(2).setCellValue(((HeaderModel) customers.get(i)).getCost());
					dataRow.getCell(2).setCellStyle(cellStyle);
					dataRow.createCell(3).setCellValue(((HeaderModel) customers.get(i)).getQuantity());
					dataRow.getCell(3).setCellStyle(cellStyle);
					dataRow.createCell(4).setCellValue(((HeaderModel) customers.get(i)).getTotalValue());
					dataRow.getCell(4).setCellStyle(cellStyle);
					dataRow.createCell(5).setCellValue(((HeaderModel) customers.get(i)).getCategry());
					dataRow.getCell(5).setCellStyle(cellStyle);
					dataRow.createCell(6).setCellValue(((HeaderModel) customers.get(i)).getLocation());
					dataRow.getCell(6).setCellStyle(cellStyle);

				} else {
					dataRow.createCell(0).setCellValue(((ExcelModel) customers.get(i)).getId());
					dataRow.getCell(0).setCellStyle(cellStyle2);
					dataRow.createCell(1).setCellValue(((ExcelModel) customers.get(i)).getProductName());
					dataRow.getCell(1).setCellStyle(cellStyle2);
					dataRow.createCell(2).setCellValue(((ExcelModel) customers.get(i)).getPrice());
					dataRow.getCell(2).setCellStyle(cellStyle2);
					dataRow.createCell(3).setCellValue(((ExcelModel) customers.get(i)).getQuantity());
					dataRow.getCell(3).setCellStyle(cellStyle2);
					dataRow.createCell(4).setCellFormula("PRODUCT((C2:C6)*(D2:D6))");
					dataRow.getCell(4).setCellStyle(cellStyle2);
					dataRow.createCell(5).setCellValue(((ExcelModel) customers.get(i)).getCategory());
					dataRow.getCell(5).setCellStyle(cellStyle2);
					dataRow.createCell(6).setCellValue(((ExcelModel) customers.get(i)).getShopName());
					dataRow.getCell(6).setCellStyle(cellStyle2);
				}
			}

			// Making size of column auto resize to fit with data
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(customers.size());
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
