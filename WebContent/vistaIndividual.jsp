<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.banco.modelo.TarjetaCredito"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Individual</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
<form action="Procesar" method="get">
 <h1>Puede modificar solamente el cupo disponible.</h1>
 <br></br>
 <br></br>
 <% TarjetaCredito tarjetacredito = (TarjetaCredito)request.getAttribute("tarjetacredito"); %>
<table>
    <tr>
      <th>N�mero</th>
      <th>Cupo M�ximo</th>
      <th>Cupo Disponible</th>
      <th>Tipo</th>
   </tr>
    <tr>
      <td><input type="text" name="numero" value="<%=tarjetacredito.getNumero() %>" readonly="readonly"/></td>
      <td><input type="text" name="cupoMaximo" value="<%=tarjetacredito.getCupoMaximo() %>" readonly="readonly"/></td>
      <td><input type="text" name="cupoDisponible" value="<%=tarjetacredito.getCupoDisponible() %>"/></td>
      <td><input type="text" name="tipo" value="<%=tarjetacredito.getTipo() %>" readonly="readonly"/></td>
   </tr>
    <tr>  
      <th>Numero de Comprobaci�n</th>
      <th>Contrase�a</th>
      <th>Id</th>
   </tr>
    <tr>   
      <td><input type="text" name="numeroComprobacion" value="<%=tarjetacredito.getNumeroComprobacion() %>" readonly="readonly"/></td>
      <td><input type="text" name="contrasenha" value="<%=tarjetacredito.getContrasenha() %>" readonly="readonly"/></td>
      <td><input type="text" name="id" value="<%=tarjetacredito.getId() %>" readonly="readonly"/></td>  
  </tr>
</table>
<br></br>
 <br></br>
 <input class="botones" type="submit" value="Actualizar" id="actualizar" name="actualizar"/>
</form>
<br></br>
<br></br>
  <a href="index.html">Ir a inicio</a>
</body>
</html>
      

        