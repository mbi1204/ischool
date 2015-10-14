package com.sinergitec.ischool.pdf;

import java.util.ArrayList;
import java.util.Map;
import com.sinergitec.ischool.model.ct.ctAlumno;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilderRepAlumnoGrupo extends AbstractITextPdfView {
	
	 public class Rotate extends PdfPageEventHelper {
	        protected PdfNumber rotation = PdfPage.LANDSCAPE;
	        public void setRotation(PdfNumber rotation) {
	            this.rotation = rotation;
	        }
	        public void onEndPage(PdfWriter writer, Document document) {
	            writer.addPageDictEntry(PdfName.ROTATE, rotation);
	        }
	    }

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Rotate rotation = new Rotate();
		rotation.setRotation(PdfPage.INVERTEDPORTRAIT);
		ArrayList<ctAlumno> listaAlumno = (ArrayList<ctAlumno>)model.get("listaAlumno");
		
		PdfPTable tablaPDF = new PdfPTable(11); // 11 columns.
		Font fuenteTabla = new Font(Font.FontFamily.UNDEFINED, 8, Font.BOLD);
		Font fuenteCelda = new Font(Font.FontFamily.UNDEFINED, 7);
		
		
		tablaPDF.addCell(new Phrase("Nombre", fuenteTabla));
		tablaPDF.addCell(new Phrase("Apellido", fuenteTabla));
		tablaPDF.addCell(new Phrase("Nacimiento", fuenteTabla));
		tablaPDF.addCell(new Phrase("Calle", fuenteTabla));
		tablaPDF.addCell(new Phrase("Num. Ext", fuenteTabla));
		tablaPDF.addCell(new Phrase("Num. Int", fuenteTabla));
		tablaPDF.addCell(new Phrase("Colonia", fuenteTabla));
		tablaPDF.addCell(new Phrase("CP", fuenteTabla));
		tablaPDF.addCell(new Phrase("Municipio", fuenteTabla));
		tablaPDF.addCell(new Phrase("Estado", fuenteTabla));
		tablaPDF.addCell(new Phrase("Telefono", fuenteTabla));
		
		for (ctAlumno ctAlumno : listaAlumno) {
			tablaPDF.addCell(new Phrase(ctAlumno.getcNombre(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcApellido(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getDtFechaNac(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcCalle(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcNumExt(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcNumInt(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcColonia(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcCP(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcMunicipio(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcEstado(), fuenteCelda));
			tablaPDF.addCell(new Phrase(ctAlumno.getcTel(), fuenteCelda));
		}
		
		tablaPDF.setWidthPercentage(100);
		
		
		doc.add(tablaPDF);
		
	}

}
