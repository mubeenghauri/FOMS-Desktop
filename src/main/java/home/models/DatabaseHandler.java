package home.models;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
                + "0"                     + "  "
                + ")";
        System.out.println("[DatabaseHandler::addOrderToDb] [NOTE]  Running query  : "+qry);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodo","mubeen","");
        Statement st = con.createStatement();
        if(st.executeUpdate(qry) > 0) {
            System.out.println("[DatabaseHandler::addOrderToDb] [SUCCESS] Inserted Order Successfully!");
            return;
        }
        System.out.println("[DatabaseHandler::addOrderToDb] [ERROR] Failed inserting order !!");
        return;
    }

    public void runQuery(String qry) throws ClassNotFoundException, SQLException {
        System.out.println("[DatabaseHandler::getResult] [NOTE] Recieved query : "+qry);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodo","mubeen","");
        Statement st = con.createStatement();
        if(st.executeUpdate(qry) > 0) {
            System.out.println("[DatabaseHandler::runQuery] [SUCCESS] Query Run Successfully!");
            return;
        }
        System.out.println("[DatabaseHandler::runQuery] [ERROR] Failed runnin query !!");
        return;
    }

    public void addOrderToAccepted(String orderid, String operatorid) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String qry = "insert into approvedOrders(ORDERID, OPERATORID, ACCEPTDATE) VALUES ( '"+orderid+"', '"+
                operatorid+"', '"+
                dtf.format(now) +"')";
        System.out.println("[DatabaseHandler::addOrderToDb] [NOTE] Running query : "+qry);
        this.runQuery(qry);

    }

    public void addOrderToRejected(String orderid, String operatorid) throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String qry = "insert into rejectedOrders(ORDERID, OPERATORID, ACCEPTDATE) VALUES ( '"+orderid+"', '"+
                operatorid+"', '"+
                dtf.format(now) +"')";
        System.out.println("[DatabaseHandler::addOrderToDb] [NOTE] Running query : "+qry);
        this.runQuery(qry);
    }
}