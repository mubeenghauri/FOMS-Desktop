package home.models;

//import java.sql.*;
import java.sql.*;


public class DatabaseHandler {


     ResultSet getResult(String qry) throws ClassNotFoundException, SQLException {
         System.out.println("[DatabaseHandler::getResult] [NOTE] Recieved query : "+qry);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodo","mubeen","");
         Statement st = con.createStatement();
         return st.executeQuery(qry);
    }

    public void addOrderToDb(Order o) throws SQLException, ClassNotFoundException {
        System.out.println("[DatabaseHandler::addOrderToDb] [NOTE] Recieved order : "+o.getOrderNumber());
        String qry = "insert into allOrders(ORDERID, CUSTOMERNAME, PHONE, ADDRESS, ITEMS, BILLAMMOUNT) values ( '"
                + o.getOrderNumber()      + "', '"
                + o.getCustomerName()     + "', '"
                + "0300-1231231"          + "', '"
                + o.getAddressToDeliver() + "', '"
                + o.getItems()            + "', "
                + "0"                  + "  "
                + ")";
        System.out.println("[DatabaseHandler::addOrderToDb] [NOTE]  Running query  : "+qry);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodo","mubeen","");
        Statement st = con.createStatement();
        st.executeUpdate(qry);
    }

}
