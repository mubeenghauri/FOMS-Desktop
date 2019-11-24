package home.models.lib;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import home.models.DatabaseHandler;
import home.models.Operator;
import javafx.scene.control.Button;

import java.sql.SQLException;

/**
 * ApproveButton : Each row in AcceptNewOrder shall a column of ApproveButton
 * each button representing a unique order, onclick shall mark the respective
 * order as "Approved" and the said order will be saved as "Accepted Order"
 *
 * @author mubeenghauri
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproveButton extends Button {
    private String ButtonId;
    private DatabaseHandler dbHandler;

    public ApproveButton(String id) {
        this.ButtonId = id;
        this.dbHandler = new DatabaseHandler();
        this.setText("Approve?");
        setOnAction((event) -> {
            System.out.println("Approved Order operator id"+ Operator.getId() + " with id : "+this.ButtonId);
            try {
                dbHandler.addOrderToAccepted(this.ButtonId, Operator.getId());

            } catch (Exception e) {
               System.out.println("[ApproveButton] [ERROR] DatabaseHandler failed to add order to accepted table");
            }
            this.setText("Approved!");
        });
    }


}
