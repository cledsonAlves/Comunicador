


$(function() {
	$("a#Alan").click(function() {
		alert("ok");
		buscaPedidos();
		montaDir();
	});

	// função monta diretorios ..
	function montaDir() {
		var lista = $("#patch");
	
			$.getJSON("./resource/diretorio", function(data) {
				$.each(data, function(i, aluno) {
					lista.append('<li  class="active"><a href="#"> <span id="numero" class="badge pull-right">42</span> Pedidos </a></li>');
					
				});
			});
	}

	// Função busca pedidos
	function buscaPedidos() {
		$.get("./resource/aluno", function(data) {
			$("#numero").text(data);
		});

	}

});
