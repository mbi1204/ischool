package com.sinergitec.ischool.pdf;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sinergitec.ischool.model.ct.ctAlumno;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		
		
//		ctAlumno obj = (ctAlumno ) model.get("ctAlumno");
//		
//		
//		doc.add(new Paragraph("Nombre: "               +  obj.getcNombre()));
//		doc.add(new Paragraph("Apellidos: "            +  obj.getcApellido()));
//		doc.add(new Paragraph("Fecha de Nacimiento: "  +  obj.getDtFechaNac()));
//		doc.add(new Paragraph("Telefono: "             +  obj.getcTel()));
//		doc.add(new Paragraph("Correo: "               +  obj.getcCorreo()));
//		
//		doc.add(new Paragraph("Calle: "        +  obj.getcCalle()));
//		doc.add(new Paragraph("Num Ext: "      +  obj.getcNumExt()));
//		doc.add(new Paragraph("Num Int: "      +  obj.getcNumInt()));
//		doc.add(new Paragraph("Colonia: "      +  obj.getcColonia()));
//		doc.add(new Paragraph("CP: "           +  obj.getcCP()));
//		doc.add(new Paragraph("Delg o Munp: "  +  obj.getcMunicipio()));
//		doc.add(new Paragraph("Estado: "       +  obj.getcEstado()));
//		
		
		
		doc.add(new Paragraph("hola "));
		
		
		
		
//		PdfPTable table = new PdfPTable(5);
//		table.setWidthPercentage(100.0f);
//		table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
//		table.setSpacingBefore(10);
//		
//		// define font for table header row
//		Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(BaseColor.WHITE);
//		
//		// define table header cell
//		PdfPCell cell = new PdfPCell();
//		cell.setBackgroundColor(BaseColor.BLUE);
//		cell.setPadding(5);
//		
//		// write table header 
//		cell.setPhrase(new Phrase("Book Title", font));
//		table.addCell(cell);
//		
//		cell.setPhrase(new Phrase("Author", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("ISBN", font));
//		table.addCell(cell);
//		
//		cell.setPhrase(new Phrase("Published Date", font));
//		table.addCell(cell);
//		
//		cell.setPhrase(new Phrase("Price", font));
//		table.addCell(cell);		
//		
//		
//		doc.add(table);
		
	}

}