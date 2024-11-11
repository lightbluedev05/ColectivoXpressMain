package Repository;
import Models.Pasajero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PasajeroRepository implements CRUD<Pasajero>{

    private static final String RUTA_ARCHIVO = "src/resources/pasajeros.json";

    private static class PasajeroDTO {
        private String nombre;
        private String correo;
        private String dni;
        private String fecha_nacimiento;
        private String contrasena;
        private String distrito;
        private String provincia;
        private String departamento;
    }

    private static Pasajero convertirDto_Pasajero(PasajeroDTO dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Cambia el formato según sea necesario
        LocalDate fecha = LocalDate.parse(dto.fecha_nacimiento, formatter);
        return new Pasajero(dto.nombre, dto.correo, dto.dni, fecha, dto.contrasena,
                dto.distrito, dto.provincia, dto.departamento);
    }
    private static PasajeroDTO convertirPasajero_Dto(Pasajero pasajero){
        String fecha = pasajero.get_fecha_nacimiento().toString();
        PasajeroDTO pasajerodto = new PasajeroDTO();
        pasajerodto.nombre = pasajero.get_nombre();
        pasajerodto.correo = pasajero.get_correo();
        pasajerodto.dni = pasajero.get_dni();
        pasajerodto.fecha_nacimiento = fecha;
        pasajerodto.contrasena = pasajero.get_contrasena();
        pasajerodto.distrito = pasajero.get_distrito();
        pasajerodto.provincia = pasajero.get_provincia();
        pasajerodto.departamento = pasajero.get_departamento();
        return pasajerodto;
    }
    
    @Override
    public boolean crear(Pasajero nuevo_pasajero){
        List<PasajeroDTO> pasajeros = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<PasajeroDTO>>(){}.getType();
            Gson gson = new Gson();
            pasajeros = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(pasajeros == null){
            pasajeros = new ArrayList<>();
        } else {
            for(PasajeroDTO pasajero : pasajeros){
                if(pasajero.dni.equals(nuevo_pasajero.get_dni())){
                    return false;
                }
            }
        }

        pasajeros.add(convertirPasajero_Dto(nuevo_pasajero));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String pasajeros_json = gson.toJson(pasajeros);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(pasajeros_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Pasajero buscar(String dni){
        List<PasajeroDTO> pasajeros = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<PasajeroDTO>>(){}.getType();
            Gson gson = new Gson();
            pasajeros = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(pasajeros!=null){
            for(PasajeroDTO pasajero : pasajeros){
                if(pasajero.dni.equals(dni)){
                    return convertirDto_Pasajero(pasajero);
                }
            }
        }

        return null;
    }

    @Override
    public boolean actualizar(Pasajero pasajero_editar){
        List<PasajeroDTO> pasajeros = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<PasajeroDTO>>(){}.getType();
            Gson gson = new Gson();
            pasajeros = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(pasajeros == null){
            return false;
        }

        for(int i=0; i<pasajeros.size(); i++){
            PasajeroDTO pasajero = pasajeros.get(i);
            if(pasajero.dni.equals(pasajero_editar.get_dni())){
                pasajeros.set(i, convertirPasajero_Dto(pasajero_editar));
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String pasajeros_json = gson.toJson(pasajeros);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(pasajeros_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(String dni){
        List<PasajeroDTO> pasajeros = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<PasajeroDTO>>(){}.getType();
            Gson gson = new Gson();
            pasajeros = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(pasajeros == null){
            return false;
        }

        for(int i=0; i<pasajeros.size(); i++){
            PasajeroDTO pasajero = pasajeros.get(i);
            if(pasajero.dni.equals(dni)){
                pasajeros.remove(i);
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String pasajeros_json = gson.toJson(pasajeros);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(pasajeros_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pasajero> listar(){
        List<PasajeroDTO> pasajeros = null;
        List<Pasajero> pasajeros2 = new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<PasajeroDTO>>(){}.getType();
            Gson gson = new Gson();
            pasajeros = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(pasajeros!=null){
            for(PasajeroDTO pasajero : pasajeros){
                pasajeros2.add(convertirDto_Pasajero(pasajero));
            }
        }
        return pasajeros2;
    }

}
