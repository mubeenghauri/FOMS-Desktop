package home.models.lib;

import home.models.DatabaseHandler;
import home.models.Operator;
import javafx.scene.control.Button;
import java.sql.SQLException;

/**
 * RejectButton : Each row in AcceptNewOrder shall a column of RejectButton
 * each button representing a unique order, onclick shall mark the respective
 * order as "Reject" and the said order will be saved as "Rejected Order"
 *
 * @author mubeenghauri
 */

public class RejectButton extends Button {
    private String ButtonId;
    private final DatabaseHandler dbHandler = new DatabaseHandler();

    public RejectButton(String id) {
        this.ButtonId = id;

        this.setText("Reject?");
        setOnAction((event) -> {
            try {
                dbHandler.addOrderToRejected(this.ButtonId, Operator.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Rejected Order with id : "+this.ButtonId);
            this.setText("Rejected!");
        });
    }


}
