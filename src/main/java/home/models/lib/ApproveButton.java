package home.models.lib;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.scene.control.Button;

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

    public ApproveButton(String id) {
        this.ButtonId = id;

        this.setText("Approve?");
        setOnAction((event) -> {
            System.out.println("Approved Order with id : "+this.ButtonId);
            this.setText("Approved!");
        });
    }
}
