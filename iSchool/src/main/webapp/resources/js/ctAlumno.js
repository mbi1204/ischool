/**
 * 
 */

function Add_curso() {

	vid = $('select#idGrupo option:selected').val();

	vlExiste = false;
	vdetotal = 0;

	$.each($("#mytable tbody").find("tr"), function() {
		if ($(this).closest("tr").find(".id_Grupo").text() == vid) {
			vlExiste = true;
			alert("el curso ya fue registrado");
		}
	});

	if (vlExiste)
		return;

	$
			.ajax({
				type : "GET",
				url : "ctAlumno/getGrupo",
				data : {
					id : vid
				},
				success : function(data, textStatus, jqXHR) {

					$('#mytable > tbody')
							.append(
									'<tr>'
											+ '<td class="id_Grupo">'
											+ data.iIdGrupo
											+ '</td>'
											+ '<td class="cNombre_Grupo">'
											+ data.cNombre
											+ '</td>'
											+ '<td class="id_Curso">'
											+ data.curso.iIdCurso
											+ '</td>'
											+ '<td class="cNombre_Curso">'
											+ data.curso.cNombre
											+ '</td>'
											+ '<td class="cHorario">'
											+ data.cHorario
											+ '</td>'
											+ '<td class="dePrecio">'
											+ data.curso.dePrecio
											+ '</td>'
											+ '<td>'
											+ '<button class="btnDelete" onclick="Borrar();" style="background-color:#FF4000; color:black;">Quitar</button>'
											+ '</td> </tr>');

					calculaTotal();

					$("#mytable > tfoot").empty();
					$('#mytable > tfoot').append(
							'<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>'
									+ vdetotal + '</TH> </TR>');
					alert("por aqui paso el caballo");

					/* agregar json curso */
					generaJson();

				},
				error : function() {
					alert('error ');
				}

			});

}

function Borrar() {

	$("#mytable").on(
			'click',
			'.btnDelete',
			function() {
				$(this).closest('tr').remove();

				$("#mytable > tfoot").empty();

				calculaTotal();

				if (vdetotal > 0) {
					$('#mytable > tfoot').append(
							'<TR> <TH ALIGN=LEFT COLSPAN=4>Total a Pagar</TH> <TH>'
									+ vdetotal + '</TH> </TR>');
				}

				/* agregar json curso */
				generaJson();

			});
}

var generaJson = function() {

	var dataArray = new Array();

	function dataRow(id_Grupo, cNombre_Grupo, id_Curso, cNombre_Curso,
			cHorario, dePrecio) {
		this.id_Grupo = id_Grupo;
		this.cNombre_Grupo = cNombre_Grupo;
		this.cNombre_Curso = cNombre_Curso;
		this.cHorario = cHorario;
		this.dePrecio = dePrecio;
		this.id_Curso = id_Curso;
	}

	$.each($("#mytable tbody").find("tr"), function() {
		dataArray.push(new dataRow(
				$(this).closest("tr").find(".id_Grupo").text(), 
				$(this).closest("tr").find(".cNombre_Grupo").text(),
				$(this).closest("tr").find(".id_Curso").text(), 
				$(this).closest("tr").find(".cNombre_Curso").text(), 
				$(this).closest("tr").find(".cHorario").text(), 
				$(this).closest("tr").find(".dePrecio").text()));

	});
	var sJson = JSON.stringify(dataArray);
	$("#cGrupo").val(sJson);
};

var calculaTotal = function() {

	vdetotal = 0;
	$.each($("#mytable tbody").find("tr"), function() {
		vdetotal = vdetotal
				+ parseInt($(this).closest("tr").find(".dePrecio").text());

	});
};
