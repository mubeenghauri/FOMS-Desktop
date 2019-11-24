package home.models;

//import java.sql.*;
import java.sql.*;


public class DatabaseHandler {


     ResultSet getResult(String qry) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodo","mubeen","");
         Statement st = con.createStatement();
         return st.executeQuery(qry);
    }

}
