/**
 * 
 */

function Add_curso() {

	
		
	vid = $('select#idGrupo option:selected').val();
	
	vlExiste  = false;
	vdetotal  = 0;
	alert("a");
	var table = document.getElementById("mytable");
    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    alert("b");
	
	
	
	
	 $.each($("#mytable tbody").find("tr"), function () {		 
		if( $(this).closest("tr").find(".grupoid").text() == vid ){
			vlExiste = true;			
			alert ("el curso ya fue registrado");
		}  
	 });
	 
	 if (vlExiste)  return;
	 

	

	$.ajax({
		type : "GET",
		url : "ctAlumno/getGrupo",
		data : {
			id : vid
		},
		success : function(data, textStatus, jqXHR) {
			
			/*cell1.innerHTML = data.iTdGrupo;
			cell2.innerHTML = data.cNombre;
			cell3.innerHTML = data.curso.cNombre;
			cell4.innerHTML = data.cHorario;
			cell5.innerHTML = data.curso.dePrecio;*/
			
			$('#mytable > tbody')
			.append(
					'<tr>'
					+ '<td  class="grupoid" >' 
					+ data.iIdGrupo
					+ '</td>'
					+ '<td>'
					+ data.cNombre
					+ '</td>'
					+ '<td>'
					+ data.curso.cNombre
					+ '</td>'
					+ '<td>'
					+ data.cHorario
					+ '</td>'
					+ '<td class="precio">'
					+ data.curso.dePrecio
					+ '</td>'
					+ '<td>'
					+ '<button class="btnDelete" onclick="Borrar();">Quitar</button>'
					+ '</td> </tr>');
			
			
			
		
			 vdetotal = 0 ;
			 $.each($("#mytable tbody").find("tr"), function () {
				 vdetotal = vdetotal  + parseInt($(this).closest("tr").find(".precio").text());				 
				 alert("add " + parseInt($(this).closest("tr").find(".precio").text()));
			 });
			 
			 $("#mytable > tfoot").empty();		
			 $('#mytable > tfoot').append('<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>' + vdetotal +'</TH> </TR>');
			 
		
			 
		},
		error : function() {
			alert('error ');
		}
		
	});


}

function BorraRow(){
	alert(1);
	  $("#mytable").on('click','.btnDelete',function(){
			 alert(3);		 
			 $(this).closest('tr').remove();
			 	// $(this).parent("tr").remove();			
	  });	
	
}




function Borrar(){	
	alert(2)
	BorraRow();	
	 
	 
	 vdetotal = 0 ;
	 $("#mytable > tfoot").empty();
	 
	 $.each($("#mytable tbody").find("tr"), function() {	 
		 
		 alert ("del " + parseInt($(this).closest("tr").find(".precio").text()));
		 
		 vdetotal = vdetotal  + parseInt($(this).closest("tr").find(".precio").text());		 
	 });
	 
	 
	 
	 vdetotal = vdetotal - vdeResto;
	 
	 alert("total: " + vdetotal);
 		
	 $('#mytable > tfoot').append('<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>' + vdetotal +'</TH> </TR>');	 
	 
	 
}
