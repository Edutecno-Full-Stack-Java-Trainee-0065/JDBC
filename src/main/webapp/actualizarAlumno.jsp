<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cl.playground.jdbc.dto.AlumnoResponseDTO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Actualizar Alumno</h1>
    <% AlumnoResponseDTO alumno = (AlumnoResponseDTO) request.getAttribute("alumno"); %>
    <form action="${pageContext.request.contextPath}/actualizarAlumno" method="post">
        <input type="hidden" name="id" value="<%= alumno.getId() %>">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="<%= alumno.getNombre() %>" required>
        </div>
        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellido" name="apellido" value="<%= alumno.getApellido() %>" required>
        </div>
        <div class="mb-3">
            <label for="edad" class="form-label">Edad</label>
            <input type="number" class="form-control" id="edad" name="edad" value="<%= alumno.getEdad() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar</button>
        <a href="${pageContext.request.contextPath}/alumnos" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>