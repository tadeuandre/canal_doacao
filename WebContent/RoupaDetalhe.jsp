<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>AppCanalDoacao</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Roupa</h2>
  <form action="RoupaController" method="post">
  
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
</div></body>
</html>