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

	$('#Form_sysUsuMenu_ctMenu input#cUsuario').val($('#Form_ctUsuario select#cUsuario').val());
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

function add_sysPrograma() {
/*	var value = $(".selected td:first").html();
	if (typeof value === "undefined") {
		alert("seleccione un menu para agregar programas");
	} else {
		$('#Form_sysUsuMenu_ctPrograma input#cUsuario').val($('#Form_ctUsuario select#cUsuario').val());
		$('#AddsysUsuMenu_ctprograma').dialog("option", "title",'Agregar Programa');
		$('#AddsysUsuMenu_ctPrograma').dialog('open');
	}
*/
	
alert("entro");	
	
	$('#Form_sysUsuMenu_ctPrograma input#cUsuario').val($('#Form_ctUsuario select#cUsuario').val());
	$('#AddsysUsuMenu_ctprograma').dialog("option", "title",'Agregar Programa');
	$('#AddsysUsuMenu_ctPrograma').dialog('open');

}

$('#mytable').on('dblclick','tr',function() {
	$(this).addClass('selected').siblings().removeClass('selected');
	var value = $(this).find('td:first').html();
	$("#mytable2 > tbody").empty();
	
	$.ajax({
		type : "GET",
		url : "prueba",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		success : function(data, textStatus, jqXHR) {
		
			for ( var item in data) {
				$('#mytable2 > tbody').append(
						'<tr>' + '<td>' + data[item].cPrograma
						+ '</td>' + '<td>' + data[item].cNombre
						+ '</td>' + '<td>' + data[item].lActivo
						+ '</td>'
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
