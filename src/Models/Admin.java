package Models;

import Repository.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Admin {
    private String codigo;
    private String contrasena;


    public Admin(String codigo, String contrasena){
        this.codigo = codigo;
        this.contrasena = contrasena;
    }

    public static boolean registrar_admin(String codigo, String contrasena){
        Admin nuevo_admin = new Admin(codigo, contrasena);
        return AdminRepository.crear_admin(nuevo_admin);
    }

    public static boolean login_admin(String codigo, String contrasena){
        Admin admin = AdminRepository.buscar_admin(codigo);
        if(admin == null){
            return false;
        }

        return admin.get_contrasena().equals(contrasena);
    }

    public boolean actualizar_codigo(String nuevo_codigo){
        Admin admin = AdminRepository.buscar_admin(this.get_codigo());

        if(admin == null){
            return false;
        }

        AdminRepository.eliminar_admin(this.get_codigo());

        admin.set_codigo(nuevo_codigo);
        return AdminRepository.crear_admin(admin);
    }

    public boolean actualizar_contrasena(String nueva_contrasena){
        Admin admin = AdminRepository.buscar_admin(this.get_codigo());
        if(admin == null){
            return false;
        }
        admin.set_contrasena(nueva_contrasena);

        return AdminRepository.actualizar_admin(admin);
    }

    //------------------  ACCIONES SOBRE CONDUCTORES ---------------------

    public boolean crear_conductor(String nombre, String correo, String dni, LocalDate fecha_nacimiento, String contrasena,
                                   String distrito, String provincia, String departamento){
        Conductor nuevo_conductor = new Conductor(nombre, correo, dni, fecha_nacimiento,
                contrasena, distrito, provincia, departamento);

        return ConductorRepository.crear_conductor(nuevo_conductor);
    }

    public boolean eliminar_conductor(String dni){
        return ConductorRepository.eliminar_conductor(dni);
    }

    public Conductor buscar_conductor(String dni){
        return ConductorRepository.buscar_conductor(dni);
    }

    public List<Conductor> ver_conductores(){
        return ConductorRepository.listar_conductores();
    }

    //--------------------- ACCIONES SOBRE PASAJEROS -----------------------
    public boolean crear_pasajero(String nombre, String correo, String dni, LocalDate fecha_nacimiento,
                                  String contrasena, String distrito, String provincia, String departamento){
        Pasajero nuevo_pasajero = new Pasajero(nombre, correo, dni, fecha_nacimiento,
                contrasena, distrito, provincia, departamento);

        return PasajeroRepository.crear_pasajero(nuevo_pasajero);
    }
    public boolean eliminar_pasajero(String dni) {
        return PasajeroRepository.eliminar_pasajero(dni);
    }

    public Pasajero buscar_pasajero(String dni) {
        return PasajeroRepository.buscar_pasajero(dni);
    }

    public List<Pasajero> ver_pasajeros() {
        return PasajeroRepository.listar_pasajeros();
    }

    //--------------------- ACCIONES SOBRE RUTAS -----------------------
    public boolean crear_ruta(String origen, String destino, Duration tiempo_aproximado, float precio){
        String id_ruta;
        Random random = new Random();
        do{
            int codigo = 10000 + random.nextInt(90000);
            id_ruta = String.valueOf(codigo);
        } while(RutaRepository.buscar_ruta(id_ruta)!=null);

        Ruta nueva_ruta = new Ruta(id_ruta, origen, destino, tiempo_aproximado, precio);
        return RutaRepository.crear_ruta(nueva_ruta);
    }

    public boolean editar_ruta(String id_ruta, String origen, String destino, Duration tiempo_aproximado, float precio){
        Ruta ruta_editar = RutaRepository.buscar_ruta(id_ruta);
        if(ruta_editar == null){
            return false;
        }
        if(!origen.isEmpty()){
            ruta_editar.set_origen(origen);
        }
        if(!destino.isEmpty()){
            ruta_editar.set_destino(destino);
        }
        if(tiempo_aproximado != null){
            ruta_editar.set_tiempo_aproximado(tiempo_aproximado);
        }
        if(precio != 0){
            ruta_editar.set_precio(precio);
        }
        return RutaRepository.actualizar_ruta(ruta_editar);
    }

    public boolean eliminar_ruta(String id_ruta){
        return RutaRepository.eliminar_ruta(id_ruta);
    }

    public Ruta buscar_ruta(String id_ruta){
        return RutaRepository.buscar_ruta(id_ruta);
    }

    public List<Ruta> ver_rutas(){
        return RutaRepository.listar_rutas();
    }

    //--------------------- ACCIONES SOBRE VIAJES -----------------------
    public boolean crear_viaje(LocalDate fecha_salida, String id_ruta, String dni_conductor){
        Ruta ruta = RutaRepository.buscar_ruta(id_ruta);
        if(ruta == null){
            return false;
        }
        Conductor conductor = ConductorRepository.buscar_conductor(dni_conductor);
        if(conductor == null){
            return false;
        }

        String id_viaje;
        Random random = new Random();
        do{
            int codigo = 10000 + random.nextInt(90000);
            id_viaje = String.valueOf(codigo);
        } while(ViajeRepository.buscar_viaje(id_viaje)!=null);

        Viaje nuevo_viaje = new Viaje(id_viaje, fecha_salida, ruta, conductor);
        return ViajeRepository.crear_viaje(nuevo_viaje);
    }

    public boolean editar_viaje(String id_viaje, LocalDate fecha_salida, String id_ruta, String dni_conductor){
        Viaje viaje_editar = ViajeRepository.buscar_viaje(id_viaje);
        if(viaje_editar == null){
            return false;
        }

        if(fecha_salida != null){
            viaje_editar.set_fecha_salida(fecha_salida);
        }
        if(!id_ruta.isEmpty()){
            viaje_editar.set_ruta(RutaRepository.buscar_ruta(id_ruta));
        }
        if(!dni_conductor.isEmpty()){
            viaje_editar.set_conductor(ConductorRepository.buscar_conductor(dni_conductor));
        }

        return ViajeRepository.actualizar_viaje(viaje_editar);
    }

    public boolean eliminar_viaje(String dni){
        return ViajeRepository.eliminar_viaje(dni);
    }

    public Viaje buscar_viaje(String id_viaje){
        return ViajeRepository.buscar_viaje(id_viaje);
    }

    public List<Viaje> ver_viajes(){
        return ViajeRepository.listar_viajes();
    }

    public boolean editar_limite_dias_descanso(int limite_dias){
        RegulacionLaboral regulacion = RegulacionLaboral.obtener_configuraciones();
        if(regulacion == null){
            return false;
        }
        regulacion.set_limite_dias_descanso(limite_dias);
        return RegulacionLaboral.guardar_configuraciones(regulacion);
    }







    public String get_codigo(){
        return this.codigo;
    }

    public String get_contrasena(){
        return this.contrasena;
    }

    public void set_codigo(String nuevo_codigo){
        this.codigo = nuevo_codigo;
    }

    public void set_contrasena(String nueva_contrasena){
        this.contrasena = nueva_contrasena;
    }
}
