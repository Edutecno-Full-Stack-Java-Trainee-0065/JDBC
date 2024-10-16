package cl.playground.jdbc.model;

import javax.persistence.*;

@Entity
@Table( name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long alumnoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido, int edad) {
        this.alumnoId = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Long getId() {
        return alumnoId;
    }

    public void setId(Long id) {
        this.alumnoId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + alumnoId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
