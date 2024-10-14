package cl.playground.jdbc.service;

import cl.playground.jdbc.dto.AlumnoCreateDTO;
import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.dto.AlumnoUpdateDTO;
import cl.playground.jdbc.model.Alumno;
import cl.playground.jdbc.repository.AlumnoRepository;
import cl.playground.jdbc.repository.AlumnoRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl() {
        this.alumnoRepository = new AlumnoRepositoryImpl();
    }

    @Override
    public List<AlumnoResponseDTO> listarAlumnos() {
        return alumnoRepository.listarAlumnos().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void registrarAlumno(AlumnoCreateDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setEdad(alumnoDTO.getEdad());

        alumnoRepository.insertarAlumno(alumno);
    }



    private AlumnoResponseDTO convertToResponseDTO(Alumno alumno) {
        return new AlumnoResponseDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEdad()
        );
    }
}
