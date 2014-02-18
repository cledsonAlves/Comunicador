<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="br.comunicador.baseDados.Banco"%>
<%@ page import="br.comunicador.baseDados.ManipulaBanco"%>

<title>Intranet Pedidos</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
    <script>  
  
function myIP() {  
    if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest();  
    else xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");  
  
    xmlhttp.open("GET","http://api.hostip.info/get_html.php",false);  
    xmlhttp.send();  
  
    hostipInfo = xmlhttp.responseText.split("\n");  
  
    for (i=0; hostipInfo.length >= i; i++) {  
        ipAddress = hostipInfo[i].split(":");  
        if ( ipAddress[0] == "IP" ) return ipAddress[1];  
    }  
  
    return false;  
}  
</script>  
    
</head>

<body>

<%
%>
	<div class="container">
		<form class="form-signin" action="./pedidos.xhtml">
			<h2 class="form-signin-heading">Intranet Pedidos</h2>
			<input type="text" class="form-control" placeholder="Usuario"
				autofocus> <input type="password" class="form-control"
				placeholder="Senha"> <label class="checkbox"> <input
				type="checkbox" value="remember-me"> Continuar conectado
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>

