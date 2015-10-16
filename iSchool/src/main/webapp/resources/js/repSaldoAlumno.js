function carga_repAlumno(viIdGrupo) {

	

	$.ajax({
		type : "GET",
		url : "repSaldoAlumno/getAlumnos",
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
						+ '<td>' + data[item].cTel + '</td>'
						+ '<td>' + data[item].cCorreo + '</td>'
						+ '<td>' + data[item].deSaldo + '</td>'
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




