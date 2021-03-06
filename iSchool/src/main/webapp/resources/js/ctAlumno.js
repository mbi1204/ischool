/**
 * 
 */

function Add_curso() {

	var descuento;
	var total;

	vid = $('select#idGrupo option:selected').val();

	vlExiste = false;
	vdetotal = 0;

	$.each($("#mytable tbody").find("tr"), function() {
		if ($(this).closest("tr").find(".id_Grupo").text() == vid) {
			vlExiste = true;
			alert("el curso ya fue registrado");
		}
	});

	if (vlExiste)
		return;

	if ($('#Form_ctAlumno input#deDescuento').val() != "")
		descuento = $('#Form_ctAlumno input#deDescuento').val();
	else
		descuento = 0;

	$.ajax({
				type : "GET",
				url : "ctAlumno/getGrupo",
				data : {
					id : vid
				},
				success : function(data, textStatus, jqXHR) {
					
					var cDias = data.cDias;

					$('#mytable > tbody').append('<tr>' 
											+ '<td class="id_Grupo">'
											+ data.iIdGrupo
											+ '</td>'
											+ '<td class="cNombre_Grupo">'
											+ data.cNombre
											+ '</td>'
											+ '<td class="id_Curso">'
											+ data.curso.iIdCurso
											+ '</td>'
											+ '<td class="cNombre_Curso">'
											+ data.curso.cNombre
											+ '</td>'
											+ '<td class="cHorario">'
											+ data.cHorario
											+ '</td>'
											+ '<td class="dePrecio">'
											+ parseFloat(data.curso.dePrecio).toFixed(2)
											+ '</td>'
											+ '<td class="deDescuento">'
											+ parseFloat(data.curso.dePrecio * (descuento / 100)).toFixed(2)
											+ '</td>'
											+ '<td class="dePrecioReal">'
											+ parseFloat(data.curso.dePrecio - (data.curso.dePrecio * (descuento / 100))).toFixed(2)
											+ '</td>'
											+ '<td>'
											+ '<button class="btnDelete" onclick="Borrar();" style="background-color:#FF4000; color:black;">Quitar</button>'
											+ '</td> </tr>');

					calculaTotal();

					$("#mytable > tfoot").empty();
					$('#mytable > tfoot').append(
							'<TR> <TH ALIGN=LEFT COLSPAN=7>Total a Pagar</TH> <TH>'
									+ vdetotal.toFixed(2) + '</TH> </TR>');

					/* agregar json curso */
					generaJson(cDias);

				},
				error : function() {
					alert('error ');
				}

			});

}

function Borrar() {

	$("#mytable").on(
			'click',
			'.btnDelete',
			function() {
				$(this).closest('tr').remove();

				$("#mytable > tfoot").empty();

				calculaTotal();

				if (vdetotal > 0) {
					$('#mytable > tfoot').append(
							'<TR> <TH ALIGN=LEFT COLSPAN=7>Total a Pagar</TH> <TH>'
									+ vdetotal.toFixed(2) + '</TH> </TR>');
				}

				/* agregar json curso */
				generaJson();

			});

}

var generaJson = function(cDias) {

	var dataArray = new Array();

	function dataRow(id_Grupo, cNombre_Grupo, id_Curso, cNombre_Curso,
			cHorario, dePrecio, cDias) {
		this.id_Grupo = id_Grupo;
		this.cNombre_Grupo = cNombre_Grupo;
		this.cNombre_Curso = cNombre_Curso;
		this.cHorario = cHorario;
		this.dePrecio = dePrecio;
		this.id_Curso = id_Curso;
		this.cDias = cDias;	
	}

	$.each($("#mytable tbody").find("tr"), function() {
		dataArray.push(new dataRow($(this).closest("tr").find(".id_Grupo")
				.text(), $(this).closest("tr").find(".cNombre_Grupo").text(),
				$(this).closest("tr").find(".id_Curso").text(), $(this)
						.closest("tr").find(".cNombre_Curso").text(), $(this)
						.closest("tr").find(".cHorario").text(), $(this)
						.closest("tr").find(".dePrecioReal").text(),
						cDias));

	});
	var sJson = JSON.stringify(dataArray);
	if (sJson == "" || sJson == "[]") {
		$('#Form_ctAlumno input#deDescuento').prop('readonly', false);		
	}else{
		$('#Form_ctAlumno input#deDescuento').prop('readonly', true);
	}
	$("#cGrupo").val(sJson);

};

