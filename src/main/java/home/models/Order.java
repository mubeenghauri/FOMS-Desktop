package home.models;

import home.models.lib.ApproveButton;

public class Order {

    private String orderNumber;
    private String customerName;
    private String addressToDeliver;
    private String items;
    private String status = "N/A";
    private ApproveButton approveButton;

    public void setApproveButton() {
        this.approveButton = new ApproveButton(this.orderNumber);
    }

    public void setOrderNumber(String on) {
        this.orderNumber = on;
        this.setApproveButton();
    }

    public void setCustomerName(String cn) {
        this.customerName = cn;
    }

    public void setAddressToDeliver(String a) { this.addressToDeliver = a;}

    public void setItems(String i ) {
        this.items = i;
    }

//    public void setStatus(String s) {
//        this.status = s;
//    }
//
    public String getStatus() {
        return this.status;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getAddressToDeliver() {
        return this.addressToDeliver;
    }

    public String getItems() {
        return this.items;
    }

    public ApproveButton getApproveButton() {
        return this.approveButton;
    }
}
