<%@page import="java.util.ArrayList"%>
<%@page import="negocio.Doacao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
  <title>AppMyEmprestimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Doacao> lista = (List<Doacao>)request.getAttribute("doacoes");
	%>

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="cabecalho.jsp"/>
   
   	<div class="panel-body">
	  <div class="btn-group btn-group-justified">
	    <div class="btn-group">
			<form action="BrinquedoController">
				<button type="submit" class="btn btn-default">Brinquedo</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="DescartavelController">
				<button type="submit" class="btn btn-default">Descartável</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="RoupaController">
				<button type="submit" class="btn btn-default">Roupa</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="BeneficiarioController">
				<button type="submit" class="btn btn-default">Beneficiário</button>
			</form>
	    </div>
	    <div class="btn-group">
			<c:import url="sair.jsp"/>
	    </div>
	  </div>
	</div>
	
   	<div class="panel-body">
	    <div class="btn-group">
			<form action="DoacaoController" method="get">
				<button type="submit" class="btn btn-link" name="tela" value="doacaoDetalhe">Nova Doação</button>
			</form>
	    </div>	  

		<%if(lista.size() > 0){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Doações</th>
	        <th>Total</th>
	        <th></th>
	        <th></th>
	        <th></th>
	        <th></th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Doacao item : lista){%>
		      	<tr>
		        	<td><%=item%></td>
		        	<td><%=item.getProdutos() == null ? 0 : item.getProdutos().size()%></td>
		        	<td>
			    	<form action="BeneficiarioDoacaoController" method="get">
			    		<input type="hidden" name="id" value="<%=item.getId()%>">
				        	<button type="submit" class="btn btn-link">Beneficiário</button>
			      	</form>
		        	</td>
		        	<td>
			    	<form action="ProdutoDoacaoController" method="get">
			    		<input type="hidden" name="id" value="<%=item.getId()%>">
				        	<button type="submit" class="btn btn-link">Produtos</button>
			      	</form>
		        	</td>
		        	<td>
			    	<form action="ConsultaDoacaoController" method="get">
			    		<input type="hidden" name="id" value="<%=item.getId()%>">
				        	<button type="submit" class="btn btn-link">Detalhar</button>
			      	</form>
		        	</td>
		        	<td>
			    	<form action="ExclusaoDoacaoController" method="post">
			    		<input type="hidden" name="id" value="<%=item.getId()%>">
				        	<button type="submit" class="btn btn-link">Excluir</button>
			      	</form>
		        	</td>
		      	</tr>
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