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
				<label for="inputNomeCliente" class="col-sm-2 control-label">Servidor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputNomeRca"
						placeholder="ftp.lojakelma.com.br" name="nomeRca" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">Usuário</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputUsuario"
						placeholder="site1368285974" name="usuario" required></input>
				</div>
			</div>
			<div class="form-group">
				<label for="inputCpf" class="col-sm-2 control-label">Senha</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="inputSenha"
						placeholder="************" name="dirSenha" required></input>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<button type="reset" class="btn btn-primary">Limpar</button>
					<button type="submit" class="btn btn-primary">Alterar</button>
				</div>
			</div>
		
	</div>

</body>
</html>