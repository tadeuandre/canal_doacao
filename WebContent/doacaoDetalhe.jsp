<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
  <title>AppCanalDoacao</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
		    <form action="DoacaoController" method="get">
			    <button type="submit" class="btn btn-default">Voltar</button>
			</form>
	    </div>
	    <div class="btn-group">
			<c:import url="sair.jsp"/>
	    </div>
    </div>   
	<form action="DoacaoController" method="post">

		<div class="form-group">
		  <label for="dia">Beneficiário:</label>
		  <input type="text" class="form-control" id="idBeneficiario" placeholder="Entre com a data" name="idBeneficiario" readonly="readonly">
		</div>

		<div class="form-group">
		  <label for="dia">Data da Divulgação:</label>
		  <input type="text" class="form-control" id="dia" placeholder="Entre com a data" name="dia" readonly="readonly">
		</div>

    	<button type="submit" class="btn btn-default">Cadastrar</button>
	</form>
</div>
</div>
</div>
</div>
</body>
</html>