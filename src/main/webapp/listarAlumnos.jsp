<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cl.playground.jdbc.model.Alumno" %>
<%@ page import="cl.playground.jdbc.dto.AlumnoResponseDTO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Alumnos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Lista de Alumnos</h1>
    <a href="${pageContext.request.contextPath}/alumno" class="btn btn-primary mb-3">Insertar Nuevo Alumno</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Edad</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<AlumnoResponseDTO> alumnos = (List<AlumnoResponseDTO>) request.getAttribute("alumnos");
            if (alumnos != null) {
                for (AlumnoResponseDTO alumno : alumnos) {
        %>
        <tr>
            <td><%= alumno.getNombre() %></td>
            <td><%= alumno.getApellido() %></td>
            <td><%= alumno.getEdad() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/actualizarAlumno?id=<%= alumno.getId() %>" class="btn btn-primary">Editar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>