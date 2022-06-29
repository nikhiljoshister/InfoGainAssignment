package com.InfoGain.InfogainAssesement.root.Customer;

public class Customer {

    private int customerId;
    private String customerName;
    private Double purchaseAmount;

    public Customer(int customerId, String customerName, double purchaseAmount){
        this.customerId = customerId;
        this.customerName = customerName;
        this.purchaseAmount = purchaseAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerPurchase() {
        return purchaseAmount;
    }

    public void setCustomerPurchase(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public String toString() {
        return "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPurchase=" + purchaseAmount +
                '}';
    }
}
