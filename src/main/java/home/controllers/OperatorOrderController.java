package home.controllers;

import home.models.Request;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import home.models.Order;


/**
 * Controller for Accept_neworders_operator view
 */

public class OperatorOrderController implements Initializable {


    @FXML TableView mainGrid;
    @FXML TableColumn orderID;
    @FXML TableColumn custName;
    @FXML TableColumn address;
    @FXML TableColumn items;
    @FXML TableColumn status;
    @FXML TableColumn acceptCol;
    @FXML TableColumn rejectCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("[OOC] Initializing....");
        Request req = null;
        req = new Request(this);
        req.start();


        orderID.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
        custName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        address.setCellValueFactory(new PropertyValueFactory<>("addressToDeliver"));
        items.setCellValueFactory(new PropertyValueFactory<>("items"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        acceptCol.setCellValueFactory(new PropertyValueFactory<>("approveButton"));
        rejectCol.setCellValueFactory(new PropertyValueFactory<>("rejectButton"));

    }

    public void testTable() {
        System.out.println("[NOTE] Testing Table");
        Order test = new Order();
        test.setAddressToDeliver("H#123 Street-23 D-4, Hayattabad, PSH");
        test.setCustomerName("John Doe");
        test.setItems("1 Burger, 2 Fries, 4 Coke 500ml");
        test.setOrderNumber("O-32");

        mainGrid.getItems().add(test);

    }

    public boolean addOrderToTable(Order order) {
        System.out.println("[OOC::addOrder] [NOTE] : Recieved Order with id : "+order.getOrderNumber());
        try {
            mainGrid.getItems().add(order);
        } catch (Exception e) {
            System.out.println("[OOC::addOrder] [ERROR] : Failed Adding Order => "+e.getMessage());
            testTable();
            return false;
        }
        System.out.println("[OOC::addOrder] [SUCCESS] : Added Order to Table  ");
        return true;
    }



}
