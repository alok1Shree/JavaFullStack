package org.javafullStack.Oops.Payments;

public class NetBankingPayment extends Payment{
    private String bankName;
    private String accountType;

    public NetBankingPayment(String payerName, double amount,
                             String bankName, String accountType) {
        super(payerName, amount);
        this.bankName    = bankName;
        this.accountType = accountType;
    }

    @Override
    public double calculateFee() {
        // Flat ₹25 fee for net banking
        return 25.0;
    }

    @Override
    public void processPayment() {
        System.out.println("🏦 Net Banking via " + bankName
                + " [" + accountType + "]");
        System.out.println("   OTP verified ✅");
        System.out.println("   Transaction successful ✅");
    }
}
