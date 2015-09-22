/**
 * 
 */

function Add_curso() {

	
		
	vid = $('select#idGrupo option:selected').val();
	
	vlExiste  = false;
	
	
	
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
					+ '<td  class="grupoid" >' 
					+ data.iIdGrupo
					+ '</td>'
					+ '<td>'
					+ data.cNombre
					+ '</td>'
					+ '<td>'
					+ data.curso.cNombre
					+ '</td>'
					+ '<td>'
					+ data.cHorario
					+ '</td>'
					+ '<td>'
					+ data.curso.dePrecio
					+ '</td>'
					+ '<td>'
					+ '<button class="btnDelete" onclick="Borrar();">Quitar</button>'
					+ '</td> </tr>');
			
				},
				error : function() {
					alert('error ');
				}
			});


}




function Borrar(){
	  
	 $("#mytable").on('click','.btnDelete',function(){			 
		$(this).closest('tr').remove();
     });
	
}
