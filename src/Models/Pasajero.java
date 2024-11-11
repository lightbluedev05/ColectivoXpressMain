package Models;

import Repository.BoletoRepository;
import Repository.ConductorRepository;
import Repository.PasajeroRepository;
import Repository.ViajeRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Pasajero extends Usuario {

    public static PasajeroRepository pr = new PasajeroRepository();

    public Pasajero(String nombre, String correo, String dni, LocalDate fecha_nacimiento, String contrasena,
                    String distrito, String provincia, String departamento) {
        this.nombre = nombre;
        this.correo = correo;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.contrasena = contrasena;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
    }


    @Override
    public boolean editar_perfil(String nombre, String distrito, String provincia, String departamento) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
        return new PasajeroRepository().actualizar(this);
    }

    @Override
    public boolean actualizar_contrasena(String nueva_contrasena) {
        this.contrasena = nueva_contrasena;
        return new PasajeroRepository().actualizar(this);
    }

    public static boolean registro_pasajero(Pasajero nuevo_pasajero){
        return new PasajeroRepository().crear(nuevo_pasajero);
    }

    public static boolean login(String dni, String contrasena) {
        Pasajero pasajero = new PasajeroRepository().buscar(dni);
        if(pasajero==null){
            return false;
        }

        return pasajero.contrasena.equals(contrasena);
    }

    public boolean comprar_boleto(String id_viaje){
        Viaje viaje = new ViajeRepository().buscar(id_viaje);
        if(viaje==null){
            return false;
        }

        return Boleto.generar_boleto(viaje, this);
    }

    public List<Viaje> ver_historial_viajes(){
        List<Boleto> boletos = new BoletoRepository().listar();
        List<Viaje> viajes = new ArrayList<>();

        for(Boleto boleto : boletos){
            if(boleto.get_pasajero().get_dni().equals(this.dni)){
                viajes.add(boleto.get_viaje());
            }
        }

        return viajes;
    }

    public int calcular_edad(){
        return Period.between(this.fecha_nacimiento, LocalDate.now()).getYears();
    }
}
