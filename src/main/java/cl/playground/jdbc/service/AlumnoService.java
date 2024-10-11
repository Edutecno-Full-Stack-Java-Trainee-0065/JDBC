package cl.playground.jdbc.service;

import cl.playground.jdbc.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> listarAlumnos();
    void registrarAlumno(Alumno alumno);
}
