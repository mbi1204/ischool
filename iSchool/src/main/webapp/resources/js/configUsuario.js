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
				$('#mytable > tbody')
				.append(
						'<tr>'
						+ '<td>'
						+ data[item].iIdMenu
						+ '</td>'
						+ '<td>'
						+ data[item].cMenu
						+ '</td>'
						+ '<td>'
						+ data[item].lActivo
						+ '</td>'
						+ '<td><nobr>'
						
						+ '<a class="pure-button pure-button-primary"'
						+ 'onclick="return confirm(' + "'¿Desea Eliminar el usuario selecionado?'" + ');" '
						+  'href="javascript:remove_sysMenu(' + data[item].iIdMenu + ' )"> <i'
						+ '	class="fa fa-times"></i>Eliminar'
						+ '</a>'
						
						+ '</nobr></td>'
						+ '</tr>');				
				
				}					
			},
			error : function() {
				alert('error');
			}
			
	});
	
}


function remove_sysMenu(iIdMenu){
	 vcUsuario = $('#cUsuario').val();
	 
	 
		$.ajax({
			type : "POST",
			url : "sysUsuMenu/remove",
			data :  {cUsuario : vcUsuario , iIdMenu:iIdMenu},
			
			success : function(data, textStatus, jqXHR) {
				$("#mytable > tbody").empty();			
				for ( var item in data) {
					$('#mytable > tbody')
					.append(
							'<tr>'
							+ '<td>'
							+ data[item].iIdMenu
							+ '</td>'
							+ '<td>'
							+ data[item].cMenu
							+ '</td>'
							+ '<td>'
							+ data[item].lActivo
							+ '</td>'
							+ '<td><nobr>'
							
							+ '<a class="pure-button pure-button-primary"'
							+ 'onclick="return confirm(' + "'¿Desea Eliminar el usuario selecionado?'" + ');" '
							+  'href="javascript:remove_sysMenu(' + data[item].iIdMenu + ' )"> <i'
							+ '	class="fa fa-times"></i>Eliminar'
							+ '</a>'
							
							+ '</nobr></td>'
							+ '</tr>');				
					}
				
			},
			error : function() {
				alert('error');
			}
		});
	 
	
}

function add_sysUsuMenu() {
	

	$('#Form_sysUsuMenu input#cUsuario').val($('#cUsuario').val());	
	$('#AddsysUsuMenu_Dialog').dialog("option", "title", 'Agregar Menu');
	$('#AddsysUsuMenu_Dialog').dialog('open');
}

function carga() {
	window.onload = carga_ctMenu($('#cUsuario').val());
	
	
}


function resetDialog(form) {

}

function submit(){
	 vcUsuario = $('#cUsuario').val();
	 viMenu = $('#iIdMenu').val();
	 
	$.ajax({
		type : "POST",
		url : "sysUsuMenu/add",
		data :  {cUsuario : vcUsuario , iIdMenu:viMenu},
		
		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();			
			for ( var item in data) {
				$('#mytable > tbody')
				.append(
						'<tr>'
						+ '<td>'
						+ data[item].iIdMenu
						+ '</td>'
						+ '<td>'
						+ data[item].cMenu
						+ '</td>'
						+ '<td>'
						+ data[item].lActivo
						+ '</td>'
						+ '<td><nobr>'
						
						+ '<a class="pure-button pure-button-primary"'
						+ 'onclick="return confirm(' + "'¿Desea Eliminar el usuario selecionado?'" + ');" '
						+  'href="javascript:remove_sysMenu(' + data[item].iIdMenu + ' )"> <i'
						+ '	class="fa fa-times"></i>Eliminar'
						+ '</a>'
						
						+ '</nobr></td>'
						+ '</tr>');				
				
				}
			
		},
		error : function() {
			alert('error');
		}
	});

	
}

$('#mytable').on('dblclick', 'tr', function() {
	/*alert($(this).find('td:eq(0)').text());
	alert($(this).find('td:eq(1)').text());
	*/
	
	
	$(this).addClass('selected').siblings().removeClass('selected');    
	  var value=$(this).find('td:first').html();
	  alert(value);
	
	
	$("#mytable2 > tbody").empty();	
	
	
	$.ajax({
		type : "GET",
		url : "prueba",		
		dataType : "json",
		contentType : "application/json; charset=utf-8",					
		success : function(data, textStatus, jqXHR) {			
		
			
			for ( var item in data) {
				
				$('#mytable2 > tbody')
				.append(
						'<tr>'
						+ '<td>'
						+ data[item].cPrograma
						+ '</td>'
						+ '<td>'
						+ data[item].cNombre
						+ '</td>'
						+ '<td>'
						+ data[item].lActivo
						+ '</td>'
						
						+ '</tr>');
				}
			}
	});
	
});








$(document).ready(function() {

	$('#AddsysUsuMenu_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				//$('#Form_sysUsuMenu').submit();
				 submit();
				$(this).dialog('close');
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		
		close : function() {

			resetDialog($('#Form_sysUsuMenu'));

			$(this).dialog('close');
		},		
		aceptar : function(){
			alert ("hola entro aceptar");			
		}	
		
	});	

		  
});