var calculaTotal = function() {

	vdetotal = 0;
	$.each($("#mytable tbody").find("tr"),
			function() {
				vdetotal = vdetotal
						+ parseFloat($(this).closest("tr")
								.find(".dePrecioReal").text());
			});

};

function get_localidad() {

	vcCp = $('#Form_ctAlumno input#cCP').val();

	$.ajax({
		type : "GET",
		url : "ctAlumno/getLocalidad",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			cCP : vcCp
		},
		success : function(data, textStatus, jqXHR) {

			if (data.length == 1) {
				for ( var item in data) {
					$('#Form_ctAlumno input#cColonia').val(
							data[item].cLocalidad);
					$('#Form_ctAlumno input#cMunicipio').val(
							data[item].cNomMunicipio);
					$('#Form_ctAlumno input#cEstado')
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

				$('#Localidades_Dialog').dialog("option", "title",
						'Localidades (Doble clic Seleccionar)');
				$('#Localidades_Dialog').dialog('open');
			}

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});
}

function get_localidadFactura() {

	vcCp = $('#Form_ctAlumno input#cCPFiscal').val();

	$.ajax({
		type : "GET",
		url : "ctAlumno/getLocalidad",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			cCP : vcCp
		},
		success : function(data, textStatus, jqXHR) {

			if (data.length == 1) {
				for ( var item in data) {
					$('#Form_ctAlumno input#cColoniaFiscal').val(
							data[item].cLocalidad);
					$('#Form_ctAlumno input#cMunicipioFiscal').val(
							data[item].cNomMunicipio);
					$('#Form_ctAlumno input#cEstadoFiscal').val(
							data[item].cNomEstado);
				}

			} else if (data.length > 1) {

				$("#tableLocFac > tbody").empty();

				for ( var item in data) {

					$('#tableLocFac > tbody').append(
							'<tr>' + '<td class ="cLocalidadFiscal">'
									+ data[item].cLocalidad + '</td>'
									+ '<td class = "cNomMunicipioFiscal">'
									+ data[item].cNomMunicipio + '</td>'
									+ '<td class = "cNomEstadoFiscal">'
									+ data[item].cNomEstado + '</td>' + '<td>'
									+ '</tr>');
				}

				$('#LocalidadesFac_Dialog').dialog("option", "title",
						'Localidades (Doble clic Seleccionar)');
				$('#LocalidadesFac_Dialog').dialog('open');
			}

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});
}

$(document).ready(
		function() {

			$('#Localidades_Dialog').dialog({

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

			$('#tableLoc').on(
					'dblclick',
					'tr',
					function() {
						$(this).addClass('selected').siblings().removeClass(
								'selected');
						// var value = $(this).find('td:fisrt').html();

						$('#Form_ctAlumno input#cColonia').val(
								$(this).closest("tr").find(".cLocalidad")
										.text());
						$('#Form_ctAlumno input#cMunicipio').val(
								$(this).closest("tr").find(".cNomMunicipio")
										.text());
						$('#Form_ctAlumno input#cEstado').val(
								$(this).closest("tr").find(".cNomEstado")
										.text());
						$("#Localidades_Dialog").dialog('close');

					});

			$('#LocalidadesFac_Dialog').dialog({

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

			$('#tableLocFac').on(
					'dblclick',
					'tr',
					function() {

						$(this).addClass('selected').siblings().removeClass(
								'selected');
						// var value = $(this).find('td:fisrt').html();

						$('#cColoniaFiscal').val(
								$(this).closest("tr").find(".cLocalidadFiscal")
										.text());
						$('#cMunicipioFiscal').val(
								$(this).closest("tr").find(
										".cNomMunicipioFiscal").text());
						$('#cEstadoFiscal').val(
								$(this).closest("tr").find(".cNomEstadoFiscal")
										.text());
						$("#LocalidadesFac_Dialog").dialog('close');

					});

		});

function validaCampos() {

	if ($('#Form_ctAlumno input#cNombre').val() == "") {
		alert("El nombre debe tener un valor");
		$('#Form_ctAlumno input#cNombre').focus();
		return false;

	}
	if ($('#Form_ctAlumno input#cApellido').val() == "") {
		alert("El Apellido debe tener un valor");
		$('#Form_ctAlumno input#cApellido').focus();
		return false;

	}
	if ($('#Form_ctAlumno input#cEdad').val() == "") {
		alert("la edad debe tener un valor");
		$('#Form_ctAlumno input#cEdad').focus();
		return false;

	}	
	
	if ($('#checkAlergia').is(':checked') && $('#Form_ctAlumno textarea#cAlergia').val() == ""){
		alert("Debe describir la alergia");
		$('#Form_ctAlumno textarea#cAlergia').focus();
		return false;
	}
	
	if ($('#checkMedicamento').is(':checked') && $('#Form_ctAlumno textarea#cMedicamento').val() == ""){
		alert("Debe describir el medicamento");
		$('#Form_ctAlumno textarea#cMedicamento').focus();
		return false;
	}
	
	if ($('#checkLesion').is(':checked') && $('#Form_ctAlumno textarea#cLesion').val() == ""){
		alert("Debe describir la lesion");
		$('#Form_ctAlumno textarea#cLesion').focus();
		return false;
	}
	
	if ($('#checkTratamiento').is(':checked') && $('#Form_ctAlumno textarea#cTratamiento').val() == ""){
		alert("Debe describir el tratamiento");
		$('#Form_ctAlumno textarea#cTratamiento').focus();
		return false;
	}
	
	
	if($('#Form_ctAlumno input#deDescuento').val() != "0"){
		if($('#Form_ctAlumno textarea#cMotivoDesc').val() == ""){
			alert("Debe describir el motivo del descuento");
			$('#Form_ctAlumno textarea#cMotivoDesc').focus();
			return false;	
		}			
	}
	
	if($('#lFactura').is(':checked')){
		
		if($('#Form_ctAlumno input#cRfcFiscal').val() == ""){
			alert("Es necesario ingresar el RFC");
			$('#Form_ctAlumno input#cRfcFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cNombreFiscal').val() == ""){
			alert("Es necesario ingresar la razon social");
			$('#Form_ctAlumno input#cNombreFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cCalleFiscal').val() == ""){
			alert("Es necesario ingresar la calle");
			$('#Form_ctAlumno input#cCalleFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cNumeroFiscal').val() == ""){
			alert("Es necesario ingresar el numero exterior");
			$('#Form_ctAlumno input#cNumeroFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cNumeroIntFiscal').val() == ""){
			alert("Es necesario ingresar el numero interior");
			$('#Form_ctAlumno input#cNumeroIntFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cCPFiscal').val() == ""){
			alert("Es necesario ingresar el codigo postal");
			$('#Form_ctAlumno input#cCPFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cColoniaFiscal').val() == ""){
			alert("Es necesario ingresar la colonia");
			$('#Form_ctAlumno input#cColoniaFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cMunicipioFiscal').val() == ""){
			alert("Es necesario ingresar el municipio");
			$('#Form_ctAlumno input#cMunicipioFiscal').focus();
			return false;
			
		}if($('#Form_ctAlumno input#cEstadoFiscal').val() == ""){
			alert("Es necesario ingresar el estado");
			$('#Form_ctAlumno input#cEstadoFiscal').focus();
			return false;
		}		
	}
	
	if ($("#cGrupo").val() == "" || $("#cGrupo").val() == "[]") {
		alert("Debe Inscribrise Por Lo Menos En Un Grupo");
		return false;
	}

	return true;
}

function factura() {

	if ($('#lFactura').is(':checked')) {		
		$('#formFactura').show();		 
	} else {
		$('#formFactura').hide();
	}
}


function carga() {
	
	if($('#Form_ctAlumno input#cApellido').val() != "" && $('#Form_ctAlumno input#cNombre').val() != "" && $('#Form_ctAlumno input#cEdad').val() != "")
		location.reload();

	$('#formFactura').hide();
	$('#textAlergia').hide();
	$('#textMedicamento').hide();
	$('#textLesion').hide();
	$('#textTratamiento').hide();
	$('#Form_ctAlumno input#cNombre').focus();

}

function showAlergia() {	

	if ($('#checkAlergia').is(':checked'))
		$('#textAlergia').show();		
	else
		$('#textAlergia').hide();

}

function showMedicamento() {

	if ($('#checkMedicamento').is(':checked'))
		$('#textMedicamento').show();
	else
		$('#textMedicamento').hide();

}

function showLesion() {

	if ($('#checkLesion').is(':checked'))
		$('#textLesion').show();
	else
		$('#textLesion').hide();

}

function showTratamiento() {

	if ($('#checkTratamiento').is(':checked'))
		$('#textTratamiento').show();
	else
		$('#textTratamiento').hide();

}
