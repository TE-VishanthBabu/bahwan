package com.bahwan.pdf.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahwan.pdf.model.DataModel;
import com.bahwan.pdf.util.PdfExporter;

@RestController
@RequestMapping("/api/")
public class PdfController {

	@PostMapping("export/pdf")
	public void generatePdf(@RequestBody DataModel data, HttpServletResponse response) {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		response.setHeader("Content-Disposition", "attachment; filename=userInfo_"+currentDateTime+".pdf");
		PdfExporter exporter = new PdfExporter(data.getHeader(),data.getUsers());
		exporter.export(response);
	}

}
