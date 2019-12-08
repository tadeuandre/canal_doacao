<%@page import="java.util.List"%>
<%@page import="negocio.Descartavel"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	List<Descartavel> descartaveis = (List<Descartavel>)request.getAttribute("descartaveis");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="cabecalho.jsp"/>
   
   <div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
			<form action="DescartavelController" method="get">
				<input type="hidden" name="tela" value="Descartavel">
				<button type="submit" class="btn btn-default">Novo Descartável</button>
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
		<%if(descartaveis != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Descartáveis</th>
	        <th></th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Descartavel item : descartaveis){%>
	    	<form action="DescartavelController" method="post">
	    		<input type="hidden" name="idDescartavel" value="<%=item.getId()%>">
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