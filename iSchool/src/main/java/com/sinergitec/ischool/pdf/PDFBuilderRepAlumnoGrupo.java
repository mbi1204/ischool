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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilderRepAlumnoGrupo extends AbstractITextPdfView {
	
	private String grupo;
	private int pages;
	
	public class HeaderFooterPageEvent extends PdfPageEventHelper {
				
	    public void onStartPage(PdfWriter writer,Document document) {
	    	pages += 1;	    	
	        
	    }
	    public void onEndPage(PdfWriter writer,Document document) {
	    	Rectangle rect = writer.getBoxSize("art");
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase(grupo), rect.getRight(), rect.getBottom(), 0);
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Pagina " + pages), rect.getLeft(), rect.getBottom(), 0);
	        
	    }
	} 
	 

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		ArrayList<ctAlumno> listaAlumno = (ArrayList<ctAlumno>)model.get("listaAlumno");
		grupo = (String)model.get("grupo");		
		
		PdfPTable tablaPDF = new PdfPTable(11); // 11 columns.
		Font fuenteTabla = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
		Font fuenteCelda = new Font(Font.FontFamily.UNDEFINED, 11);				
		
		tablaPDF.addCell(new Phrase("Nombre", fuenteTabla));
		tablaPDF.addCell(new Phrase("Apellido", fuenteTabla));
		tablaPDF.addCell(new Phrase("Fecha De Nacimiento", fuenteTabla));
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
			tablaPDF.addCell(new Phrase(ctAlumno.getcEdad(), fuenteCelda));
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
        Rectangle rect = new Rectangle(60, 30, 600, 800);
        writer.setBoxSize("art", rect);
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);
        doc.setPageSize(PageSize.A4.rotate());        
		doc.open();
		doc.add(tablaPDF);
		doc.close();
		pages = 0;		
		
	}

}
