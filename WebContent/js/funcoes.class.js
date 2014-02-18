// Classe para chamar o Json.
function json(){
	var qtd;
	var retorno;

	// Resgatar valores.
	

		// Estrutura de resultado.
		$.getJSON('js/arquivo.json', function(data){
			this.qtd = data.usuarios.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'ID: ' + data.usuarios[i].id + '<br />';
				this.retorno += 'Nome: ' + data.usuarios[i].nome + ' - ';
				this.retorno += 'Cidade: ' + data.usuarios[i].cidade + '<br /><br />';
			}
			$('#resultado').html(this.retorno);
		});

	

}

// Objeto.
var obj = new json();
obj.resgatarValores();
