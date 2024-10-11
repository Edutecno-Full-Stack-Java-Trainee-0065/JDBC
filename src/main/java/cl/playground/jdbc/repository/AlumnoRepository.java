package cl.playground.jdbc.repository;

import cl.playground.jdbc.model.Alumno;

import java.util.List;

public interface AlumnoRepository {
    List<Alumno> listarAlumnos();
    void insertarAlumno(Alumno alumno);
}
