package home.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin implements User {

    private String name;
    private String id;
    private DatabaseHandler dbHandler;


    public Admin() {
        dbHandler = new DatabaseHandler();
    }

    @Override
    public boolean login(String name, String pass) throws SQLException, ClassNotFoundException {
        ResultSet rs = dbHandler.getResult("select * from admin");

        while(rs.next()) {
            System.out.println("[AdminModel::login] [NOTE] Going through admin : "+rs.getString(2));
            if(rs.getString(2) == name) {
                if(rs.getString(3) == pass) {
                    this.setId(rs.getString(1));
                    this.setName(rs.getString(2));
                    return true;
                }
            }
        }
        return false;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setId(String id) {
        this.id = id;
    }

}
