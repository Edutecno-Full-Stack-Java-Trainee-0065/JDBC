package cl.playground.jdbc.servlet;

import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.dto.AlumnoUpdateDTO;
import cl.playground.jdbc.service.AlumnoService;
import cl.playground.jdbc.service.AlumnoServiceImpl;
import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ActualizarAlumnoServlet", value = "/actualizarAlumno")
public class ActualizarAlumnoServlet extends HttpServlet {

    private AlumnoService alumnoService;

    @Override
    public void init(ServletConfig config) {
        alumnoService = new AlumnoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<AlumnoResponseDTO> alumno = alumnoService.buscarAlumnoPorId(id);

        if (alumno.isPresent()) {
            req.setAttribute("alumno", alumno.get());
            req.getRequestDispatcher("actualizarAlumno.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/alumnos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        int edad = Integer.parseInt(req.getParameter("edad"));

        AlumnoUpdateDTO alumnoUpdateDTO = new AlumnoUpdateDTO(id, nombre, apellido, edad);
        alumnoService.actualizarAlumno(alumnoUpdateDTO);

        resp.sendRedirect(req.getContextPath() + "/alumnos");
    }
}
