package Repository;

import java.util.List;

public interface CRUD<T> {
    public boolean crear(T objeto);
    public T buscar(String id);
    public boolean actualizar(T objeto);
    public boolean eliminar(String id);
    public List<T> listar();
}
