package com.sinergitec.ischool.pdf;

import java.util.ArrayList;
import java.util.Map;
import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilderRepSaldoAlumno extends AbstractITextPdfView {
	
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
		
		System.out.println("pdf");
		
		@SuppressWarnings("unchecked")
		ArrayList<cbAlumnoSaldo> listaAlumno = (ArrayList<cbAlumnoSaldo>)model.get("listaAlumno");
		grupo = (String)model.get("grupo");		
		
		PdfPTable tablaPDF = new PdfPTable(5); // 5 columns.
		Font fuenteTabla = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
		Font fuenteCelda = new Font(Font.FontFamily.UNDEFINED, 11);
		Font fuenteGrupo = new Font(Font.FontFamily.UNDEFINED, 24);		
		
		tablaPDF.addCell(new Phrase("Nombre", fuenteTabla));
		tablaPDF.addCell(new Phrase("Apellido", fuenteTabla));
		tablaPDF.addCell(new Phrase("Telefono", fuenteTabla));
		tablaPDF.addCell(new Phrase("Email", fuenteTabla));
		tablaPDF.addCell(new Phrase("Por Pagar", fuenteTabla));
		
		
		for (cbAlumnoSaldo cbAlumno : listaAlumno) {
			tablaPDF.addCell(new Phrase(cbAlumno.getcNombre(), fuenteCelda));
			tablaPDF.addCell(new Phrase(cbAlumno.getcApellido(), fuenteCelda));			
			tablaPDF.addCell(new Phrase(cbAlumno.getcTel(), fuenteCelda));
			tablaPDF.addCell(new Phrase(cbAlumno.getcCorreo(), fuenteCelda));
			tablaPDF.addCell(new Phrase(Double.toString(cbAlumno.getDeSaldo()), fuenteCelda));
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
