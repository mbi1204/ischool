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
						+ '<td>' + '<button class="pure-button pure-button-primary" onclick="get_detalle('+ data[item].iFolio + ', ' + data[item].iSerie + ');">'
						+ '<i class="fa fa-pencil"></i> Ver detalle </button> </td>'
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
	alert("Folio " + viFolio + " serie " + viSerie);	

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
					
					alert(data[item].cConcepto);

					$('#tableDet > tbody').append(
							'<tr>' + '<td class ="cConcepto">'
									+ data[item].cConcepto + '</td>'
									+ '<td class = "deCantidad">'
									+ data[item].deCantidad + '</td>'
									+ '<td class = "deSubTotal">'
									+ data[item].deSubTotal + '</td>'
									+ '<td class = "deMonto">'
									+ data[item].deMonto + '</td>' + '<td>'
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




