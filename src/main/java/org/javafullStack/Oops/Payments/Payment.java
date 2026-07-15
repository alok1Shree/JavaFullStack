package org.javafullStack.Oops.Payments;

public class Payment {

    private String payerName;
    private double amount;

    public Payment(String payerName, double amount) {
        if (payerName == null || payerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Payer name cannot be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.payerName = payerName;
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public void processPayment(){
        System.out.println("Processing "+amount+" Payment for "+payerName);
    }

    public double calculateFee(){
        return 0;
    }

    public void executeTransaction(){
        System.out.println("-------------------------------------");
        System.out.println("Payer Name: "+payerName);
        System.out.println("Amount: "+amount);
        System.out.println("Fee: "+calculateFee());
        System.out.println("Total Amount: "+(amount + calculateFee()));
        System.out.println("Method: "+ getClass().getSimpleName());
        processPayment();
        System.out.println("-------------------------------------");

    }
}
