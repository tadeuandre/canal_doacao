<%@page import="negocio.Roupa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	List<Roupa> roupas = (List<Roupa>)request.getAttribute("roupas");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="cabecalho.jsp"/>
   
   <div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
	    	<form action="RoupaController" method="get">
			    <input type="hidden" name="tela" value="Roupa">
				<button type="submit" class="btn btn-default">Nova Roupa</button>
			</form>
	    </div>
	    
	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
			<c:import url="doacaoVoltar.jsp"/>
	    </div>

	    <div class="btn-group">
			<c:import url="sair.jsp"/>
	    </div>
    </div>
		<%if(roupas != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Roupas</th>
	        <th></th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Roupa item : roupas){%>
	    	<form action="RoupaController" method="post">
	    		<input type="hidden" name="idGame" value="<%=item.getId()%>">
		      	<tr>
		        	<td><%=item%></td>
		        	<td><button type="submit" class="btn btn-link">Excluir</button></td>
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