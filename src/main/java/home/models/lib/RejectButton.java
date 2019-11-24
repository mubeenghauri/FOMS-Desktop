package home.models.lib;

import javafx.scene.control.Button;

/**
 * RejectButton : Each row in AcceptNewOrder shall a column of RejectButton
 * each button representing a unique order, onclick shall mark the respective
 * order as "Reject" and the said order will be saved as "Rejected Order"
 *
 * @author mubeenghauri
 */

public class RejectButton extends Button {
    private String ButtonId;

    public RejectButton(String id) {
        this.ButtonId = id;

        this.setText("Reject?");
        setOnAction((event) -> {
            System.out.println("Rejected Order with id : "+this.ButtonId);
            this.setText("Rejected!");
        });
    }


}
