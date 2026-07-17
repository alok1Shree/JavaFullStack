package org.javafullStack.Oops.Interface;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║       E-COMMERCE PLATFORM DEMO        ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // ── USING Payable.isValidAmount() — STATIC INTERFACE METHOD ──
        System.out.println("==== AMOUNT VALIDATION ====");
        System.out.println("₹500    valid? " + Payable.isValidAmount(500));
        System.out.println("₹0      valid? " + Payable.isValidAmount(0));
        System.out.println("₹999999 valid? " + Payable.isValidAmount(999999));

        // ── PRODUCTS ──────────────────────────────────────────
        System.out.println("\n==== PRODUCTS ====");

        Product laptop = new Product("Dell Inspiron 15", 65000, "Electronics", 10);
        Product phone  = new Product("iPhone 15",       80000, "Electronics", 5);
        Product book   = new Product("Java Programming", 599,  "Books",       50);

        // Use Payable interface default methods on Product
        System.out.println("Laptop price    : ₹" + laptop.getPrice());
        System.out.println("GST (18%)       : ₹" + laptop.calculateGST(laptop.getPrice()));
        System.out.println("Total with GST  : ₹" + laptop.calculateTotal(laptop.getPrice()));

        // ── REVIEWS ───────────────────────────────────────────
        System.out.println("\n==== PRODUCT REVIEWS ====");
        laptop.addReview("Aman Kumar",  5, "Excellent build quality!");
        laptop.addReview("Riya Sharma", 4, "Good performance, slightly heavy");
        laptop.addReview("Zoya Patel",  5, "Best laptop in this price range");
        laptop.displayReviews();

        // ── ORDERS ────────────────────────────────────────────
        System.out.println("\n==== PLACING ORDERS ====");

        List<String> amanItems  = Arrays.asList("Dell Inspiron 15", "Laptop Bag");
        List<String> riyaItems  = Arrays.asList("iPhone 15", "Screen Guard", "Cover");
        List<String> kabirItems = Arrays.asList("Java Programming Book");

        Order order1 = new Order("Aman Kumar",  amanItems,  65000);
        Order order2 = new Order("Riya Sharma", riyaItems,  80000);
        Order order3 = new Order("Kabir Singh", kabirItems, 599);

        // Reserve stock
        laptop.purchase(1);
        phone.purchase(1);
        book.purchase(1);

        // ── PROCESSING PAYMENTS ───────────────────────────────
        System.out.println("\n==== PAYMENT PROCESSING ====");

        // Calculate correct total (base + GST)
        double total1 = order1.calculateTotal(order1.getAmount());
        double total2 = order2.calculateTotal(order2.getAmount());

        order1.processPayment(total1);
        order2.processPayment(total2);
        order3.processPayment(order3.calculateTotal(order3.getAmount()));

        // ── RECEIPTS ──────────────────────────────────────────
        System.out.println("\n==== RECEIPTS ====");
        order1.generateReceipt(order1.getOrderId());
        order3.generateReceipt(order3.getOrderId());

        // ── ORDER TRACKING ────────────────────────────────────
        System.out.println("\n==== ORDER TRACKING ====");

        // Using Trackable interface
        Trackable[] toTrack = {order1, order2, order3};

        order1.updateStatus("PACKED");
        order1.updateStatus("SHIPPED");
        order1.updateStatus("OUT FOR DELIVERY");
        order1.updateStatus("DELIVERED");

        System.out.println();
        order2.updateStatus("PACKED");
        order2.updateStatus("SHIPPED");

        System.out.println("\n==== TRACKING INFO ====");
        for (Trackable t : toTrack) {
            t.printTrackingInfo();   // default interface method
        }

        // ── CANCELLATIONS ─────────────────────────────────────
        System.out.println("\n==== CANCELLATIONS ====");

        // order1 is DELIVERED — cannot cancel
        System.out.println("Can cancel Order1? " + order1.isCancellable());
        order1.cancel("Changed my mind");  // should fail

        // order2 is SHIPPED — can still cancel
        System.out.println("\nCan cancel Order2? " + order2.isCancellable());
        order2.cancel("Found better deal elsewhere");  // should work + trigger refund

        // ── POLYMORPHISM VIA INTERFACES ───────────────────────
        System.out.println("\n==== INTERFACE POLYMORPHISM ====");

        // All Payable — different types
        Payable[] allPayable = {order1, order3, laptop, phone};
        System.out.println("Payable items and their GST:");
        double[] amounts = {65000, 599, 65000, 80000};

        for (int i = 0; i < allPayable.length; i++) {
            System.out.printf("  %-15s | Mode: %-20s | GST: ₹%.2f%n",
                    allPayable[i].getClass().getSimpleName(),
                    allPayable[i].getPaymentMode(),
                    allPayable[i].calculateGST(amounts[i]));
        }

        System.out.println("\n==== CANCELLATION POLICY ====");
        System.out.println(order3.getCancellationPolicy());
    }
}
