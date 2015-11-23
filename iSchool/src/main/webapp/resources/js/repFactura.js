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
						+ '<td>' + data[item].deSubtotal + '</td>'
						+ '<td>' + data[item].deDescMonto + '</td>'
						+ '<td>' + data[item].deIVA + '</td>'
						+ '<td>' + data[item].deTotal + '</td>'
						+ '<td>' + data[item].deSaldo + '</td>'
						+ '<td>' + '<button class="pure-button pure-button-primary" id="editar" onclick="alumno_dialogo('+ data[item].iIdAlumno + ');"">'
						+ 'Editar </button> </td>'
						+ '<td>' + '<button class="pure-button pure-button-primary" onclick="get_detalle('+ data[item].iFolio + ', ' + data[item].iSerie + ');">'
						+ 'Detalle </button> </td>'
						+ '<td>' + '<button class="pure-button pure-button-primary" ">'
						+ 'CFDI </button> </td>'
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

function get_detalle(viFolio, viSerie){

	$.ajax({
		type : "GET",
		url : "repFactura/detalle",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			iFolio : viFolio,
			iSerie : viSerie
		},
		success : function(data, textStatus, jqXHR) {
			
			if (data.length > 0) {

				$("#tableDet > tbody").empty();

				for ( var item in data) {					

					$('#tableDet > tbody').append(
							 		'<tr>' 
									+ '<td class ="cConcepto">'
									+ data[item].cConcepto + '</td>'
									+ '<td class = "deCantidad">'
									+ data[item].deCantidad + '</td>'
									+ '<td class = "deSubTotal">'
									+ data[item].deSubtotal + '</td>'
									+ '<td class = "deMonto">'
									+ data[item].deMonto + '</td>'
									+ '</tr>');
				}
				$('#Detalle_Dialog').dialog("option", "title", 'Detalle Factura');
				$('#Detalle_Dialog').dialog('open');
			}

		},
		error : function() {
			alert("error creando detalle" + textStatus);
		}

	});
}

$(document).ready(function() {	
			
		$('#Detalle_Dialog').dialog({
	
			autoOpen : false,
			position : 'center',
			modal : true,
			resizable : false,
			width : 800,
			buttons : {
				"Cancel" : function() {
					$(this).dialog('close');
				}
			},
			close : function() {
	
				$(this).dialog('close');
			}
	
		});
		
		/* abre el dialgo del alumno*/
		$('#Alumno_Dialog').dialog({			
			
			autoOpen : false,
			position : 'center',
			modal : true,
			resizable : false,
			width : 800,
			buttons : {
				"Cancel" : function() {
					$(this).dialog('close');
				}
			},
			close : function() {

				$(this).dialog('close');
			}
			
			

		});	
		
		
		
			
});



function alumno_dialogo(ipiAlumno){
	
	$.get("/repFactura/alumno/" + ipiAlumno, function(result) {
		$("#ctAlumnoDialog").html(result);
		$("#ctAlumnoDialog").dialog("option", "title", 'Editar Grupo');
		$("#ctAlumnoDialog").dialog('open');

		// initializeDatePicker();
	});	
}

function get_alumno(ipiAlumno){
	
	alert(ipiAlumno);

	$.ajax({
		type : "GET",
		url : "repFactura/alumno",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			iAlumno : ipiAlumno
		},
		success : function(data, textStatus, jqXHR) {			
			
			for ( var item in data) {
				
				alert(data[item].cNombre);
							

			}		

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});
	
}
		




