package cl.playground.jdbc.repository;

import cl.playground.jdbc.configuration.HibernateUtil;
import cl.playground.jdbc.model.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AlumnoRepositoryImpl implements AlumnoRepository {


    @Override
    public List<Alumno> listarAlumnos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Alumno", Alumno.class).list();
        }
    }

    @Override
    public void insertarAlumno(Alumno alumno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(alumno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al insertar el alumno", e);
        }
    }

    @Override
    public Optional<Alumno> buscarAlumno(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Alumno alumno = session.get(Alumno.class, id);
            return Optional.ofNullable(alumno);
        }
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(alumno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al actualizar el alumno", e);
        }
    }

    @Override
    public void eliminarAlumno(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Alumno alumno = session.get(Alumno.class, id);
            if (alumno != null) {
                session.delete(alumno);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al eliminar el alumno", e);
        }
    }
}
