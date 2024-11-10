package Repository;
import Models.Conductor;
import Models.Ruta;
import Models.Viaje;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViajeRepository implements CRUD<Viaje>{

    private static final String RUTA_ARCHIVO = "src/resources/viajes.json";

    private static class ViajeDTO {
        private String id_viaje;
        private String fecha_salida; // Almacenaremos la fecha como String
        private String id_ruta; // Almacenaremos el id de la ruta
        private String dni_conductor; // Almacenaremos el DNI del conductor
    }

    private static Viaje convertirDto_Viaje(ViajeDTO dto) {
        Ruta ruta = new RutaRepository().buscar(dto.id_ruta); // Buscar ruta por id_ruta
        Conductor conductor = new ConductorRepository().buscar(dto.dni_conductor); // Buscar conductor por DNI
        return new Viaje(dto.id_viaje, LocalDate.parse(dto.fecha_salida), ruta, conductor);
    }

    private static ViajeDTO convertirViaje_Dto(Viaje viaje) {
        ViajeDTO dto = new ViajeDTO();
        dto.id_viaje = viaje.get_id_viaje();
        dto.fecha_salida = viaje.get_fecha_salida().toString();
        dto.id_ruta = viaje.get_ruta().get_id_ruta(); // Suponiendo que Ruta tiene un método get_id_ruta()
        dto.dni_conductor = viaje.get_conductor().get_dni(); // Suponiendo que el Conductor tiene un método get_dni()
        return dto;
    }

    @Override
    public boolean crear(Viaje nuevo_viaje) {
        List<ViajeDTO> viajes = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ViajeDTO>>(){}.getType();
            Gson gson = new Gson();
            viajes = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (viajes != null) {
            for (ViajeDTO viaje : viajes) {
                if (viaje.id_viaje.equals(nuevo_viaje.get_id_viaje())) {
                    return false;
                }
            }
        } else {
            viajes = new ArrayList<>();
        }

        viajes.add(convertirViaje_Dto(nuevo_viaje));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String viajes_json = gson.toJson(viajes);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(viajes_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Viaje buscar(String id_viaje) {
        List<ViajeDTO> viajes = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ViajeDTO>>(){}.getType();
            Gson gson = new Gson();
            viajes = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (viajes == null) {
            return null;
        }

        for (ViajeDTO viaje : viajes) {
            if (viaje.id_viaje.equals(id_viaje)) {
                return convertirDto_Viaje(viaje);
            }
        }

        return null;
    }

    @Override
    public boolean actualizar(Viaje viaje_editar) {
        List<ViajeDTO> viajes = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ViajeDTO>>(){}.getType();
            Gson gson = new Gson();
            viajes = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (viajes == null) {
            return false;
        }

        for (int i = 0; i < viajes.size(); i++) {
            ViajeDTO viaje = viajes.get(i);
            if (viaje.id_viaje.equals(viaje_editar.get_id_viaje())) {
                viajes.set(i, convertirViaje_Dto(viaje_editar));
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String viajes_json = gson.toJson(viajes);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(viajes_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(String id_viaje){
        List<ViajeDTO> viajes = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ViajeDTO>>(){}.getType();
            Gson gson = new Gson();
            viajes = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(viajes == null){
            return false;
        }

        for(int i=0; i<viajes.size(); i++){
            ViajeDTO viaje = viajes.get(i);
            if(viaje.id_viaje.equals(id_viaje)){
                viajes.remove(i);
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String viajes_json = gson.toJson(viajes);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(viajes_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Viaje> listar() {
        List<ViajeDTO> viajesDto = null;
        List<Viaje> viajes = new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<ViajeDTO>>(){}.getType();
            Gson gson = new Gson();
            viajesDto = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (viajesDto != null) {
            for (ViajeDTO viaje : viajesDto) {
                viajes.add(convertirDto_Viaje(viaje));
            }
        }

        return viajes;
    }
}
