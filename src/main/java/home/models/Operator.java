package home.models;

import home.models.DatabaseHandler;
import javafx.scene.control.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Operator implements  User{

    private String name;
    private String id;
    private DatabaseHandler dbHandler;


    public Operator() {
        dbHandler = new DatabaseHandler();
    }
    @Override
    public boolean login(String name, String pass) throws SQLException, ClassNotFoundException {
        System.out.println("[Operator::login] [NOTE] Running query");
        ResultSet rs = dbHandler.getResult("select * from operator");
        System.out.println("[Operator::login] [NOTE] Getting to while ...");

        while(rs.next()) {
            System.out.println("[Operator::login] [NOTE] Going through operator : "+rs.getString(2)+" recieved "+name);
            if(rs.getString(2).equals(name)) {
                System.out.println("[Operator::login] password should be "+rs.getString(3)+" and is "+pass);
                if(rs.getString(3).equals(pass)) {
                    this.setId(rs.getString(1));
                    this.setName(rs.getString(2));
                    System.out.println("[Operator::login] [SUCCESS] Found User");

                    return true;
                }
            }
        }
        System.out.println("[Operator::login] [ERROR] While not executed");

        return false;
    }


    public void setName(String n) {
        this.name = n;
    }

    public void setId(String id) {
        this.id = id;
    }

}
