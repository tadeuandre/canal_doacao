<%@page import="java.util.List"%>
<%@page import="negocio.Beneficiario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>AppCanalDoacao</title>
	<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Beneficiario> lista = (List<Beneficiario>)request.getAttribute("lista");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
   
   <div class="panel-body">
	<form action="BeneficiarioDetalhe.jsp">
		<button type="submit" class="btn btn-default">Novo Beneficiário</button>
		<hr>
	</form>
		<%if(lista != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Beneficiários</th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Beneficiario item : lista){%>
	    	<form action="BeneficiarioController" method="post">
		      	<tr>
		        	<td><%=item%></td>
		      	</tr>
	      	</form>
	      	<%}%>
	    	</tbody>
		</table>
		<%}%>
</div>
</div>
</div>
</div>
</html>