function carga_repAlumno(viIdGrupo) {

	

	$.ajax({
		type : "GET",
		url : "repFactura/getAlumnos",
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
						+ '<td>' + data[item].cSerie + '</td>'
						+ '<td>' + data[item].iFolio + '</td>'
						+ '<td>' + data[item].dtFecha + '</td>'
						+ '<td>' + data[item].deDescPorc + '</td>'
						+ '<td>' + data[item].deDeSubtotal + '</td>'
						+ '<td>' + data[item].deDescMonto + '</td>'
						+ '<td>' + data[item].deIVA + '</td>'
						+ '<td>' + data[item].deTotal + '</td>'
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




