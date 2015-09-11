function add_ctUsuario() {
	$('#AddCtUsuario_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#AddCtUsuario_Dialog').dialog('open');

}

function edit_ctUsuario(cUsuario) {
	
	$.get("get_ctUsuario/" + cUsuario, function(result) {
		$("#UpdateCtUsuario_Dialog").html(result);
		$("#UpdateCtUsuario_Dialog").dialog("option", "title", 'Editar Usuario');
		$("#UpdateCtUsuario_Dialog").dialog('open');

		// initializeDatePicker();
	});
	
	


}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#AddCtUsuario_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctUsuario_Add').submit();
				
				
				
				
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctUsuario_Add'));

			$(this).dialog('close');
		}
	});

	
	$('#UpdateCtUsuario_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctUsuario_Update').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctUsuario_Update'));

			$(this).dialog('close');
		}
	});
	
});


