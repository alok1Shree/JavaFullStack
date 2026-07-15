package org.javafullStack.Oops.Payments;

public class CreditCardPayment extends Payment {

    private String cardNumber;
    private String bankName;
    private double feePercent;

    public CreditCardPayment(String payerName, double amount, String cardNumber, String bankName) {
        super(payerName, amount);
        this.cardNumber = maskCard(cardNumber);
        this.bankName = bankName;
        this.feePercent = 2.0;
    }

    private String maskCard(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    @Override
    public double calculateFee(){
        return getAmount() * feePercent/100;
    }

    @Override
    public  void processPayment(){
        System.out.println("\uD83D\uDCB3 Credit Card charged: "+cardNumber+" [" + bankName +"]");
        System.out.println("Status: APPROVED ✅");
    }

}
