package cl.playground.jdbc.repository;

import cl.playground.jdbc.configuration.DatabaseConnection;
import cl.playground.jdbc.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoRepositoryImpl implements AlumnoRepository {


    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT nombre, apellido, edad FROM alumnos";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()
        ) {
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setEdad(rs.getInt("edad"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los alumnos", e);
        }
        return alumnos;
    }

    @Override
    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombre, apellido, edad) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {
            pstm.setString(1, alumno.getNombre());
            pstm.setString(2, alumno.getApellido());
            pstm.setInt(3, alumno.getEdad());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el alumno", e);
        }
    }

}
