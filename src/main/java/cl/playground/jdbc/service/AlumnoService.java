package cl.playground.jdbc.service;

import cl.playground.jdbc.dto.AlumnoCreateDTO;
import cl.playground.jdbc.dto.AlumnoResponseDTO;

import java.util.List;

public interface AlumnoService {
    List<AlumnoResponseDTO> listarAlumnos();
    void registrarAlumno(AlumnoCreateDTO alumno);
}
