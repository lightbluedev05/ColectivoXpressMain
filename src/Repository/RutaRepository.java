package Repository;

import Models.Ruta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RutaRepository implements CRUD<Ruta>{

    private static final String RUTA_ARCHIVO = "src/resources/rutas.json";

    private static class RutaDTO{
        private String id_ruta;
        private String origen;
        private String destino;
        private String tiempo_aproximado;
        private float precio;
    }

    private static Ruta convertirDto_Ruta(RutaDTO dto){
        return new Ruta(dto.id_ruta, dto.origen, dto.destino,
                Duration.parse(dto.tiempo_aproximado), dto.precio);
    }

    private static RutaDTO convertirRuta_Dto(Ruta ruta){
        RutaDTO dto = new RutaDTO();
        dto.id_ruta = ruta.get_id_ruta();
        dto.origen = ruta.get_origen();
        dto.destino = ruta.get_destino();
        dto.tiempo_aproximado = ruta.get_tiempo_aproximado().toString();
        dto.precio = ruta.get_precio();
        return dto;
    }
    
    @Override
    public boolean crear(Ruta nueva_ruta){
        List<RutaDTO> rutas = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<Ruta>>(){}.getType();
            Gson gson = new Gson();
            rutas = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(rutas != null){
            for(RutaDTO ruta : rutas){
                if(ruta.id_ruta.equals(nueva_ruta.get_id_ruta())){
                    return false;
                }
            }
        } else {
            rutas = new ArrayList<>();
        }

        rutas.add(convertirRuta_Dto(nueva_ruta));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String clientes_json = gson.toJson(rutas);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(clientes_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Ruta buscar(String id_ruta){
        List<RutaDTO> rutas = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<RutaDTO>>(){}.getType();
            Gson gson = new Gson();
            rutas = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(rutas == null){
            return null;
        }

        for(RutaDTO ruta : rutas){
            if(ruta.id_ruta.equals(id_ruta)){
                return convertirDto_Ruta(ruta);
            }
        }

        return null;
    }

    @Override
    public boolean actualizar(Ruta ruta_editar){
        List<RutaDTO> rutas = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<RutaDTO>>(){}.getType();
            Gson gson = new Gson();
            rutas = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(rutas == null){
            return false;
        }

        for(int i=0; i<rutas.size(); i++){
            RutaDTO ruta = rutas.get(i);
            if(ruta.id_ruta.equals(ruta_editar.get_id_ruta())){
                rutas.set(i, convertirRuta_Dto(ruta_editar));
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String rutas_json = gson.toJson(rutas);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(rutas_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(String id_ruta){
        List<RutaDTO> rutasDto = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<RutaDTO>>(){}.getType();
            Gson gson = new Gson();
            rutasDto = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(rutasDto == null){
            return false;
        }

        for(int i=0; i<rutasDto.size(); i++){
            RutaDTO ruta = rutasDto.get(i);
            if(ruta.id_ruta.equals(id_ruta)){
                rutasDto.remove(i);
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String rutas_json = gson.toJson(rutasDto);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(rutas_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Ruta> listar(){
        List<RutaDTO> rutasDto = null;
        List<Ruta> rutas = new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<RutaDTO>>(){}.getType();
            Gson gson = new Gson();
            rutasDto = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(rutasDto != null){
            for(RutaDTO ruta : rutasDto){
                rutas.add(convertirDto_Ruta(ruta));
            }
        }

        return rutas;
    }
}
