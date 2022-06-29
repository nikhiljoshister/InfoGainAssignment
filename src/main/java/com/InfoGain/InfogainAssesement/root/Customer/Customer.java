package com.InfoGain.InfogainAssesement.root.Customer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Customer {

    private int customerId;
    private String customerName;
    private Double purchaseAmount;

    public Customer(int customerId, String customerName, double purchaseAmount){
        this.customerId = customerId;
        this.customerName = customerName;
        this.purchaseAmount = roundDouble(purchaseAmount,2);
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
        this.purchaseAmount = roundDouble(purchaseAmount,2);
    }

    private static double roundDouble(double dm ,int places){
        BigDecimal bigDecimal = new BigDecimal(Double.toString(dm));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    @Override
    public String toString() {
        return "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPurchase=" + purchaseAmount +
                '}';
    }
}
