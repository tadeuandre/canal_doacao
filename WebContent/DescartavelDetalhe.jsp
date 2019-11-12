<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <h2>Descartável</h2>
  <form action="DescartavelController" method="post">
  
    <div class="form-group">
      <label for="validade">Validade:</label>
      <input type="text" class="form-control" id="validade" placeholder="Entre com a validade" name="validade">
    </div>
    
    <div class="form-group">
      <label for="unidadeMedida">Unidade de Medida:</label>
      <input type="text" class="form-control" id="unidadeMedida" placeholder="Entre com a unidade de medida" name="unidadeMedida">
    </div>
    
    <div class="checkbox">
      <label><input type="checkbox" name="isRemedio" value="true">Remédio</label>
    </div>
    
    <div class="checkbox">
      <label><input type="checkbox" name="isAberto" value="true">Aberto</label>
    </div>
    
    <button type="submit" class="btn btn-default">Salvar</button>
    
  </form>
</div>

</body>
</html>