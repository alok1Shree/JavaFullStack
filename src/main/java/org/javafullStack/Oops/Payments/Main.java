package org.javafullStack.Oops.Payments;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║     PAYMENT PROCESSING SYSTEM     ║");
        System.out.println("╚═══════════════════════════════════╝\n");

        // ── INDIVIDUAL PAYMENTS ──────────────────────────────
        System.out.println("==== INDIVIDUAL TRANSACTIONS ====\n");

        Payment p1 = new CreditCardPayment("Aman Kumar", 5000,
                "4111111111111234", "HDFC");
        Payment p2 = new UPIPayment("Riya Sharma", 1200,
                "riya@ybl", "PhonePe");
        Payment p3 = new NetBankingPayment("Zoya Patel", 15000,
                "SBI", "Savings");
        Payment p4 = new CashOnDelivery("Kabir Singh", 2500,
                "123, MG Road, Bengaluru", 3);

        // ── RUNTIME POLYMORPHISM ─────────────────────────────
        // All declared as 'Payment' (parent type)
        // But each calls ITS OWN processPayment() and calculateFee()
        // Java decides which version at RUNTIME based on actual object

        p1.executeTransaction();   // runs CreditCardPayment's methods
        p2.executeTransaction();   // runs UPIPayment's methods
        p3.executeTransaction();   // runs NetBankingPayment's methods
        p4.executeTransaction();   // runs CashOnDelivery's methods

        // ── POLYMORPHISM WITH A LIST ─────────────────────────
        System.out.println("==== BATCH PROCESSING ====\n");

        List<Payment> transactions = new ArrayList<>();
        transactions.add(new CreditCardPayment("Alice",   3000, "4111000011112222", "ICICI"));
        transactions.add(new UPIPayment       ("Bob",     800,  "bob@paytm",         "Paytm"));
        transactions.add(new NetBankingPayment("Charlie", 12000,"Axis",              "Current"));
        transactions.add(new UPIPayment       ("Diana",   500,  "diana@gpay",        "GPay"));
        transactions.add(new CreditCardPayment("Eve",     7500, "5500000000001234",  "Kotak"));
        transactions.add(new CashOnDelivery   ("Frank",   1800, "45 Park Street",    5));

        double totalRevenue   = 0;
        double totalFees      = 0;
        int    upiCount       = 0;
        int    cardCount      = 0;

        for (Payment txn : transactions) {
            double fee = txn.calculateFee();
            totalRevenue += txn.getAmount();
            totalFees    += fee;

            // instanceof to check actual type
            if (txn instanceof UPIPayment)        upiCount++;
            if (txn instanceof CreditCardPayment) cardCount++;

            System.out.printf("%-12s | %-20s | ₹%8.2f | Fee: ₹%.2f%n",
                    txn.getClass().getSimpleName(),
                    txn.getPayerName(),
                    txn.getAmount(),
                    fee);
        }

        System.out.println("─────────────────────────────────────────────────");
        System.out.printf("Total Transactions : %d%n", transactions.size());
        System.out.printf("Total Revenue      : ₹%.2f%n", totalRevenue);
        System.out.printf("Total Fees Earned  : ₹%.2f%n", totalFees);
        System.out.printf("UPI Payments       : %d%n", upiCount);
        System.out.printf("Card Payments      : %d%n", cardCount);
    }
}
