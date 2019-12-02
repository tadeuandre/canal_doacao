<%@page import="java.util.Set"%>
<%@page import="modelo.Produto"%>
<%@page import="negocio.Doacao"%>
<%@page import="negocio.Beneficiario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppCanalDoacao</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<% 
	Doacao doacao = (Doacao)request.getAttribute("doacao");
	%> 

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="cabecalho.jsp"/>
	
   <div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
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

	<form action="" method="get">
	    <div class="form-group">
	      <label for="dia">Dia:</label>
	      <input type="text" class="form-control" id="dia" placeholder="Entre com o dia" name="dia" readonly="readonly" value="<%=doacao.getDataDivulgacao()%>">
	    </div>

		<div class="form-group">
		  <%if(doacao.getProdutos() != null ? doacao.getProdutos().size() > 0 : false){%>
	  		  <label>Produtos:</label>		  
	    	<%for(Produto item : doacao.getProdutos()){%>
			  <div class="container">
	    		<input type="checkbox" disabled checked name="produtos"> <%=item%>
	  		  </div>
	    	<%}
	       } else {%>
	       <label>Nenhum produto disponível para doar!</label>
	       <%} %>
	    
		</div>
  	</form>
</div>
</div>
</div>
</div>
</body>
</html>