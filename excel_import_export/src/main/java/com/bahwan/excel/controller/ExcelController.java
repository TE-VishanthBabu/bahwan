package com.bahwan.excel.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bahwan.excel.model.ExcelModel;
import com.bahwan.excel.model.HeaderModel;
import com.bahwan.excel.util.ExcelFileExporter;

@RestController
public class ExcelController {

	List<Object> excelModels = new ArrayList<Object>();

	@RequestMapping(path = "/import", method = RequestMethod.POST)
	public ResponseEntity<List<Object>> importExcelFile(@RequestParam("file") MultipartFile files,
			HttpServletResponse response) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		HeaderModel model = new HeaderModel();

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {

			ExcelModel model1 = new ExcelModel();

			XSSFRow row = worksheet.getRow(index);
			if (index == 0) {
				model.setProductid(row.getCell(0).getStringCellValue());
				model.setName(row.getCell(1).getStringCellValue());
				model.setCost(row.getCell(2).getStringCellValue());
				model.setQuantity(row.getCell(3).getStringCellValue());
				model.setTotalValue(row.getCell(4).getStringCellValue());
				model.setCategry(row.getCell(5).getStringCellValue());
				model.setLocation(row.getCell(6).getStringCellValue());
				excelModels.add(model);

			} else {

				Integer id = (int) row.getCell(0).getNumericCellValue();
				model1.setId(id.toString());
				model1.setProductName(row.getCell(1).getStringCellValue());
				model1.setPrice(row.getCell(2).getNumericCellValue());
				model1.setQuantity(row.getCell(3).getNumericCellValue());
				model1.setCategory(row.getCell(5).getStringCellValue());
				model1.setShopName(row.getCell(6).getStringCellValue());
				excelModels.add(model1);
			}
		}
		return new ResponseEntity<List<Object>>(excelModels, HttpStatus.OK);
	}

	@GetMapping("/export")
	public void downloadExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:MM:SS");
		String currentDateTime = dateFormatter.format(new Date());
		response.setHeader("Content-Disposition", "attachment; filename=product_"+currentDateTime+".xlsx");
		ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(excelModels);
		IOUtils.copy(stream, response.getOutputStream());
	}
}
