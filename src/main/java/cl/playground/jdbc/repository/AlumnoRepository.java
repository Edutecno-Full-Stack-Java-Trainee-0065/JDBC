package cl.playground.jdbc.repository;

import cl.playground.jdbc.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {
    List<Alumno> listarAlumnos();
    void insertarAlumno(Alumno alumno);
    Optional<Alumno> buscarAlumno(Long id);
    void actualizarAlumno(Alumno alumno);
}
