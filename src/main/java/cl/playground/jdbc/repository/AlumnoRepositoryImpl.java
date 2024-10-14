package cl.playground.jdbc.repository;

import cl.playground.jdbc.configuration.DatabaseConnection;
import cl.playground.jdbc.dto.AlumnoResponseDTO;
import cl.playground.jdbc.dto.AlumnoUpdateDTO;
import cl.playground.jdbc.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlumnoRepositoryImpl implements AlumnoRepository {


    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, edad FROM alumnos ORDER BY id";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()
        ) {
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getLong("id"));
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

    @Override
    public Optional<Alumno> buscarAlumno(Long id) {
        String sql = "SELECT id, nombre, apellido, edad FROM alumnos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {

            pstm.setLong(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getLong("id"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setEdad(rs.getInt("edad"));
                    return Optional.of(alumno);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el alumno por ID", e);
        }

        return Optional.empty();
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET nombre = ?, apellido = ?, edad = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {

            pstm.setString(1, alumno.getNombre());
            pstm.setString(2, alumno.getApellido());
            pstm.setInt(3, alumno.getEdad());
            pstm.setLong(4, alumno.getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el alumno", e);
        }
    }

    @Override
    public void eliminarAlumno(Long id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)
        ) {
            pstm.setLong(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("No es posible eliminar alumno", e);
        }
    }
}
