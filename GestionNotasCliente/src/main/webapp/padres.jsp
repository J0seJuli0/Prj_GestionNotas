<%@page import="Model.Padre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Clientes</title>
<!-- Agregar Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABQb5P6f+v7i1zJURt74EG7i5tbb7t35cQbP2w5Fwe7SKzY1YYbN8K1h" crossorigin="anonymous">
<!-- Estilos personalizados -->
<style>
    body {
        background-color: #f8f9fa;
    }
    .container {
        margin-top: 20px;
    }
    .btn-custom {
        border-radius: 30px;
        padding: 10px 20px;
        font-weight: bold;
    }
    .table {
        margin-top: 20px;
    }
    .table th, .table td {
        text-align: center;
        vertical-align: middle;
    }
    .table-striped tbody tr:nth-of-type(odd) {
        background-color: #f2f2f2;
    }
    .table th {
        background-color: #007bff;
        color: white;
    }
    .table td {
        background-color: #ffffff;
    }
    .modal-content {
        border-radius: 20px;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }
    .modal-header {
        background-color: #007bff;
        color: white;
    }
    .modal-footer {
        background-color: #f1f1f1;
    }
    .form-label {
        font-size: 1rem;
        font-weight: 600;
    }
</style>
</head>
<body>
<div class="container mt-4 p-4" style="border: 1px solid #ccc; border-radius: 20px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);">
    <div class="row">
        <div class="col-12">
            <h1 class="text-center mb-4">Clientes</h1>
            <div class="d-flex justify-content-between mb-3">
                <button type="button" class="btn btn-primary btn-custom" data-bs-toggle="modal" data-bs-target="#nuevoEstudianteModal">Nuevo Cliente</button>
                <a href="reporteClientes/pdf" class="btn btn-warning btn-custom">Generar Reporte</a>
            </div>
            <form action="PadreController" method="get" class="d-flex justify-content-end m-1 gap-2">
                <input type="number" name="codigoCliente" placeholder="Buscar por Codigo" class="form-control" min="0" oninput="this.value = this.value.replace(/[^0-9]/g, '');" />
                <button class="btn btn-dark btn-custom">Buscar</button>
            </form>

            <% 
                String mensaje = (String) request.getAttribute("mensaje");
                if (mensaje != null && mensaje.startsWith("Swal.fire")) {
            %>
            <script>
                <%= mensaje %>
            </script>
            <% } %>	

            <!-- Tabla de clientes -->
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr class="thead-light text-center">
                        <th>CODIGO</th>
                        <th>NOMBRES</th>
                        <th>DNI</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    List<Padre> clientes = (List<Padre>) request.getAttribute("clientes");
                    if (clientes != null && !clientes.isEmpty()) {
                        for(Padre cliente : clientes) {
                %>
                    <tr>
                        <td><%= cliente.getIdPadre() %></td>
                        <td><%= cliente.getNombre() %></td>
                        <td><%= cliente.getDni() %></td>
                        <td><%= cliente.getTelefono() %></td>
                        <td><%= cliente.getCorreo() %></td>
                        <td class="text-center">
                            <a href="PadreController?accion=editar&id=<%= cliente.getIdPadre() %>" class="btn btn-sm btn-success btn-custom">Editar</a>
                            <a href="PadreController?accion=eliminar&id=<%= cliente.getIdPadre() %>" class="btn btn-sm btn-danger btn-custom eliminar-cliente">Eliminar</a>
                        </td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="10" class="text-center">No hay clientes registrados</td>
                    </tr>
                <% 
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal Nuevo Estudiante -->
<div class="modal fade" id="nuevoEstudianteModal" tabindex="-1" aria-labelledby="nuevoEstudianteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="nuevoEstudianteModalLabel">Nuevo Estudiante</h2>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="formularioRegistro" action="EstudianteRegistro" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="mb-3">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" class="form-control" id="dni" name="dni" required>
            </div>
            <div class="mb-3">
                <label for="fecha" class="form-label">Fecha de Nacimiento</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>
            <div class="mb-3">
                <label for="genero" class="form-label">Género</label>
                <select class="form-control" id="genero" name="genero" required>
                    <option value="M">Masculino</option>
                    <option value="F">Femenino</option>
                    <option value="Otro">Otro</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="direccion" class="form-label">Dirección</label>
                <input type="text" class="form-control" id="direccion" name="direccion" required>
            </div>
            <div class="mb-3">
                <label for="telefono" class="form-label">Teléfono</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required>
            </div>
            <div class="mb-3">
                <label for="correo" class="form-label">Correo Electrónico</label>
                <input type="email" class="form-control" id="correo" name="correo" required>
            </div>

            <!-- Datos del Padre o Tutor -->
            <div class="mb-3">
                <label for="padreNombre" class="form-label">Nombre del Padre o Tutor</label>
                <input type="text" class="form-control" id="padreNombre" name="padreNombre" required>
            </div>
            <div class="mb-3">
                <label for="padreDni" class="form-label">DNI del Padre o Tutor</label>
                <input type="text" class="form-control" id="padreDni" name="padreDni" required>
            </div>
            <div class="mb-3">
                <label for="padreTelefono" class="form-label">Teléfono del Padre o Tutor</label>
                <input type="text" class="form-control" id="padreTelefono" name="padreTelefono" required>
            </div>
            <div class="mb-3">
                <label for="padreCorreo" class="form-label">Correo Electrónico del Padre o Tutor</label>
                <input type="email" class="form-control" id="padreCorreo" name="padreCorreo" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Registrar</button>
                <a href="PadreController" class="btn btn-danger">Cancelar</a>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
    document.getElementById("formularioRegistro").addEventListener("submit", function(event) {
        event.preventDefault();
        Swal.fire({
            icon: 'success',
            title: 'Registro exitoso',
            text: 'Cliente registrado exitosamente',
            showConfirmButton: false,
            timer: 2000,
            allowOutsideClick: false 
        });
        setTimeout(function(){
            document.getElementById("formularioRegistro").submit();
        }, 1500);
    });
</script>
<!-- Scripts Bootstrap y SweetAlert -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.querySelectorAll('.eliminar-cliente').forEach(function(el) {
        el.addEventListener('click', function(event) {
            event.preventDefault();
            const url = this.getAttribute('href');
            Swal.fire({
                title: '¿Estás seguro?',
                text: 'Una vez eliminado, no podrás recuperar este cliente.',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#d33',
                cancelButtonColor: '#3085d6',
                confirmButtonText: 'Sí, eliminar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = url;
                }
            });
        });
    });
</script>
</body>
</html>
