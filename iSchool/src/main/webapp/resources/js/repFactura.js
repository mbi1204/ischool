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
						+ '<td>' + '<button class="pure-button pure-button-primary" onclick="get_GeneraCFDI('+ data[item].iFolio + ', ' + data[item].iSerie + ', ' + data[item].deSaldo + ');">'
						+ 'CFDI </button> </td>'
						+ '<td>' + '<a class="pure-button pure-button-primary" href= "GeneraCfdi/getPDF/' +  data[item].iFolio  + '&' +   data[item].iSerie + '" >'	+ 'PDF'
						+ '</a> </td>'
						+ '<td>' + '<a class="pure-button pure-button-primary" href= "GeneraCfdi/getXML/' +  data[item].iFolio  + '&' +   data[item].iSerie + '" >'	+ 'XML'
						+ '</a> </td>'
						
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


function get_GeneraCFDI(viFolio, viSerie, vdeSaldo){
	
	var opcion = confirm("Desea generar el CFDI?");
	
	if(!opcion)
		return;
	
	if(vdeSaldo !== 0){
		alert("El CFDI no se puede generar mientras tenga saldo existente");
		return;		
	}
	
	
	
	
	$.ajax({
		type : "GET",
		url : "GeneraCfdi/add",	
		data : {
			viFolio : viFolio,
			viSerie : viSerie
		},
		success : function(reponse) {
			alert(reponse );	
			

		},
		error : function(xhr, status, error) {
			alert(xhr.responseText);
		}

	});
	
}


function get_PDF(viFolio, viSerie){
	$.ajax({
		type : "GET",
		url : "GeneraCfdi/getPDF",	
		data : {
			viFolio : viFolio,
			viSerie : viSerie
		},
		success : function(response) {
		/*	alert(response );*/
			
			 var blob=new Blob([response]);
			    var link=document.createElement('a');
			    link.href=window.URL.createObjectURL(blob);
			    link.download="output.pdf";
			    link.click();
		},
		error : function(xhr, status, error) {
			alert(xhr.responseText);
		}

	});
	
}

function get_XML(viFolio, viSerie){
	$.ajax({
		type : "POST",
		url : "GeneraCfdi/getXML",	
		data : {
			viFolio : viFolio,
			viSerie : viSerie
		},
		success : function(reponse) {
			alert(reponse );	

		},
		error : function(xhr, status, error) {
			alert(xhr.responseText);
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
		$('#ctAlumnoDialog').dialog({			
			
			autoOpen : false,
			position : 'center',
			modal : true,
			resizable : false,
			width : 800,
			buttons : {
				"Guardar" : function() {
					validaCampos();
//					$('#ctAlumnoDialog').submit();
				},
				"Cancelar" : function() {
					$(this).dialog('close');
				}
			},
			close : function() {

				$(this).dialog('close');
			},
			open : function(){
				cargaDialogo();
			}
		});
		
		//dialogo de localidades
		$('#ctLocalidadesRepFact_Dialog').dialog({
			
			autoOpen : false,
			position : 'bottom',
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
		
		$('#tableLoc').on(
				'dblclick',
				'tr',
				function() {
					$(this).addClass('selected').siblings().removeClass(
							'selected');
					// var value = $(this).find('td:fisrt').html();

					$('#ctAlumnoDialog input#cColoniaFiscal').val(
							$(this).closest("tr").find(".cLocalidad")
									.text());
					$('#ctAlumnoDialog input#cMunicipioFiscal').val(
							$(this).closest("tr").find(".cNomMunicipio")
									.text());
					$('#ctAlumnoDialog input#cEstadoFiscal').val(
							$(this).closest("tr").find(".cNomEstado")
									.text());
					$("#ctLocalidadesRepFact_Dialog").dialog('close');

				});
});


function alumno_dialogo(ipiAlumno){
	
	$.get("repFactura/alumno/" + ipiAlumno, function(result) {
		
		//alert (result);	
		
		$("#ctAlumnoDialog").html(result);
		$("#ctAlumnoDialog").dialog("option", "title", 'Editar Alumno');
		$("#ctAlumnoDialog").dialog('open');		
	});	
	
}

function showFactura(){
	
	if(!$('input:radio[id=cliente]:checked').val()){
		$('.factura').hide();		
	}else{
		$('.factura').show();
	}
	
}

function validaCampos(){
	
	if($('input:radio[id=cliente]:checked').val()){
		
		if($('#ctAlumnoDialog input#cRfcFiscal').val() == ""){
			alert("Es necesario ingresar el RFC");
			$('#ctAlumnoDialog input#cRfcFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cNombreFiscal').val() == ""){
			alert("Es necesario ingresar la razon social");
			$('#ctAlumnoDialog input#cNombreFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cCalleFiscal').val() == ""){
			alert("Es necesario ingresar la calle");
			$('#ctAlumnoDialog input#cCalleFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cNumeroFiscal').val() == ""){
			alert("Es necesario ingresar el numero exterior");
			$('#ctAlumnoDialog input#cNumeroFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cNumeroIntFiscal').val() == ""){
			alert("Es necesario ingresar el numero interior");
			$('#ctAlumnoDialog input#cNumeroIntFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cCPFiscal').val() == ""){
			alert("Es necesario ingresar el codigo postal");
			$('#ctAlumnoDialog input#cCPFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cColoniaFiscal').val() == ""){
			alert("Es necesario ingresar la colonia");
			$('#ctAlumnoDialog input#cColoniaFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cMunicipioFiscal').val() == ""){
			alert("Es necesario ingresar el municipio");
			$('#ctAlumnoDialog input#cMunicipioFiscal').focus();
			return false;
			
		}if($('#ctAlumnoDialog input#cEstadoFiscal').val() == ""){
			alert("Es necesario ingresar el estado");
			$('#ctAlumnoDialog input#cEstadoFiscal').focus();
			return false;
		}		
	}

	$('#ctAlumnoDialog').submit();
}

function cargaDialogo(){
	
	if(!$('input:radio[id=cliente]:checked').val()){
		$('.factura').hide();		
	}else{
		$('.factura').show();
	}
	
}

function get_localidad() {
	
	vcCp = $('#ctAlumnoDialog input#cCPFiscal').val();

	$.ajax({
		type : "GET",
		url : "repFactura/getLocalidad",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			cCP : vcCp
		},
		success : function(data, textStatus, jqXHR) {

			if (data.length == 1) {
				for ( var item in data) {
					$('#ctAlumnoDialog input#cColoniaFiscal').val(
							data[item].cLocalidad);
					$('#ctAlumnoDialog input#cMunicipioFiscal').val(
							data[item].cNomMunicipio);
					$('#ctAlumnoDialog input#cEstadoFiscal')
							.val(data[item].cNomEstado);
				}

			} else if (data.length > 1) {

				$("#tableLoc > tbody").empty();

				for ( var item in data) {

					$('#tableLoc > tbody').append(
							'<tr>' + '<td class ="cLocalidad">'
									+ data[item].cLocalidad + '</td>'
									+ '<td class = "cNomMunicipio">'
									+ data[item].cNomMunicipio + '</td>'
									+ '<td class = "cNomEstado">'
									+ data[item].cNomEstado + '</td>' + '<td>'
									+ '</tr>');
				}

				$('#ctLocalidadesRepFact_Dialog').dialog("option", "title", 'Localidades (Doble clic Seleccionar)');
				$('#ctLocalidadesRepFact_Dialog').dialog('open');
			}

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});

}






