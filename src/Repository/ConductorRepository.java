package Repository;

import Models.Conductor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
//comentario
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConductorRepository {

    private static final String RUTA_ARCHIVO = "src/resources/conductores.json";

    private static class ConductorDTO {
        private String nombre;
        private String correo;
        private String dni;
        private String fecha_nacimiento;
        private String contrasena;
        private String distrito;
        private String provincia;
        private String departamento;
        private String dias_descanso;
    }

    private static Conductor convertirDto_Conductor(ConductorDTO dto){
        LocalDate fecha = LocalDate.parse(dto.fecha_nacimiento);
        return new Conductor(dto.nombre, dto.correo, dto.dni, fecha, dto.contrasena,
                dto.distrito, dto.provincia, dto.departamento);
    }

    private static ConductorDTO convertirConductor_Dto(Conductor conductor){
        String fecha = conductor.get_fecha_nacimiento().toString();
        ConductorDTO conductordto = new ConductorDTO();
        conductordto.nombre = conductor.get_nombre();
        conductordto.correo = conductor.get_correo();
        conductordto.dni = conductor.get_dni();
        conductordto.fecha_nacimiento = fecha;
        conductordto.contrasena = conductor.get_contrasena();
        conductordto.distrito = conductor.get_distrito();
        conductordto.provincia = conductor.get_provincia();
        conductordto.departamento = conductor.get_departamento();
        conductordto.dias_descanso = conductor.get_dias_descanso();
        return conductordto;
    }

    public static boolean crear_conductor(Conductor nuevo_conductor) {
        List<ConductorDTO> conductores = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ConductorDTO>>() {
            }.getType();
            Gson gson = new Gson();
            conductores = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (conductores == null) {
            conductores = new ArrayList<>();
        } else {
            for (ConductorDTO conductor : conductores) {
                if (conductor.dni.equals(nuevo_conductor.get_dni())) {
                    return false;
                }
            }
        }

        conductores.add(convertirConductor_Dto(nuevo_conductor));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String conductores_json = gson.toJson(conductores);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(conductores_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Conductor buscar_conductor(String dni){
        List<ConductorDTO> conductores = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ConductorDTO>>() {
            }.getType();
            Gson gson = new Gson();
            conductores = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (conductores != null) {
            for (ConductorDTO conductor : conductores) {
                if (conductor.dni.equals(dni)) {
                    return convertirDto_Conductor(conductor);
                }
            }
        }
        return null;
    }

    public static boolean actualizar_conductor(Conductor conductor_editar){
        List<ConductorDTO> conductores = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ConductorDTO>>() {
            }.getType();
            Gson gson = new Gson();
            conductores = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(conductores == null){
            return false;
        }

        boolean encontrado=false;
        for(int i=0; i<conductores.size(); i++){
            ConductorDTO conductor = conductores.get(i);
            if(conductor.dni.equals(conductor_editar.get_dni())){
                conductores.set(i, convertirConductor_Dto(conductor_editar));
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            return false;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String conductores_json = gson.toJson(conductores);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(conductores_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar_conductor(String dni){
        List<ConductorDTO> conductores = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ConductorDTO>>() {
            }.getType();
            Gson gson = new Gson();
            conductores = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(conductores == null){
            return false;
        }

        boolean encontrado = false;
        for(int i=0; i<conductores.size(); i++){
            ConductorDTO conductor = conductores.get(i);
            if(conductor.dni.equals(dni)){
                conductores.remove(i);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            return false;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String conductores_json = gson.toJson(conductores);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(conductores_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Conductor> listar_conductores(){

        List<ConductorDTO> conductoresDto = null;
        List<Conductor> conductores = new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ConductorDTO>>() {
            }.getType();
            Gson gson = new Gson();
            conductoresDto = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(conductoresDto != null){
            for(ConductorDTO conductor : conductoresDto){
                conductores.add(convertirDto_Conductor(conductor));
            }
        }

        return conductores;
    }

}
