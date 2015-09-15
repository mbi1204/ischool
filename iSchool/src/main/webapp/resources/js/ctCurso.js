function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
    }

function add_ctCurso() {
	$('#AddCtCurso_Dialog').dialog("option", "title", 'Agregar Curso');
	$('#AddCtCurso_Dialog').dialog('open');
	
}

function edit_ctCurso(id) {

	$.get("ctCurso/get/" + id, function(result) {
		$("#AddCtCurso_Dialog").html(result);
		$("#AddCtCurso_Dialog").dialog("option", "title", 'Editar Curso');
		$("#AddCtCurso_Dialog").dialog('open');

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
	form.find("#iIdCurso").val("0");
	
}

$(document).ready(function() {

	$('#AddCtCurso_Dialog').dialog({

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