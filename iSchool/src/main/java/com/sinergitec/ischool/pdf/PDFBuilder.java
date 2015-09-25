package com.sinergitec.ischool.pdf;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
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
		
		
		ctAlumno obj = (ctAlumno ) model.get("ctAlumno");
		
		Font fontTitulo = new Font(Font.FontFamily.HELVETICA  , 22, Font.BOLD);
		Font fontCampo = new Font(Font.FontFamily.HELVETICA  , 16);
		Font fontValor = new Font(Font.FontFamily.TIMES_ROMAN  , 16);		
		Chunk tab = new Chunk("     ");
		Paragraph p = new Paragraph("");
		
		doc.add(new Paragraph("Datos Personales. ", fontTitulo));
		
		doc.add(tab);
		doc.add(new Phrase("Nombre: ", fontCampo));
		doc.add(new Phrase(obj.getcNombre(), fontValor));
		doc.add(p);		
		
		doc.add(tab);
		doc.add(new Phrase("Apellidos: ", fontCampo));
		doc.add(new Phrase(obj.getcApellido(), fontValor));
		doc.add(p);
		
		doc.add(tab);
		doc.add(new Phrase("Fecha de Nacimiento: ", fontCampo));
		doc.add(new Phrase(obj.getDtFechaNac(), fontValor));
		doc.add(p);
		
		doc.add(tab);
		doc.add(new Phrase("Telefono: ", fontCampo));
		doc.add(new Phrase(obj.getcTel(), fontValor));
		doc.add(p);
		
		doc.add(tab);
		doc.add(new Phrase("Correo: ", fontCampo));
		doc.add(new Phrase(obj.getcCorreo(), fontValor));
		doc.add(p);
		
		doc.bottomMargin();
		
		
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
//		
//		
//		 PdfPTable table = new PdfPTable(3); // 3 columns.
//
//         PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//         PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//         PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//
//         table.addCell(cell1);
//         table.addCell(cell2);
//         table.addCell(cell3);
//
//         doc.add(table);
		
		
		
		
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
