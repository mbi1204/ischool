function carga_ctMenu(cUsuario) {

	var errorInfo;

	$.ajax({
		type : "GET",
		url : "BuscaMenu",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : {
			cUsuario : cUsuario
		},
		success : function(data, textStatus, jqXHR) {

			$("#mytable > tbody").empty();
			$("#mytable2 > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].iIdMenu + '</td>' + '<td>'
								+ data[item].cMenu + '</td>' + '<td>'
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');

			}

		},
		error : function() {
			alert("erro al ejecutar el BuscaMenu" + textStatus);
		}

	});

}

function remove_sysMenu(iIdMenu) {
	vcUsuario = $('#cUsuario').val();

	$.ajax({
		type : "POST",
		url : "sysUsuMenu/remove",
		data : {
			cUsuario : vcUsuario,
			iIdMenu : iIdMenu
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].iIdMenu + '</td>' + '<td>'
								+ data[item].cMenu + '</td>' + '<td>'
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');
			}

		},
		error : function() {
			alert('error ');
		}
	});

}

function add_sysUsuMenu() {

	$('#Form_sysUsuMenu_ctMenu input#cUsuario').val(
			$('#Form_ctUsuario select#cUsuario').val());
	$('#AddsysUsuMenu_ctMenu').dialog("option", "title", 'Agregar Menu');
	$('#AddsysUsuMenu_ctMenu').dialog('open');
}

function carga() {

	$(document).ready(function() {
		carga_ctMenu($('#Form_ctUsuario select#cUsuario').val());
	});

}

function resetDialog(form) {

}

function submit() {
	vcUsuario = $('#cUsuario').val();
	viMenu = $('#iIdMenu').val();

	$.ajax({
		type : "POST",
		url : "sysUsuMenu/add",
		data : {
			cUsuario : vcUsuario,
			iIdMenu : viMenu
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].iIdMenu + '</td>' + '<td>'
								+ data[item].cMenu + '</td>' + '<td>'
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');

			}

		},
		error : function() {
			alert('error');
		}
	});

}

function submit_ctprograma() {
	vcUsuario = $('#Form_sysUsuMenu_ctPrograma input#cUsuario').val();
	viMenu = $('#Form_sysUsuMenu_ctPrograma input#iIdMenu').val();
	viprograma = $('#Form_sysUsuMenu_ctPrograma select#iIdPrograma').val();

	$.ajax({
		type : "POST",
		url : "sysUsuPrograma/add",
		data : {
			cUsuario : vcUsuario,
			iIdMenu : viMenu,
			iIdPrograma : viprograma
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable2 > tbody").empty();
			for ( var item in data) {
				$('#mytable2 > tbody').append(
						'<tr>' + '<td>' + data[item].iIdPrograma + '</td>'
								+ '<td>' + data[item].cNombre + '</td>'
								+ '<td>' + data[item].lActivo + '</td>'
								+ '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el programa selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');
			}

		},
		error : function() {
			alert('error');
		}
	});

}

function add_sysPrograma() {

	// alert ($(".selected td:eq(0)").html());
	// alert ($(".selected td:eq(1)").html());

	// cargar programas del menu

	var value = $(".selected td:first").html();
	if (typeof value === "undefined") {
		alert("seleccione un menu para agregar programas");
	} else {

		vcUsuario = $('#Form_ctUsuario select#cUsuario').val();
		viMenu = $(".selected td:eq(0)").html();		

		$.ajax({
			type : "GET",
			url : "sysUsuPrograma/List_ctProgXctMenu",
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			data : {
				cUsuario : vcUsuario,
				iIdMenu : viMenu
			},
			success : function(data, textStatus, jqXHR) {

				var options = '';

				for ( var item in data) {
					options += '<option value="' + data[item].iIdPrograma
							+ '">' + data[item].cNombre + '</option>';
				}
				$("#Form_sysUsuMenu_ctPrograma select#iIdPrograma").html(
						options);

			},
			error : function() {
				error("al cargar la lista");

			}
		});

		$('#Form_sysUsuMenu_ctPrograma input#cUsuario').val(vcUsuario);
		$('#Form_sysUsuMenu_ctPrograma input#iIdMenu').val(viMenu);
		$('#Form_sysUsuMenu_ctPrograma input#cMenu').val(
				$(".selected td:eq(1)").html());

		$('#AddsysUsuMenu_ctprograma').dialog("option", "title",
				'Agregar Programa');
		$('#AddsysUsuMenu_ctprograma').dialog('open');
	}
}

function remove_sysPrograma(iIdMenu, iIdPrograma) {
	vcUsuario = ('#Form_ctUsuario select#cUsuario').val();

	$.ajax({
		type : "POST",
		url : "sysUsuMenu/remove",
		data : {
			cUsuario : vcUsuario,
			iIdMenu : iIdMenu
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].iIdMenu + '</td>' + '<td>'
								+ data[item].cMenu + '</td>' + '<td>'
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'
								+ '</nobr></td>' + '</tr>');
			}

		},
		error : function() {
			alert('error ');
		}
	});

}

$('#mytable')
		.on(
				'dblclick',
				'tr',
				function() {

					$(this).addClass('selected').siblings().removeClass(
							'selected');
					var value = $(this).find('td:first').html();
					$("#mytable2 > tbody").empty();

					vcUsuario = $('#Form_ctUsuario select#cUsuario').val();
					viMenu = $(".selected td:eq(0)").html();

					$
							.ajax({
								type : "GET",
								url : "sysUsuPrograma/getList",
								dataType : "json",
								contentType : "application/json; charset=utf-8",
								data : {
									cUsuario : vcUsuario,
									iIdMenu : viMenu
								},
								success : function(data, textStatus, jqXHR) {

									$("#mytable2 > tbody").empty();
									for ( var item in data) {
										$('#mytable2 > tbody')
												.append(
														'<tr>'
																+ '<td>'
																+ data[item].iIdPrograma
																+ '</td>'
																+ '<td>'
																+ data[item].cNombre
																+ '</td>'
																+ '<td>'
																+ data[item].lActivo
																+ '</td>'
																+ '<td><nobr>'

																+ '<a class="pure-button pure-button-primary"'
																+ 'onclick="return confirm('
																+ "'¿Desea Eliminar el programa selecionado?'"
																+ ');" '
																+ 'href="javascript:remove_sysMenu('
																+ data[item].iIdMenu
																+ ' )"> <i'
																+ '	class="fa fa-times"></i>Eliminar'
																+ '</a>'

																+ '</nobr></td>'
																+ '</tr>');

									}

								}
							});
				});

$(document).ready(function() {

	$('#AddsysUsuMenu_ctMenu').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				submit();
				$(this).dialog('close');
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {
			resetDialog($('#Form_sysUsuMenu_ctMenu'));
			$(this).dialog('close');
		}

	});

	$('#AddsysUsuMenu_ctprograma').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				submit_ctprograma();
				$(this).dialog('close');
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {
			resetDialog($('#Form_sysUsuMenu_ctPrograma'));
			$(this).dialog('close');
		}

	});

});
