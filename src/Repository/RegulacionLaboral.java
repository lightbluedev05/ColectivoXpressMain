package Repository;

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

public class RegulacionLaboral {
    private static final String RUTA_ARCHIVO = "src/resources/regulacion_laboral.json";
    private static int limite_dias_descanso;

    public int get_limite_dias_descanso() {
        return limite_dias_descanso;
    }

    public void set_limite_dias_descanso(int limite_dias_descanso) {
        RegulacionLaboral.limite_dias_descanso = limite_dias_descanso;
    }

    public static RegulacionLaboral obtener_configuraciones(){
        List<RegulacionLaboral> regulacion_list;
        RegulacionLaboral regulacion = new RegulacionLaboral();
        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<RegulacionLaboral>>() {
            }.getType();
            Gson gson = new Gson();
            regulacion_list = gson.fromJson(reader, listType);
            regulacion = regulacion_list.get(0);
        } catch (IOException ignored) {
        }

        return regulacion;
    }

    public static boolean guardar_configuraciones(RegulacionLaboral configuraciones){
        List<RegulacionLaboral> regulacion_list = new ArrayList<>();
        regulacion_list.add(configuraciones);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String regulacion_json = gson.toJson(regulacion_list);

        try (FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(regulacion_json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
