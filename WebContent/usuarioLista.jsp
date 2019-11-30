<%@page import="negocio.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	List<Usuario> lista = (List<Usuario>)request.getAttribute("usuarios");
	%>
	
<div class="container">
  <h2>Cadastro de Usuários</h2>
  
  <form action="usuarioCadastro.jsp">  
	<button type="submit" class="btn btn-default">Novo</button>
  </form>
              
  <p>Usuários:</p>
  <%if(lista != null){%>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Nome</th>
	        <th>Email</th>
	        <th>Senha</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<%for(Usuario item : lista){%>
	      <tr>
	        <td><%=item.getNome()%></td>
	        <td><%=item.getEmail()%></td>
	        <td><%=item.getSenha()%></td>
	      </tr>
	      	<%}%>
	    </tbody>
	  </table>
  <%}else{%>
  	<p>Nenhum usuário cadastrado!!!</p>	
  <%}%>
</div>
</body>
</html>