package Repository;

import Models.Boleto;
import Models.Conductor;
import Models.Pasajero;
import Models.Viaje;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BoletoRepository {

    private static final String RUTA_ARCHIVO = "src/resources/boletos.json";

    private static class BoletoDTO {
        private String id_boleto;
        private String dni_pasajero;
        private String id_viaje;
        private float precio;
    }

    private static Boleto convertirDto_Boleto(BoletoDTO boletoDTO) {
        Pasajero pasajero = PasajeroRepository.buscar_pasajero(boletoDTO.dni_pasajero);
        Viaje viaje = ViajeRepository.buscar_viaje(boletoDTO.id_viaje);
        return new Boleto(boletoDTO.id_boleto, pasajero, viaje, boletoDTO.precio);
    }

    private static BoletoDTO convertirBoleto_Dto(Boleto boleto) {
        BoletoDTO boletoDto = new BoletoDTO();
        boletoDto.id_boleto = boleto.get_id_boleto();
        boletoDto.dni_pasajero = boleto.get_pasajero().get_dni();
        boletoDto.id_viaje = boleto.get_viaje().get_id_viaje();
        boletoDto.precio = boleto.get_precio();
        return boletoDto;
    }

    public static boolean crear_boleto(Boleto nuevo_boleto) {
        List<BoletoDTO> boletos = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<BoletoDTO>>(){}.getType();
            Gson gson = new Gson();
            boletos = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (boletos != null) {
            for (BoletoDTO boleto : boletos) {
                if (boleto.id_boleto.equals(nuevo_boleto.get_id_boleto())) {
                    return false;
                }
            }
        } else {
            boletos = new ArrayList<>();
        }

        boletos.add(convertirBoleto_Dto(nuevo_boleto));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String boletos_json = gson.toJson(boletos);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(boletos_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boleto buscar_boleto(String id_boleto) {
        List<BoletoDTO> boletos = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<BoletoDTO>>(){}.getType();
            Gson gson = new Gson();
            boletos = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (boletos == null) {
            return null;
        }

        for (BoletoDTO boleto : boletos) {
            if (boleto.id_boleto.equals(id_boleto)) {
                return convertirDto_Boleto(boleto);
            }
        }

        return null;
    }

    public static boolean actualizar_boleto(Boleto boleto_editar) {
        List<BoletoDTO> boletos = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<BoletoDTO>>(){}.getType();
            Gson gson = new Gson();
            boletos = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (boletos == null) {
            return false;
        }

        for (int i = 0; i < boletos.size(); i++) {
            BoletoDTO boleto = boletos.get(i);
            if (boleto.id_boleto.equals(boleto_editar.get_id_boleto())) {
                boletos.set(i, convertirBoleto_Dto(boleto_editar));
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String boletos_json = gson.toJson(boletos);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(boletos_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar_boleto(String id_boleto) {
        List<BoletoDTO> boletos = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<BoletoDTO>>(){}.getType();
            Gson gson = new Gson();
            boletos = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (boletos == null) {
            return false;
        }

        for(int i=0; i<boletos.size(); i++){
            BoletoDTO boleto = boletos.get(i);
            if(boleto.id_boleto.equals(id_boleto)){
                boletos.remove(i);
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String boletos_json = gson.toJson(boletos);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(boletos_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Boleto> listar_boletos() {
        List<BoletoDTO> boletosDto = null;
        List<Boleto> boletos = new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<BoletoDTO>>(){}.getType();
            Gson gson = new Gson();
            boletosDto = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if (boletosDto != null) {
            for (BoletoDTO boleto : boletosDto) {
                boletos.add(convertirDto_Boleto(boleto));
            }
        }

        return boletos;
    }
}

