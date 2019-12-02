<%@page import="negocio.Doacao"%>
<%@page import="negocio.Beneficiario"%>
<%@page import="java.util.List"%>
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
	List<Beneficiario> lista = (List<Beneficiario>)request.getAttribute("beneficiarios");
	
	int idBeneficiario = doacao.getBeneficiario() != null ? doacao.getBeneficiario().getId() : 0;
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

	<div class="form-group">
	  <label for="dia">Data da Divulgação:</label>
	  <input type="text" class="form-control" id="dia" placeholder="Entre com a data" name="dia" readonly="readonly">
	</div>

	<form action="BeneficiarioDoacaoController" method="post">
		<div class="form-group">
		  <label for="dia">Beneficiário:</label>
		  <select class="form-control" id="idBeneficiario" name="idBeneficiario">
		  	<option></option>
		  </select>
		</div>
		<div class="form-group">

		  <%if(lista.size() > 0){%>
		  <label for="solicitante">Beneficiário:</label>
		  <select class="form-control" name="idSolicitante">
	    	<%for(Beneficiario item : lista){%>
		    <option <%=idBeneficiario == item.getId() ? "selected" : ""%> value="<%=item.getId()%>"><%=item%></option>
	    	<%}%>
	      </select>
	    	<%} else {%>
	       <label>Nenhum beneficiário disponível para doação!</label>
	       <%} %>
		</div>

	    <button type="submit" class="btn btn-default"  <%=lista.size() == 0 ? "disabled" : "" %> >Cadastrar</button>
  	</form>
</div>
</div>
</div>
</div>
</body>
</html>