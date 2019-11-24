package home.controllers;

import home.models.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private @FXML TextField entry_id;

    private @FXML PasswordField entry_pswd;

    private @FXML Button btnlogin;

    private Admin admin;



     @FXML void Log_in() throws SQLException, ClassNotFoundException {

        String name = entry_id.getText();
        String pass = entry_pswd.getText();

        if(name.equals("") || pass.equals("")) {
            System.out.println("Invalid credentials");
            return;
        }

        if(name.equals("admin")) {
            try{
                AnchorPane root = FXMLLoader.load(getClass().getResource("/ADMIN/Home.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                //((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e){
                //System.out.println(e);
                System.out.println("ADMIN DASHBOARD | cannot be loaded ");}
        }
        else {
            // Case when operator is logging in
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.admin = new Admin();
    }
}
