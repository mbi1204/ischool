function add_ctProfesor() {
	
	
	
	$('#AddctProfesor_Dialog').dialog("option", "title", 'Agregar Profesor');
	$('#AddctProfesor_Dialog').dialog('open');

}

function edit_ctProfesor(id) {
	
	$.get("get_ctProfesor/" + id, function(result) {
		$("#AddctProfesor_Dialog").html(result);
		$("#AddctProfesor_Dialog").dialog("option", "title", 'Editar Usuario');
		$("#AddctProfesor_Dialog").dialog('open');

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

	$('#AddctProfesor_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctProfesor_Add').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctProfesor_Add'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
	
});
