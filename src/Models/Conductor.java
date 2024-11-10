package Models;

import Repository.AdminRepository;
import Repository.ConductorRepository;
import Repository.RegulacionLaboral;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Conductor extends Usuario{
    private String dias_descanso;

    public static ConductorRepository cr = new ConductorRepository();

    public Conductor(String nombre, String correo, String dni, LocalDate fecha_nacimiento, String contrasena,
                     String distrito, String provincia, String departamento){
        this.nombre = nombre;
        this.correo = correo;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.contrasena = contrasena;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
        this.dias_descanso = "";
    }

    @Override
    public boolean editar_perfil(String nombre, String distrito, String provincia, String departamento) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
        return new ConductorRepository().actualizar(this);
    }

    @Override
    public boolean actualizar_contrasena(String nueva_contrasena) {
        this.contrasena = nueva_contrasena;
        return new ConductorRepository().actualizar(this);
    }

    public static boolean login(String dni, String contrasena) {
        Conductor conductor = new ConductorRepository().buscar(dni);
        if(conductor == null){
            return false;
        }

        return contrasena.equals(conductor.get_contrasena());
    }

    public boolean verificar_dias_descanso(){
        String[] dias = this.dias_descanso.split(",");

        return dias.length <= RegulacionLaboral.obtener_configuraciones().get_limite_dias_descanso();
    }

    public int calcular_edad(){
        LocalDate hoy = LocalDate.now();
        return Period.between(this.fecha_nacimiento, hoy).getYears();
    }



    public String get_dias_descanso(){
        return dias_descanso;
    }

    public void set_dias_descanso(String dias_descanso){
        this.dias_descanso = dias_descanso;
    }
}
