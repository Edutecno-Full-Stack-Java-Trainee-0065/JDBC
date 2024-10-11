package cl.playground.jdbc.servlet;

import cl.playground.jdbc.model.Alumno;
import cl.playground.jdbc.service.AlumnoService;
import cl.playground.jdbc.service.AlumnoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "InsertarAlumnoServlet", value = "/alumno")
public class InsertarAlumnoServlet extends HttpServlet {

    private AlumnoService alumnoService;

    @Override
    public void init() throws ServletException {
        alumnoService = new AlumnoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("insertarAlumno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        int edad = Integer.parseInt(req.getParameter("edad"));

        Alumno alumno = new Alumno(nombre, apellido, edad);
        alumnoService.registrarAlumno(alumno);

        resp.sendRedirect(req.getContextPath() + "/alumnos");

    }
}
