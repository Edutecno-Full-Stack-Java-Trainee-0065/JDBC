package cl.playground.jdbc.servlet;

import cl.playground.jdbc.service.AlumnoService;
import cl.playground.jdbc.service.AlumnoServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EliminarAlumnoServlet", value = "/eliminarAlumno")
public class EliminarAlumnoServlet extends HttpServlet {
    private AlumnoService alumnoService;

    @Override
    public void init() {
        alumnoService = new AlumnoServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        alumnoService.eliminarAlumnoId(id);
        resp.sendRedirect("./alumnos");
    }
}
