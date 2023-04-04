package interfaces;

import java.util.List;
import java.util.Optional;

public interface Crudable <T>{
    List<T> list();
    Optional<T> search(int id);
    boolean delete(T obj);
    boolean update(T obj);
}
