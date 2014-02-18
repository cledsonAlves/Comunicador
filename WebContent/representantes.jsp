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

<title>Representantes</title>
</head>
<body>
	<div class="navbar-form navbar-right">
		<a href="login.html" class="btn btn-primary">Sair</a>
	</div>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand">Intranet Pedidos</a>
				<ul class="nav navbar-nav">
		
				</ul>
			</div>
			<div class="navbar-form navbar-right">
				<a href="./pedidos.xhtml" class="btn btn-primary">Voltar</a>
			</div>
		</div>
	</div>
	<div class="container">
		<form class="form-horizontal" method="post" action="cadastro-cliente">
			<h3 class="form-cadastro-head">Informações</h3>
			<div class="form-group">
				<label for="inputNomeCliente" class="col-sm-2 control-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputNomeRca"
						placeholder="Nome do RCA" name="nomeRca" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputEmail"
						placeholder="E-mail do RCA" name="emailRca" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">Diretório</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputDir"
						placeholder="Diretório de recebimento" name="dirRca" required></input>
				</div>
			</div>
			
				<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">Telefone</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputTelefone"
						placeholder="(DDD)X.XXXX-XXXX" name="telefone" required></input>
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
						<th>E-MAIL DE ENVIO DO ESPELHO</th>
						<th>DIRETORIO DE RECEBIMENTO</th>
						<th>TELEFONE</th>
					</tr>
				</thead>
				<tbody>
				<%
					//Busca todos os funcionários do banco ...
					ManipulaBanco mb = new ManipulaBanco();
					mb.getRca();

					ArrayList<Rca> lista =	mb.getRca();

					for (int i = 0; i < lista.size(); i++) {
						out.println("<tr><td>"+lista.get(i).getCodigo()+"</td>	<td>"+lista.get(i).getNome()+"</td>	<td>"+lista.get(i).getEmail()+"</td>	<td>"+lista.get(i).getDiretorio()+"</td><td>"+lista.get(i).getTelefone()+"</td></tr>");
					}
				%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>