package home.models;

import java.sql.SQLException;

public interface User {
    
    String name = "null";
    String id = "null";
    boolean login(String n, String i) throws SQLException, ClassNotFoundException;

}
