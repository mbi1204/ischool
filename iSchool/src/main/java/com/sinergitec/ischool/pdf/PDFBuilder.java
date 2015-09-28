package com.sinergitec.ischool.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
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
 * 
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container

		ctAlumno obj = (ctAlumno) model.get("ctAlumno");

		PdfPTable tablaPDF = new PdfPTable(1); // 1 columns.

		Font fuenteTitulo = new Font(Font.FontFamily.COURIER, 22, Font.BOLD);
		Font fuenteForm = new Font(Font.FontFamily.HELVETICA, 16);
		Font fontSub = new Font(Font.FontFamily.UNDEFINED, 16, Font.BOLD);

		PdfPCell cellTitulo = new PdfPCell(new Paragraph("Escuela De Danza Profesional", fuenteTitulo));
		PdfPCell cellForm = new PdfPCell(new Paragraph("Formulario De Inscripcion", fuenteForm));
		PdfPCell cellSub1 = new PdfPCell(new Paragraph("Datos Del Alumno:", fontSub));
		PdfPCell cellSub2 = new PdfPCell(new Paragraph("Domicilio:", fontSub));
		cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellForm.setHorizontalAlignment(Element.ALIGN_CENTER);

		
		PdfPTable tablaDatos = new PdfPTable(2);
		tablaDatos.addCell(new Phrase("Nombre(s): "));
		tablaDatos.addCell(obj.getcNombre());
		tablaDatos.addCell(new Phrase("Apellidos: "));
		tablaDatos.addCell(obj.getcApellido());
		tablaDatos.addCell(new Phrase("Fecha De Nacimiento: "));
		tablaDatos.addCell(obj.getDtFechaNac());
		tablaDatos.addCell(new Phrase("Telefono: "));
		tablaDatos.addCell(obj.getcTel());
		tablaDatos.addCell(new Phrase("Correo: "));
		tablaDatos.addCell(obj.getcCorreo());
		
		PdfPTable tablaDomicilio = new PdfPTable(2);
		tablaDomicilio.addCell(new Phrase("Calle: "));
		tablaDomicilio.addCell(obj.getcCalle());
		tablaDomicilio.addCell(new Phrase("Num. Ext: "));
		tablaDomicilio.addCell(obj.getcNumExt());
		tablaDomicilio.addCell(new Phrase("Num. Int: "));
		tablaDomicilio.addCell(obj.getcNumInt());
		tablaDomicilio.addCell(new Phrase("Colonia: "));
		tablaDomicilio.addCell(obj.getcColonia());
		tablaDomicilio.addCell(new Phrase("CP: "));
		tablaDomicilio.addCell(obj.getcCP());
		tablaDomicilio.addCell(new Phrase("Municipio: "));
		tablaDomicilio.addCell(obj.getcMunicipio());
		tablaDomicilio.addCell(new Phrase("Estado: "));
		tablaDomicilio.addCell(obj.getcEstado());
		
		PdfPTable tablaDom = new PdfPTable(1);
		tablaDom.addCell(cellSub2);


		tablaPDF.addCell(cellTitulo);
		tablaPDF.addCell(cellForm);
		tablaPDF.addCell(cellSub1);					

		doc.add(tablaPDF);
		doc.add(tablaDatos);		
		doc.add(tablaDom);
		doc.add(tablaDomicilio);

		

	}

}
