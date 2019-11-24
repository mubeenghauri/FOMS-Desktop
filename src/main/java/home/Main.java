package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.MalformedURLException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginpanel.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless
            primaryStage.initStyle(StageStyle.UNDECORATED);
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
