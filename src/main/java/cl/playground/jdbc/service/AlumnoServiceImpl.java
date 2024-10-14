package cl.playground.jdbc.service;

import cl.playground.jdbc.dto.AlumnoCreateDTO;
import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.dto.AlumnoUpdateDTO;
import cl.playground.jdbc.model.Alumno;
import cl.playground.jdbc.repository.AlumnoRepository;
import cl.playground.jdbc.repository.AlumnoRepositoryImpl;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<AlumnoResponseDTO> buscarAlumnoPorId(Long id) {
        return alumnoRepository.buscarAlumno(id)
                .map(this::convertToResponseDTO);
    }

    @Override
    public void actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO) {
        Optional<Alumno> alumnoOptional = alumnoRepository.buscarAlumno(alumnoUpdateDTO.getId());

        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get(); // El Alumno que esta en la base de datos
            alumno.setNombre(alumnoUpdateDTO.getNombre());
            alumno.setApellido(alumnoUpdateDTO.getApellido());
            alumno.setEdad(alumnoUpdateDTO.getEdad());
            alumnoRepository.actualizarAlumno(alumno);

        } else {
            throw new RuntimeException("Alumno no encontrado");
        }
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
