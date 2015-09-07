function addGrupo() {
	$('#AddCtGrupo_Dialog').dialog("option", "title", 'Agregar Grupo');
	$('#AddCtGrupo_Dialog').dialog('open');

}

function editGrupo(id) {

	$.get("ctGrupo/get/" + id, function(result) {
		$("#AddCtGrupo_Dialog").html(result);
		$("#AddCtGrupo_Dialog").dialog("option", "title", 'Editar Grupo');
		$("#AddCtGrupo_Dialog").dialog('open');

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

	$('#AddCtGrupo_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctGrupo').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctGrupo'));

			$(this).dialog('close');
		}
	});

	/*$('#UpdateCtGrupo_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctGrupo').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctGrupo'));

			$(this).dialog('close');
		}
	});*/

	initializeDatePicker();
});
