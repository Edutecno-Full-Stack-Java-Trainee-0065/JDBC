package cl.playground.jdbc.service;

import cl.playground.jdbc.model.Alumno;
import cl.playground.jdbc.repository.AlumnoRepository;
import cl.playground.jdbc.repository.AlumnoRepositoryImpl;

import java.util.List;

public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl() {
        this.alumnoRepository = new AlumnoRepositoryImpl();
    }

    @Override
    public List<Alumno> listarAlumnos() {
        // FILTROS PARA LIMPIAR LA INFORMACION

        return alumnoRepository.listarAlumnos();
    }

    @Override
    public void registrarAlumno(Alumno alumno) {

        alumnoRepository.insertarAlumno(alumno);
    }
}
