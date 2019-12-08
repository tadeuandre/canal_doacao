<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
	<meta charset="ISO-8859-1">
	<title>AppCanalDoacao</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
		    <form action="GameController" method="get">
			    <button type="submit" class="btn btn-default">Voltar</button>
			</form>
	    </div>
	    <div class="btn-group">
			<c:import url="sair.jsp"/>
	    </div>
    </div>
	<form action="RoupaController" method="post">
	
	  <div class="form-group">
	    <label for="nome">Nome:</label>
	    <input type="text" class="form-control" id="nome" placeholder="Entre com o nome" name="nome">
	  </div>
	
	  <div class="form-group">
	    <label for="quantidade">Quantidade:</label>
	    <input type="text" class="form-control" id="quantidade" placeholder="Entre com a quantidade" name="quantidade">
	  </div>
	
	  <div class="form-group">
	    <label for="tamanho">Tamanho:</label>
	    <input type="text" class="form-control" id="tamanho" placeholder="Entre com o tamanho da roupa" name="tamanho">
	  </div>
	  
	  <div class="form-group">
	    <label for="marca">Marca:</label>
	    <input type="text" class="form-control" id="marca" placeholder="Entre com a marca da roupa" name="marca">
	  </div>
	  
	  <div class="form-group">
	    <label for="tipo">Tipo:</label>
	    <input type="text" class="form-control" id="tipo" placeholder="Entre com o tipo de roupa" name="tipo">
	  </div>
	  
	  <div class="form-group">
	    <label for="faixaEtaria">Faixa Etária:</label>
	    <input type="text" class="form-control" id="faixaEtaria" placeholder="Entre com a faixa etária da roupa" name="faixaEtaria">
	  </div>
	
	  <button type="submit" class="btn btn-default">Salvar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>