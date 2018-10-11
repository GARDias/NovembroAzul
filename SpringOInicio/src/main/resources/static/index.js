var x = 0;



 $(function() {
	$("#hehe").click(function(){
		x++;
		if (x == 1)
		alert("apertou meu cu ( O )");
		
		if(x == 2)
		alert("apertou meu cu mais (o)");
		if(x == 3)
			alert("AAAAAAAAAAAAAAA (*)");
		if(x >= 4)
			alert("FECHOU!!1!!um!");
	});
	
	$("#inserir").click(function() {
		$("#container").load('Inserirnocu.html');
		alert("Entrou!");
	});
	$("#listar").click(function() {
		$("#container").load('listar.html',function(){
			listarPessoas();
		});
		alert("Entrou!");
	});
	
	$("#container").on('click', '#inserir', function(){
		
		var pessoa = {
				nome : $("#nome").val(),
				cpf : $("#cpf").val(),
				email : $("#email").val(),
				endereco : {
					cep : $("#cep").val(),
					logradouro : $("#logradouro").val(),
					numero : $("#numero").val(),
					complemento : $("#complemento").val(),
					bairro : $("#bairro").val(),
					cidade : $("#cidade").val(),
					uf : $("#uf").val()
				}

			}
		
		 $.ajax({
	            type: "post",
	            url: 'pessoa/inserir',
	            contentType: "application/json",
	            data: JSON.stringify(pessoa),
	            success: function(retorno) {
	                alert(retorno + " inserido com sucesso!");
	                $("#container").load('listar.html');
	                listarPessoas();
	            }});
	            event.preventDefault();
	        
	});
 });
	function listarPessoas() {
	    $.get('pessoa', function (data) {
	        console.log(data);
	        data.forEach(pessoa => {
	            var tdNome = $('<td></td>').html(pessoa.nome);
	            var tdCpf = $('<td></td>').html(pessoa.cpf).addClass('cpfPessoa');
	            var tdEmail = $('<td></td>').html(pessoa.email);
	            var tdCep = $('<td></td>').html(pessoa.enderecodto.cep);
	            var tdLogradouro = $('<td></td>').html(pessoa.enderecodto.logradouro);
	            var tdNumero = $('<td></td>').html(pessoa.enderecodto.numero);
	            var tdComplemento = $('<td></td>').html(pessoa.enderecodto.complemento);
	            var tdBairro = $('<td></td>').html(pessoa.enderecodto.bairro);
	            var tdCidade = $('<td></td>').html(pessoa.enderecodto.cidade);
	            var tdUf = $('<td></td>').html(pessoa.enderecodto.uf);
	            var botaoExcluir = $('<button></button>').html('Excluir').addClass('btn-excluir');
	            var botaoAlterar = $('<button></button>').html('Alterar').addClass('btn-alterar');
	            var tr = $('<tr><form></form></tr>').append(tdNome).append(tdCpf).append(tdEmail).append(tdCep).append(tdLogradouro).append(tdNumero).append(tdComplemento).append(tdBairro).append(tdCidade).
	                append(tdUf).append(botaoAlterar).append(botaoExcluir);
	            $('#corpoTabela').append(tr);
	        });
	    });
	};
