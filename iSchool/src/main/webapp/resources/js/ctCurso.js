function add_ctCurso() {
	
	$('#AddCtPuesto_Dialog').dialog("option", "title", 'Agregar Curso');
	$('#AddCtPuesto_Dialog').dialog('open');


}

function edit_ctCurso(id) {
	
	$.get("get/" + id, function(result) {
		$("#AddCtPuesto_Dialog").html(result);
		$("#AddCtPuesto_Dialog").dialog("option", "title", 'Editar Curso');
		$("#AddCtPuesto_Dialog").dialog('open');

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

	$('#AddCtPuesto_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctCurso').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctCurso'));

			$(this).dialog('close');
		}
	});

	
	initializeDatePicker();
});
