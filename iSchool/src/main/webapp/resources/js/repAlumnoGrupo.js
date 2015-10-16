function carga_repAlumno(viIdGrupo) {

	$.ajax({
		type : "GET",
		url : "repAlumnoGrupo/getAlumnos",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			iIdGrupo : viIdGrupo
		},
		success : function(data, textStatus, jqXHR) {
			
			$("#mytable> tbody").empty();
			
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>'
						+ '<td>' + data[item].iIdAlumno + '</td>'  
						+ '<td>' + data[item].cNombre + '</td>'
						+ '<td>' + data[item].cApellido + '</td>'
						+ '<td>' + data[item].dtFechaNac + '</td>'
						+ '<td>' + data[item].cCalle + '</td>'
						+ '<td>' + data[item].cNumExt + '</td>'
						+ '<td>' + data[item].cNumInt + '</td>'
						+ '<td>' + data[item].cColonia + '</td>'
						+ '<td>' + data[item].cCP + '</td>'
						+ '<td>' + data[item].cMunicipio + '</td>'
						+ '<td>' + data[item].cEstado + '</td>'
						+ '<td>' + data[item].cTel + '</td>'						
						+ '</tr>');

			}


			

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});
	
	 

}

function getGrupo(){	 		 
	 var vGrupo = $('select option:selected').text();	 
	 $("#grupo").val(vGrupo);
}

function carga() {
	$(document).ready(function() {
		carga_repAlumno($('select option:selected').val());
	});
}



