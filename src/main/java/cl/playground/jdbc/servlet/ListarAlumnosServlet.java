package cl.playground.jdbc.servlet;

import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.service.AlumnoService;
import cl.playground.jdbc.service.AlumnoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarAlumnosServlet", value = "/alumnos")
public class ListarAlumnosServlet extends HttpServlet {

    private AlumnoService alumnoService;


    @Override
    public void init() {
        alumnoService = new AlumnoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AlumnoResponseDTO> alumnos = alumnoService.listarAlumnos();

        req.setAttribute("alumnos", alumnos);
        req.getRequestDispatcher("listarAlumnos.jsp").forward(req, resp);
    }
}
