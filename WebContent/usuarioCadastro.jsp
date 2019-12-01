<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="negocio.Usuario"%>
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
	String mensagem = (String) request.getAttribute("msg");
	Usuario usuario = (Usuario) request.getAttribute("usuarioSelecionado");
	%>
	
<div class="container">
  <h2>Cadastro de Usuários</h2>
  
  <h3><%=mensagem != null ? mensagem : ""%></h3>
  
  <form action="UsuarioController" method="POST">
  	<input type="hidden" name="id" value="<%=usuario != null ? usuario.getId() : "" %>">
    <div class="form-group">
      <label for="nome">Nome:</label>
      <input type="text" class="form-control" id="nome" placeholder="Entre com o seu nome" name="nome" value="<%=usuario != null ? usuario.getNome() : ""%>">
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Entre com o seu e-mail" name="email" value="<%=usuario != null ? usuario.getEmail() : ""%>">
    </div>
    
    <div class="form-group">
      <label for="pwd">Senha:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Entre com a sua senha" name="senha" value="<%=usuario != null ? usuario.getSenha() : ""%>">
    </div>
    
    <button type="submit" name="operacao" value="<%=usuario != null ? "alterar" : "incluir" %>" class="btn btn-default">Salvar</button>
  </form>
</div>

</body>
</html>
