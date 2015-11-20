function carga_reporte() {
	
	vcCaso = "Todos";
	
	vdtFechaIni = null;
	
	vdtFechaFin = null;
	
	vcReferencia = null;
	
	vcConcepto = null;

	

	$.ajax({
		type : "GET",
		url : "cbPagoReporte/pagos",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			
			ipcCaso : vcCaso,			
			ipdtFechaIni : vdtFechaIni,
			ipdtFechaFin : vdtFechaFin,
			ipcReferencia : vcReferencia,
			ipcConcepto : vcConcepto
			
			
		},
		success : function(data, textStatus, jqXHR) {
			
			$("#mytable> tbody").empty();
			
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>'
						+ '<td>' + data[item].iIdPago + '</td>'  
						+ '<td>' + data[item].deMontoPago + '</td>'
						+ '<td>' + data[item].dtFechaPago + '</td>'						
						+ '<td>' + data[item].cReferencia + '</td>'
						+ '<td>' + data[item].cConcepto + '</td>'
						+ '<td>' + data[item].lEstado + '</td>'							
						+ '</tr>');

			}


			

		},
		error : function() {
			alert("erro al ejecutar el reporte" + textStatus);
		}

	});

}

