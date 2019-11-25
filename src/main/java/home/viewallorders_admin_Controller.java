package home;

import home.models.DatabaseHandler;
import home.models.Order;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javafx.scene.control.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class viewallorders_admin_Controller implements Initializable {

    @FXML private Pane pnallorders;
    @FXML private TableView viewOrderTable;
    @FXML private TableColumn orderId;
    @FXML private TableColumn custName;
    @FXML private TableColumn phone;
    @FXML private TableColumn address;
    @FXML private TableColumn items;
    private final DatabaseHandler dbHandler = new DatabaseHandler();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderId.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
        custName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        address.setCellValueFactory(new PropertyValueFactory<>("addressToDeliver"));
        items.setCellValueFactory(new PropertyValueFactory<>("items"));
        phone.setCellValueFactory(new PropertyValueFactory<>("status"));

        getOrder();

    }

    private void getOrder() {
        System.out.println("[ViewallOrders_AdminController::getOrder] [NOTE] Getting orders from dbHandler ");

        try {
            ResultSet re = this.dbHandler.getAllOrders();
            while(re.next()){
                Order o = new Order();
                o.setOrderNumber(re.getString(1));
                o.setCustomerName(re.getString(2));
                o.setAddressToDeliver(re.getString(4));
                o.setItems(re.getString(5));
                viewOrderTable.getItems().add(o);

            }

        } catch (Exception e) {
            System.out.println("[ViewallOrders_AdminController::getOrder] [ERROR] Failed getting orders from dbHandler ");
            System.out.println(e.getMessage());
        }



    }
}
