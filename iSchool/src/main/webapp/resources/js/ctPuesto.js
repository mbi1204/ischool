function add_ctPuesto() {
	
	$('#AddCtPuesto_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#AddCtPuesto_Dialog').dialog('open');


}

function edit_ctPuesto(id) {
	
	$.get("get_ctPuesto/" + id, function(result) {
		$("#AddCtPuesto_Dialog").html(result);
		$("#AddCtPuesto_Dialog").dialog("option", "title", 'Editar Usuario');
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
				$('#Form_ctPuesto').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctPuesto'));

			$(this).dialog('close');
		}
	});

	
	initializeDatePicker();
});
