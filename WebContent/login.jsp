<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bem vindo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Login</h2>
  
  <form action="AcessoController" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Entre com o seu e-mail" name="email">
    </div>
    
    <div class="form-group">
      <label for="pwd">Senha:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Entre com a sua senha" name="senha">
    </div>
    
    <div class="form-group">
    	<label for="cadastroSelecionado">Cadastro: </label>
    	<select id="cadastroSelecionado" name="cadastroSelecionado">
    		<option value="BeneficiarioDetalhe.jsp">Beneficiário</option>
    		<option value="BrinquedoDetalhe.jsp">Brinquedo</option>
    		<option value="RoupaDetalhe.jsp">Roupa</option>
    		<option value="DescartavelDetalhe.jsp">Descartável</option>
    		<option value="DoacaoDetalhe.jsp">Doação</option>
    	</select>
    </div>

    <button type="submit" class="btn btn-default">Acessar</button>
  </form>
</div>

</body>
</html>