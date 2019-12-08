<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AppCanalDoacao</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="cabecalho.jsp"/>
   <div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
	    </div>
	    
	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
		    <form action="SolicitanteController" method="get">
			    <button type="submit" class="btn btn-default">Voltar</button>
			</form>
	    </div>
	    <div class="btn-group">
			<c:import url="sair.jsp"/>
	    </div>
    </div>   
		<form action="BeneficiarioController" method="post">
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" class="form-control" id="nome" name="nome">
		  </div>
		  <div class="form-group">
		    <label for="endereco">Endereço:</label>
		    <input type="text" class="form-control" id="endereco" name="endereco">
		  </div>
		  <div class="form-group">
		    <label for="tipo">Tipo: </label>
	    	<select id="tipo" name="tipo" class="form-control">
	    		<option value="PF">Pessoa Física</option>
	    		<option value="PJ">Pessoa Jurídica</option>
	    	</select>
		  </div>
		  <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
</div>
</div>
</div>
</div>
</body>
</html>