package home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Operator_Controller {

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
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private StackPane mainPane;

    @FXML
    private Pane pnldashboard;

    @FXML
    private PieChart piechart;

    @FXML
    void Switch_to_dashboard(ActionEvent event) {
        if(event.getSource() == btndashboard){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/Operator/Dashboard.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("OPERATOR | Dashboard cannot be loaded "); } }

    }
    @FXML
    void switchToOrders(ActionEvent event) {
        if(event.getSource() == btnOrders){
            try{
                Pane Viewallorders = FXMLLoader.load(getClass().getResource("/Operator/Accept_neworders_operator.fxml"));
                mainPane.getChildren().setAll(Viewallorders);}
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("OPERATOR | Accept Orders cannot be loaded");}}

    }
    @FXML
    void Switchtorejectedorders(ActionEvent event) {
        if(event.getSource() == btnrejectedorders){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/Operator/rejected_orders_operator.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("OPERATOR | View Rejected Orders cannot be loaded");}}

    }
    @FXML
    void SwitchViewSales(ActionEvent event) {
        if(event.getSource() == btnsales){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/Operator/view_sales_operator.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("OPERATOR | View Sales cannot be loaded");}}

    }
    @FXML
    void SwitchToMyinfo(ActionEvent event) {
        if(event.getSource() == btnaddoperator){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/Operator/myinfo_Operator.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("OPERATOR | My info cannot be loaded");}}


    }
    @FXML
    void SwitchToSettings(ActionEvent event) {
        if(event.getSource() == btnSettings){
            try{
                Pane Viewallorders_admin = FXMLLoader.load(getClass().getResource("/Operator/Settings_Operator.fxml"));
                mainPane.getChildren().setAll(Viewallorders_admin);}
            catch (Exception e){
                System.out.println("OPERATOR | Settings  cannot be loaded");}}

    }
    @FXML
    void SwitchtoLogin(ActionEvent event) {
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
        }

    }





}
