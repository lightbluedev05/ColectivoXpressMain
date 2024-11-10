package Models;

import java.time.LocalDate;

public abstract class Usuario {
    protected String nombre;
    protected String correo;
    protected String dni;
    protected LocalDate fecha_nacimiento;
    protected String contrasena;
    protected String distrito;
    protected String provincia;
    protected String departamento;

    public abstract boolean editar_perfil(String nombre, String distrito, String provincia, String departamento);
    public abstract boolean actualizar_contrasena(String nueva_contrasena);


    public String get_nombre() {
        return nombre;
    }

    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }

    public String get_correo() {
        return correo;
    }

    public void set_correo(String correo) {
        this.correo = correo;
    }

    public String get_dni() {
        return dni;
    }

    public void set_dni(String dni) {
        this.dni = dni;
    }

    public LocalDate get_fecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void set_fecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String get_contrasena() {
        return contrasena;
    }

    public void set_contrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String get_distrito() {
        return distrito;
    }

    public void set_distrito(String distrito) {
        this.distrito = distrito;
    }

    public String get_provincia() {
        return provincia;
    }

    public void set_provincia(String provincia) {
        this.provincia = provincia;
    }

    public String get_departamento() {
        return departamento;
    }

    public void set_departamento(String departamento) {
        this.departamento = departamento;
    }
}
