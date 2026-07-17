package org.javafullStack.Oops.Interface;

public interface Payable {
    // Constant (public static final — automatically)
    double GST_RATE = 18.0;    // 18% GST

    // Abstract methods — ALL implementing classes MUST define these
    boolean processPayment(double amount);
    void    generateReceipt(String orderId);
    String  getPaymentMode();
    boolean refund(String transactionId, double amount);

    // DEFAULT METHOD (Java 8+) — optional to override
    // Provides a common implementation all classes can reuse
    default double calculateGST(double amount) {
        return amount * GST_RATE / 100;
    }

    default double calculateTotal(double amount) {
        return amount + calculateGST(amount);
    }

    // STATIC METHOD (Java 8+) — utility, called via interface name
    static boolean isValidAmount(double amount) {
        return amount > 0 && amount <= 500000;
    }
}
