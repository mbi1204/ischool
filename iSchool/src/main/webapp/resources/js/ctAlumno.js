/**
 * 
 */

function Add_curso() {
		
	vid = $('select#idGrupo option:selected').val();	
	
	vlExiste  = false;
	vdetotal  = 0;	
	
	
	 $.each($("#mytable tbody").find("tr"), function () {
		 			
		if( $(this).closest("tr").find(".grupoid").text() == vid ){			
			vlExiste = true;			
			alert ("el curso ya fue registrado");
		}  
	 });	 
	 
	 
	 if (vlExiste)  return;	

	$.ajax({
		type : "GET",
		url : "ctAlumno/getGrupo",
		data : {
			id : vid
		},
		success : function(data, textStatus, jqXHR) {		
			
			$('#mytable > tbody')
			.append(
					'<tr>'	
					+ '<td>'
					+ data.iIdGrupo
					+ '</td>'
					+ '<td>'
					+ data.curso.cNombre
					+ '</td>'
					+ '<td>'
					+ data.cNombre
					+ '</td>'					
					+ '<td>'
					+ data.cHorario
					+ '</td>'
					+ '<td class="dePrecio">'
					+ data.curso.dePrecio
					+ '</td>'
					+ '<td>'
					+ '<button class="btnDelete" onclick="Borrar();" style="background-color:#FF4000; color:black;">Quitar</button>'
					+ '</td> </tr>');			
			
		
			 vdetotal = 0 ;
			 $.each($("#mytable tbody").find("tr"), function () {
				 vdetotal = vdetotal  + parseInt($(this).closest("tr").find(".dePrecio").text());					 
				 
			 });
			 
			 $("#mytable > tfoot").empty();		
			 $('#mytable > tfoot').append('<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>' + vdetotal + '</TH> </TR>');
			 
		
			 
		},
		error : function() {
			alert('error ');
		}
		
	});

}


function Borrar(){	

	 $("#mytable").on('click','.btnDelete',function(){
		 $(this).closest('tr').remove();
		
		 vdetotal = 0 ;
		 $("#mytable > tfoot").empty();
		 
		 $.each($("#mytable tbody").find("tr"), function () { 
			 vdetotal = vdetotal  + parseInt($(this).closest("tr").find(".dePrecio").text());			 
		 });	 	 
		
		 if (vdetotal > 0) {
			 $('#mytable > tfoot').append('<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>' + vdetotal +'</TH> </TR>');	 
		 }		 
		 
	 });
}