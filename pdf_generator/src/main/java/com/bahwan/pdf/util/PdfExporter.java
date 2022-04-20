package com.bahwan.pdf.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfExporter {

	private List<String[]> listUsers;
	private String[] headers;

	public PdfExporter(String[] headers, List<String[]> listUsers) {
		super();
		this.listUsers = listUsers;
		this.headers = headers;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.CYAN);
		cell.setPadding(5);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
		for (int i = 0; i < headers.length; i++) {
			cell.setPhrase(new Phrase(this.headers[i], font));
			table.addCell(cell);
		}

	}

	private void writeTableData(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		for (String[] user : listUsers) {
			for (int i = 0; i < user.length; i++) {
				// System.out.println(user[i]);
				cell.setPhrase(new Phrase(user[i]));
				table.addCell(cell);
			}
		}
	}

	public void export(HttpServletResponse response) {
		Document document = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 25, Color.RED);
			Paragraph paragraph = new Paragraph("User_Info", font);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);
			PdfPTable table = new PdfPTable(headers.length);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 1.5f, 3.5f, 3.0f });
			table.setSpacingBefore(10);
			writeTableHeader(table);
			writeTableData(table);
			document.add(table);
			document.close();

		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}

}
