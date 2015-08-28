function add_ctPrograma() {

	$('#AddCtPrograma_Dialog').dialog("option", "title", 'Agregar Programa');
	$('#AddCtPrograma_Dialog').dialog('open');

	$.get("open_ctPrograma/",
			function(result) {

				$("#AddCtPrograma_Dialog").html(result);
				$("#AddCtPrograma_Dialog").dialog("option", "title",'Agregar programa');
				$("#AddCtPrograma_Dialog").dialog('open');

				// initializeDatePicker();
			});

}

function edit_ctPrograma(iMenu, iPrograma) {

	$.get("get_ctPrograma/" + iMenu + "&" + iPrograma,
			function(result) {

				$("#AddCtPrograma_Dialog").html(result);
				$("#AddCtPrograma_Dialog").dialog("option", "title",
						'Editar programa');
				$("#AddCtPrograma_Dialog").dialog('open');

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
	/*form.find("#iIdPrograma").val("0");*/

}

$(document).ready(function() {

	$('#AddCtPrograma_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#Form_ctPrograma').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#Form_ctPrograma'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
