<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Beneficiário Detalhe</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form action="BeneficiarioController" method="post" style="width: 100%;">
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
</body>
</html>