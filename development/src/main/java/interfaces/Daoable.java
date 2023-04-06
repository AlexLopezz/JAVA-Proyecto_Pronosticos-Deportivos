package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Daoable<T> {
    List<T> list() throws SQLException;
}
