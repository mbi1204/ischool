function carga_reporte() {
	
	vcCaso = $('input:radio[name=caso]:checked').val();
	
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
				
				var estatus;
				if(data[item].lEstado) estatus = "Si";
				else estatus = "No";
				
				$('#mytable > tbody').append(
						'<tr>'
						+ '<td>' + data[item].iIdPago + '</td>'
						+ '<td>' + data[item].dtFechaPago + '</td>'
						+ '<td>' + data[item].deMontoPago + '</td>'
						+ '<td>' + data[item].cReferencia + '</td>'
						+ '<td>' + data[item].cConcepto + '</td>'
						+ '<td>' + data[item].dtFechaAplicacion + '</td>'
						+ '<td>' + data[item].deMontoXAplicar + '</td>'						
						+ '<td>' + data[item].cObs + '</td>'						
						+ '<td>' + estatus + '</td>'							
						+ '</tr>');

			}


			

		},
		error : function() {
			alert("erro al ejecutar el reporte" + textStatus);
		}

	});

}

