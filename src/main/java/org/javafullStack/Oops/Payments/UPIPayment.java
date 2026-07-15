package org.javafullStack.Oops.Payments;

public class UPIPayment extends Payment{
    private String upiId;
    private String upiApp;    // PhonePe, GPay, Paytm

    public UPIPayment(String payerName, double amount,
                      String upiId, String upiApp) {
        super(payerName, amount);
        this.upiId  = upiId;
        this.upiApp = upiApp;
    }

    // UPI has NO fee — calculateFee() returns 0 (parent default)
    // No need to override calculateFee()

    @Override
    public void processPayment() {
        System.out.println("📱 UPI Payment via " + upiApp
                + " to " + upiId);
        System.out.println("   UPI PIN verified ✅");
        System.out.println("   Amount debited instantly ✅");
    }
}
