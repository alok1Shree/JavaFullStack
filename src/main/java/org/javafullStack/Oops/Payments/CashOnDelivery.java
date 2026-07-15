package org.javafullStack.Oops.Payments;

public class CashOnDelivery extends Payment{
    private String deliveryAddress;
    private int    estimatedDays;

    public CashOnDelivery(String payerName, double amount,
                          String deliveryAddress, int estimatedDays) {
        super(payerName, amount);
        this.deliveryAddress = deliveryAddress;
        this.estimatedDays   = estimatedDays;
    }

    @Override
    public double calculateFee() {
        return 40.0;    // Flat ₹40 COD handling charge
    }

    @Override
    public void processPayment() {
        System.out.println("📦 Cash on Delivery scheduled");
        System.out.println("   Address   : " + deliveryAddress);
        System.out.println("   Delivery  : " + estimatedDays + " days ✅");
        System.out.println("   Pay ₹" + (getAmount() + calculateFee())
                + " on delivery");
    }
}
