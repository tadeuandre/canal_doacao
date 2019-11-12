<%@page import="java.util.List"%>
<%@page import="negocio.Descartavel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>AppCanalDoacao</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Descartavel> lista = (List<Descartavel>)request.getAttribute("lista");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
   
   <div class="panel-body">
	<form action="DescartavelDetalhe.jsp">
		<button type="submit" class="btn btn-default">Novo Descartável</button>
		<hr>
	</form>
		<%if(lista != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Descartáveis</th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Descartavel item : lista){%>
	    	<form action="DescartavelController" method="post">
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

</body>
</html>