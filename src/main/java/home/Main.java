package home;

import home.models.Request;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.MalformedURLException;

public class Main extends Application {

    //Varaible Declare
    private double x, y;
    @FXML
    private TextField entry_id;

    @FXML
    private PasswordField entry_pswd;

    @FXML
    private Button btnlogin;


    //Function Declaration
    @FXML
    void Log_in(ActionEvent event) {
        String id   = entry_id.getText();
        String pswd = entry_pswd.getText();
        System.out.println(id);
        if(id.equals("admin")){
            try{
                AnchorPane root = FXMLLoader.load(getClass().getResource("/ADMIN/Home.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e){
                //System.out.println(e);
                System.out.println("ADMIN DASHBOARD | cannot be loaded ");}
        }
        else if(id.equals("o")){
            try{
                System.out.println(id);
                AnchorPane root = FXMLLoader.load(getClass().getResource("/Operator/Home.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e){
                //System.out.println(e);
                System.out.println("OPERATOR DASHBOARD | cannot be loaded ");
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginpanel.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless
            primaryStage.initStyle(StageStyle.UNDECORATED);
            //drag it here
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);

            });
            primaryStage.show();}
        catch(Exception e){
            System.out.println(e);
            System.out.println("System cannot Run");
            return;
        }


    }


    public static void main(String[] args) throws MalformedURLException {
        //Request req = new Request();
        //req.start();
        launch(args);
        return;
    }
}
