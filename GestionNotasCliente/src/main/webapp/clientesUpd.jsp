<%@page import="Model.Estudiantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actualizar Estudiante</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4 p-4" style="border: 1px solid black; border-radius: 20px; box-shadow: #9c9999 8px 8px 0 0; margin-bottom: 100px;">
        <h1 class="mt-3 text-center">Actualizar Estudiante</h1>
        <%
            Estudiantes cliente = (Estudiantes) request.getAttribute("cliente");
            if (cliente != null) {
        %>
        <form class="mt-4" action="ClienteActualizar" method="post" style="padding: 0 20%">
            <input type="hidden" name="codigo" value="<%= cliente.getIdEstudiante() %>">
            <div class="form-group">
                <label for="nombre" style="font-size: 18px; font-weight: 500;">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required="required" pattern="[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+" title="Por favor, ingrese solo letras." value="<%= cliente.getNombre() %>">
            </div>

            <div class="form-group">
                <label for="dni" style="font-size: 18px; font-weight: 500;">DNI:</label>
                <input type="text" class="form-control" id="dni" name="dni" required="required" pattern="[0-9]{8}" maxlength="8" title="Por favor, ingrese 8 dígitos numéricos" value="<%= cliente.getDni() %>">
            </div>

            <div class="form-group" style="font-size: 18px; font-weight: 500;">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required="required" pattern="[0-9]{6,12}" minlength="6" maxlength="12" title="Por favor, ingrese entre 6 y 12 dígitos numéricos" value="<%= cliente.getTelefono() %>">
            </div>

            <div class="form-group">
                <label for="correo" style="font-size: 18px; font-weight: 500;">Correo:</label>
                <input type="email" class="form-control" id="correo" name="correo" required="required" value="<%= cliente.getCorreo() %>">
            </div>

            <!-- Datos del Padre -->
            <div class="form-group">
                <label for="padreNombre" style="font-size: 18px; font-weight: 500;">Nombre del Padre:</label>
                <input type="text" class="form-control" id="padreNombre" name="padreNombre" required="required" pattern="[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+" title="Por favor, ingrese solo letras." value="<%= cliente.getPadre().getNombre() %>">
            </div>

            <div class="form-group">
                <label for="padreDni" style="font-size: 18px; font-weight: 500;">DNI del Padre:</label>
                <input type="text" class="form-control" id="padreDni" name="padreDni" required="required" pattern="[0-9]{8}" maxlength="8" title="Por favor, ingrese 8 dígitos numéricos" value="<%= cliente.getPadre().getDni() %>">
            </div>

            <div class="form-group">
                <label for="padreTelefono" style="font-size: 18px; font-weight: 500;">Teléfono del Padre:</label>
                <input type="text" class="form-control" id="padreTelefono" name="padreTelefono" required="required" pattern="[0-9]{6,12}" minlength="6" maxlength="12" title="Por favor, ingrese entre 6 y 12 dígitos numéricos" value="<%= cliente.getPadre().getTelefono() %>">
            </div>

            <div class="form-group">
                <label for="padreCorreo" style="font-size: 18px; font-weight: 500;">Correo del Padre:</label>
                <input type="email" class="form-control" id="padreCorreo" name="padreCorreo" required="required" value="<%= cliente.getPadre().getCorreo() %>">
            </div>

            <button type="submit" class="btn btn-primary btn-block mt-3">Actualizar</button>
            <a href="ClienteControlador" class="btn btn-danger btn-block mt-2 mb-3">Cancelar</a>
        </form>
        <% } else { %>
            <p>Cliente no encontrado</p>
        <% } %>
    </div>
</body>
</html>
