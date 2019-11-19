<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brinquedo Detalhe</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form action="BrinquedoController" method="post" style="width: 100%;">
		  <div class="form-group">
		    <label for="tipo">Tipo:</label>
		    <input type="text" class="form-control" id="tipo" name="tipo">
		  </div>
		  <div class="form-group">
		    <label for="faixaEtaria">Faixa Etária:</label>
		    <input type="text" class="form-control" id="faixaEtaria" name="faixaEtaria">
		  </div>
		  <div class="form-group">
		    <label for="genero">Gênero: </label>
	    	<select id="tipo" name="genero" class="form-control">
	    		<option value="M">Masculino</option>
	    		<option value="F">Feminino</option>
	    		<option value="U">Unissex</option>
	    	</select>
		  </div>
		  <button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</body>
</html>