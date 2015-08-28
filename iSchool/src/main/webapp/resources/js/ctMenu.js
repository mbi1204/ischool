function add_ctMenu() {
	
	$('#AddctMenu_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#AddctMenu_Dialog').dialog('open');


}

function edit_ctMenu(id) {
	
	$.get("get_ctMenu/" + id, function(result) {
		$("#AddctMenu_Dialog").html(result);
		$("#AddctMenu_Dialog").dialog("option", "title", 'Editar Usuario');
		$("#AddctMenu_Dialog").dialog('open');

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

	$('#AddctMenu_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctMenu').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctMenu'));

			$(this).dialog('close');
		}
	});

	
	initializeDatePicker();
});
