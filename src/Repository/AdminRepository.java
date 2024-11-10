package Repository;

import Models.Admin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository {

    private static final String RUTA_ARCHIVO = "src/resources/admins.json";

    private static class AdminDTO {
        private String codigo;
        private String contrasena;
    }

    private static Admin convertirDto_Admin(AdminDTO adminDTO) {
        return new Admin(adminDTO.codigo, adminDTO.contrasena);
    }

    private static AdminDTO convertirAdmin_Dto(Admin admin) {
        AdminDTO adminDto = new AdminDTO();
        adminDto.codigo = admin.get_codigo();
        adminDto.contrasena = admin.get_contrasena();
        return adminDto;
    }

    public static boolean crear_admin(Admin nuevo_admin){
        List<AdminDTO> admins = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<AdminDTO>>(){}.getType();
            Gson gson = new Gson();
            admins = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(admins == null){
            admins = new ArrayList<>();
        } else {
            for(AdminDTO admin : admins){
                if(admin.codigo.equals(nuevo_admin.get_codigo())){
                    return false;
                }
            }
        }

        admins.add(convertirAdmin_Dto(nuevo_admin));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String admins_json = gson.toJson(admins);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(admins_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Admin buscar_admin(String codigo){
        List<AdminDTO> admins = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<AdminDTO>>(){}.getType();
            Gson gson = new Gson();
            admins = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(admins == null){
            return null;
        } else {
            for (AdminDTO admin : admins) {
                if (admin.codigo.equals(codigo)) {
                    return convertirDto_Admin(admin);
                }
            }
        }
        return null;
    }

    public static boolean actualizar_admin(Admin admin_editar){
        List<AdminDTO> admins = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<AdminDTO>>(){}.getType();
            Gson gson = new Gson();
            admins = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        boolean encontrado = false;
        if(admins == null){
            return false;
        } else {
            for (int i=0; i<admins.size(); i++){
                AdminDTO admin = admins.get(i);
                if (admin.codigo.equals(admin_editar.get_codigo())) {
                    admins.set(i, convertirAdmin_Dto(admin_editar));
                    encontrado = true;
                    break;
                }
            }
        }

        if(!encontrado){
            return false;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String admins_json = gson.toJson(admins);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(admins_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar_admin(String codigo){
        List<AdminDTO> admins = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<AdminDTO>>(){}.getType();
            Gson gson = new Gson();
            admins = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        boolean encontrado = false;
        if(admins==null){
            return false;
        } else {
            for(int i=0; i<admins.size(); i++){
                AdminDTO admin = admins.get(i);
                if(admin.codigo.equals(codigo)){
                    admins.remove(i);
                    encontrado = true;
                    break;
                }
            }
        }

        if(!encontrado){
            return false;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String admins_json = gson.toJson(admins);

        try(FileWriter file = new FileWriter(RUTA_ARCHIVO)) {
            file.write(admins_json);
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Admin> listar_admins(){
        List<Admin> admins = new ArrayList<>();
        List<AdminDTO> adminsDTO = null;

        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type listType = new TypeToken<ArrayList<AdminDTO>>(){}.getType();
            Gson gson = new Gson();
            adminsDTO = gson.fromJson(reader, listType);
        } catch (IOException ignored) {
        }

        if(adminsDTO != null){
            for(AdminDTO admin : adminsDTO){
                admins.add(convertirDto_Admin(admin));
            }
        }

        return admins;
    }


    public static HashMap<String, Object> obtener_configuraciones(){
        Gson gson = new Gson();
        Type tipoMapa = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> configuraciones;

        try (FileReader reader = new FileReader("src/resources/configuraciones.json")) {
            configuraciones = gson.fromJson(reader, tipoMapa);

            return configuraciones;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean guardar_configuraciones(HashMap<String, Object> configuraciones){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(configuraciones);

        try (FileWriter writer = new FileWriter("src/resources/configuraciones.json")) {
            writer.write(jsonString);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
