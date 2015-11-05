package com.sinergitec.ischool.pdf;

import java.util.ArrayList;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container

		ctAlumno obj = (ctAlumno) model.get("ctAlumno");
		ArrayList<ctGrupo> listaGrupo = (ArrayList<ctGrupo>) model.get("listaGrupo");
		
		System.out.println("referencia " + obj.getcReferencia());

		PdfPTable tablaPDF = new PdfPTable(1); // 1 columns.

		Font fuenteTitulo = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
		Font fuenteForm = new Font(Font.FontFamily.HELVETICA, 16);
		Font fuentetSub = new Font(Font.FontFamily.UNDEFINED, 16, Font.BOLD);
		Font fuenteTabla = new Font(Font.FontFamily.UNDEFINED, 13, Font.BOLD);

		PdfPCell cellTitulo = new PdfPCell(new Paragraph("Seminario del Taller Coreografico Universitario", fuenteTitulo));
		PdfPCell cellForm = new PdfPCell(new Paragraph("Inscripcion", fuenteForm));
		PdfPCell cellSub1 = new PdfPCell(new Paragraph("Datos Del Alumno:", fuentetSub));
		PdfPCell cellSub2 = new PdfPCell(new Paragraph("Domicilio:", fuentetSub));
		PdfPCell cellSub3 = new PdfPCell(new Paragraph("Cursos:", fuentetSub));
		PdfPCell cellSub4 = new PdfPCell(new Paragraph("Datos Bancarios:", fuentetSub));
		cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellForm.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellSub1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellSub2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellSub3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellSub4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
		PdfPTable tablaDatos = new PdfPTable(2);
		tablaDatos.addCell(new Phrase("Nombre(s): "));
		tablaDatos.addCell(obj.getcNombre());
		tablaDatos.addCell(new Phrase("Apellidos: "));
		tablaDatos.addCell(obj.getcApellido());
		tablaDatos.addCell(new Phrase("Edad: "));
		tablaDatos.addCell(obj.getcEdad());		
		tablaDatos.addCell(new Phrase("Telefono: "));
		tablaDatos.addCell(obj.getcTel());
		tablaDatos.addCell(new Phrase("Telefono de emergencias: "));
		tablaDatos.addCell(obj.getcTelEmergencia());
		tablaDatos.addCell(new Phrase("Sexo: "));
		tablaDatos.addCell(obj.getcGenero());
		tablaDatos.addCell(new Phrase("Correo: "));
		tablaDatos.addCell(obj.getcCorreo());		
		
		tablaDatos.addCell(new Phrase("Alergias: "));
		if (obj.getlAlergia())
			tablaDatos.addCell(obj.getcAlergia());
		else
			tablaDatos.addCell("No");
		
		tablaDatos.addCell(new Phrase("Medicamentos: "));
		if(obj.getlMedicamento())
			tablaDatos.addCell(obj.getcMedicamento());
		else
			tablaDatos.addCell("No");
		
		tablaDatos.addCell(new Phrase("Lesiones: "));
		if(obj.getlLesion())
			tablaDatos.addCell(obj.getcLesion());
		else
			tablaDatos.addCell("No");
		
		tablaDatos.addCell(new Phrase("Tratamientos: "));
		if(obj.getlTratamiento())
			tablaDatos.addCell(obj.getcTratamiento());
		else
			tablaDatos.addCell("No");
		
		tablaDatos.addCell(new Phrase("Seguro: "));
		if(obj.getlSeguro())
			tablaDatos.addCell("Si");
		else
			tablaDatos.addCell("No");
		

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

		PdfPTable tituloDom = new PdfPTable(1);
		tituloDom.addCell(cellSub2);

		PdfPTable tituloCurso = new PdfPTable(1);
		tituloCurso.addCell(cellSub3);

		double vdeTotal = 0;
		PdfPTable tablaCurso = new PdfPTable(4);
		tablaCurso.addCell(new Phrase("Curso", fuenteTabla));
		tablaCurso.addCell(new Phrase("Grupo", fuenteTabla));
		tablaCurso.addCell(new Phrase("Horario", fuenteTabla));
		tablaCurso.addCell(new Phrase("Precio", fuenteTabla));
		for (ctGrupo objGrupo : listaGrupo) {
			tablaCurso.addCell(objGrupo.getCurso().getcNombre());
			tablaCurso.addCell(objGrupo.getcNombre());
			tablaCurso.addCell(objGrupo.getcHorario());
			tablaCurso.addCell(objGrupo.getCurso().getDePrecio().toString());
			vdeTotal += objGrupo.getCurso().getDePrecio().doubleValue();
		}

		PdfPCell cellTotal = new PdfPCell(new Paragraph(Double.toString(vdeTotal), fuenteTabla));
		cellTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPTable tablaTotal = new PdfPTable(2);
		tablaTotal.addCell(new Phrase("Total($):", fuenteTabla));
		tablaTotal.addCell(cellTotal);

		tablaPDF.addCell(cellTitulo);
		tablaPDF.addCell(cellForm);
		tablaPDF.addCell(cellSub1);
		
		tablaPDF.setWidthPercentage(100);
		tablaDatos.setWidthPercentage(100);
		tituloDom.setWidthPercentage(100);
		tablaDomicilio.setWidthPercentage(100);
		tituloCurso.setWidthPercentage(100);
		tablaCurso.setWidthPercentage(100);
		tablaTotal.setWidthPercentage(100);

		doc.add(tablaPDF);
		doc.add(tablaDatos);
		doc.add(tituloDom);
		doc.add(tablaDomicilio);
		doc.add(tituloCurso);
		doc.add(tablaCurso);
		doc.add(tablaTotal);

	}

}
