package interfaces;

import java.util.List;

public interface Convertible <T>{
    List<T> getItems(String[] itemsFile);
}
