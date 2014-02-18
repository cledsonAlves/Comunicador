<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.comunicador.baseDados.ManipulaBanco"%>
<%@ page import="br.comunicador.objetos.Rca"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet" />
<link type="text/css" href="css/cadastros.css" rel="stylesheet" />
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/bootstrap.js"></script>

<title>FACCAMP - Sistema de Farmácia - Clientes</title>
</head>
<body>
	<div class="navbar-form navbar-right">
		<a href="login.html" class="btn btn-primary">Sair</a>
	</div>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand">FACCAMP - Sistema de Farmácia</a>
				<ul class="nav navbar-nav">
					<li><a href="sistema.jsp">Home</a></li>
					<li class="active"><a href="clientes.jsp">Clientes</a></li>
					<li><a href="produtos.jsp">Produtos</a></li>
					<li><a href="fornecedores.jsp">Forncedores</a></li>
				</ul>
			</div>
			<div class="navbar-form navbar-right">
				<a href="index.jsp" class="btn btn-primary">Sair</a>
			</div>
		</div>
	</div>
	<div class="container">
		<form class="form-horizontal" method="post" action="cadastro-cliente">
			<h3 class="form-cadastro-head">Informações</h3>
			<div class="form-group">
				<label for="inputNomeCliente" class="col-sm-2 control-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputNomeCliente"
						placeholder="Nome do Cliente" name="nomeCliente" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">CPF</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputCpf"
						placeholder="CPF do Cliente" name="cpfCliente" required></input>
				</div>
			</div>
			<h3 class="form-cadastro-head">Endereço</h3>
			<div class="form-group">
				<label for="inputRua" class="col-sm-2 control-label">Rua</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputRua"
						placeholder="Rua" name="enderecoRua" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputNumero" class="col-sm-2 control-label">Número</label>
				<div class="col-sm-2">
					<input type="number" class="form-control" id="inputNumero"
						placeholder="Nº" name="enderecoNumero" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputBairro" class="col-sm-2 control-label">Bairro</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputBairro"
						placeholder="Bairro" name="enderecoBairro" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCidade" class="col-sm-2 control-label">Cidade</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputCidade"
						placeholder="Cidade" name="enderecoCidade" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEstado" class="col-sm-2 control-label">Estado</label>
				<div class="col-sm-4">
					<select class="form-control" id="inputEstado" name="enderecoEstado">
						<option value="AC">AC - Acre</option>
						<option value="AL">AL - Alagoas</option>
						<option value="AP">AP - Amapá</option>
						<option value="AM">AM - Amazonas</option>
						<option value="BA">BA - Bahia</option>
						<option value="CE">CE - Ceará</option>
						<option value="DF">DF - Distrito Federal</option>
						<option value="ES">ES - Espírito Santo</option>
						<option value="GO">GO - Goiás</option>
						<option value="MA">MA - Maranhão</option>
						<option value="MT">MT - Mato Grosso</option>
						<option value="MS">MS - Mato Grosso do Sul</option>
						<option value="MG">MG - Minas Gerais</option>
						<option value="PA">PA - Pará</option>
						<option value="PB">PB - Paraíba</option>
						<option value="PR">PR - Paraná</option>
						<option value="PE">PE - Pernambuco</option>
						<option value="PI">PI - Piauí</option>
						<option value="RJ">RJ - Rio de Janeiro</option>
						<option value="RN">RN - Rio Grande do Norte</option>
						<option value="RS">RS - Rio Grande do Sul</option>
						<option value="RO">RO - Rondônia</option>
						<option value="RR">RR - Roraíma</option>
						<option value="SC">SC - Santa Catarina</option>
						<option selected="selected" value="SP">SP - São Paulo</option>
						<option value="SE">SE - sergipe</option>
						<option value="TO">TO - Tocantins</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCep" class="col-sm-2 control-label">CEP</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="inputCep"
						placeholder="CEP" name="enderecoCep" required></input>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<button type="reset" class="btn btn-primary">Limpar</button>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Representantes</div>
			<jsp:useBean id="Livro"
				class="br.comunicador.baseDados.ManipulaBanco" />
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>CEP</th>
					</tr>
				</thead>
				<tbody>
				<%
					//Busca todos os funcionários do banco ...
					ManipulaBanco mb = new ManipulaBanco();
					mb.getRca();

					ArrayList<Rca> lista =	mb.getRca();

					for (int i = 0; i < lista.size(); i++) {
						out.println("<br><tr><td>"+lista.get(i).getCodigo()+"</td>	<td>"+lista.get(i).getNome()+"</td>	<td>"+lista.get(i).getEmail()+"</td>	<td>"+lista.get(i).getDiretorio()+"</td></tr></br>");
					}
				%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>