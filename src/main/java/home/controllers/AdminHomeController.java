package home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminHomeController {

    //Button Declaration
    @FXML
    private Button btndashboard;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnrejectedorders;
    @FXML
    private Button btnsales;
    @FXML
    private Button btnaddoperator;
    @FXML
    private Button btnremoveoperator;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Button btnlogin;
    //Pane Declaration
    @FXML
    private StackPane mainPane;
    @FXML
    private Pane pnldashboard;
    //Other Declaration
    @FXML
    private PieChart piechart;
    @FXML
    private VBox pnItems;
    @FXML
    private TextField entry_id;
    @FXML
    private PasswordField entry_pswd;


    @FXML
    void SwitchTodashboard(ActionEvent event) {
        if(event.getSource() == btndashboard){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/dashboard_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | Dashboard cannot be loaded "); } }
    }

    @FXML
    void switchToOrders(ActionEvent event) {
        if(event.getSource() == btnOrders){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/view_all_orders_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | View All orders cannot be loaded");}}
    }
    @FXML
    void SwitchToRejectedOrders(ActionEvent event) {
        if(event.getSource() == btnrejectedorders){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/rejected_orders_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | View Rejected Orders cannot be loaded");}}

    }
    @FXML
    void SwitchToViewSales(ActionEvent event) {
        if(event.getSource() == btnsales){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/view_sales_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | View Sales cannot be loaded");}}

    }
    @FXML
    void SwitchToaddOperator(ActionEvent event) {
        if(event.getSource() == btnaddoperator){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/Add_operator_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | AddOperator cannot be loaded");}}

    }
    @FXML
    void SwitchToRemoveOperator(ActionEvent event) {
        if(event.getSource() == btnremoveoperator){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/remove_operator_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | RemoveOperator cannot be loaded");}}

    }

    @FXML
    void SwitchToSetting(ActionEvent event) {
        if(event.getSource() == btnSettings){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/ADMIN/Settings_admin.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("ADMIN | Settings  cannot be loaded");}}

    }
    @FXML
    void SwitchToLoginPanel(ActionEvent event) {
        if(event.getSource() == btnSignout){
            try{
                AnchorPane root = FXMLLoader.load(getClass().getResource("/loginpanel.fxml"));
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();}
            catch(Exception e){
                System.out.println(e);
                System.out.println("LOGINPANEL | cannot be loaded");
            }
    }}









}
