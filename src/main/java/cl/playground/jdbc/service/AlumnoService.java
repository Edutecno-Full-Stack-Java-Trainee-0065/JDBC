package cl.playground.jdbc.service;

import cl.playground.jdbc.dto.AlumnoCreateDTO;
import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.dto.AlumnoUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<AlumnoResponseDTO> listarAlumnos();
    void registrarAlumno(AlumnoCreateDTO alumno);
    Optional<AlumnoResponseDTO> buscarAlumnoPorId(Long id);
    void actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO);
}
