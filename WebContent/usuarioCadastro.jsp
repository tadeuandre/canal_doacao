<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppUsuario</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String mensagem = (String)request.getAttribute("msg");
	%>
	
<div class="container">
  <h2>Cadastro de Usuários</h2>
  
  <h3><%=mensagem != null ? mensagem : ""%></h3>
  
  <form action="UsuarioController" method="post">
    <div class="form-group">
      <label for="nome">Nome:</label>
      <input type="text" class="form-control" id="nome" placeholder="Entre com o seu nome" name="nome">
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Entre com o seu e-mail" name="email">
    </div>
    
    <div class="form-group">
      <label for="pwd">Senha:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Entre com a sua senha" name="senha">
    </div>
    
    <button type="submit" class="btn btn-default">Salvar</button>
  </form>
</div>

</body>
</html>
