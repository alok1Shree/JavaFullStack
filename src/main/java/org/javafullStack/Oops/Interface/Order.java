package org.javafullStack.Oops.Interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order implements Payable, Trackable, Cancellable{
    private String     orderId;
    private String     customerName;
    private List<String> items;
    private double     totalAmount;
    private String     paymentStatus;
    private String     trackingStatus;
    private String     trackingId;
    private boolean    isPaid;
    private boolean    isCancelled;
    private String     transactionId;
    private LocalDateTime orderTime;

    // Static counter for IDs
    private static int orderCounter = 1001;
    private static int trackCounter = 5001;

    public Order(String customerName, List<String> items, double totalAmount) {
        this.orderId       = "ORD" + orderCounter++;
        this.trackingId    = "TRK" + trackCounter++;
        this.customerName  = customerName;
        this.items         = new ArrayList<>(items);
        this.totalAmount   = totalAmount;
        this.paymentStatus = "PENDING";
        this.trackingStatus= "ORDER PLACED";
        this.isPaid        = false;
        this.isCancelled   = false;
        this.orderTime     = LocalDateTime.now();

        System.out.println("🛒 Order created: " + orderId
                + " for " + customerName);
    }

    // ── IMPLEMENTING Payable ─────────────────────────────────

    @Override
    public boolean processPayment(double amount) {
        if (isCancelled) {
            System.out.println("❌ Cannot pay — order is cancelled");
            return false;
        }
        if (!Payable.isValidAmount(amount)) {
            System.out.println("❌ Invalid amount: ₹" + amount);
            return false;
        }

        double expected = calculateTotal(totalAmount);
        if (Math.abs(amount - expected) > 0.01) {
            System.out.printf("❌ Amount mismatch. Expected: ₹%.2f, Got: ₹%.2f%n",
                    expected, amount);
            return false;
        }

        this.isPaid        = true;
        this.paymentStatus = "PAID";
        this.transactionId = "TXN" + System.currentTimeMillis() % 100000;
        updateStatus("PAYMENT CONFIRMED");

        System.out.println("✅ Payment of ₹" + amount + " processed for " + orderId);
        System.out.println("   Transaction ID: " + transactionId);
        return true;
    }

    @Override
    public void generateReceipt(String orderId) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║              PURCHASE RECEIPT            ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Order ID    : %-27s║%n", this.orderId);
        System.out.printf ("║  Customer    : %-27s║%n", customerName);
        System.out.printf ("║  Date        : %-27s║%n", orderTime.format(fmt));
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  ITEMS:                                  ║");
        for (String item : items) {
            System.out.printf("║    • %-37s║%n", item);
        }
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Subtotal    : ₹%-26.2f║%n", totalAmount);
        System.out.printf ("║  GST (18%%)  : ₹%-26.2f║%n", calculateGST(totalAmount));
        System.out.printf ("║  TOTAL       : ₹%-26.2f║%n", calculateTotal(totalAmount));
        System.out.printf ("║  Txn ID      : %-27s║%n", transactionId);
        System.out.printf ("║  Status      : %-27s║%n", paymentStatus);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    @Override
    public String getPaymentMode() { return "Online"; }

    @Override
    public boolean refund(String transactionId, double amount) {
        if (!isPaid) {
            System.out.println("❌ No payment to refund for " + orderId);
            return false;
        }
        System.out.println("💸 Refund of ₹" + amount
                + " initiated for Txn: " + transactionId);
        System.out.println("   Refund will reflect in 5-7 business days.");
        paymentStatus = "REFUNDED";
        return true;
    }

    // ── IMPLEMENTING Trackable ───────────────────────────────

    @Override
    public void updateStatus(String status) {
        this.trackingStatus = status;
        System.out.println("📦 [" + orderId + "] Status → " + status);
        notifyCustomer("Your order " + orderId + " is now: " + status);
    }

    @Override
    public String getCurrentStatus() { return trackingStatus; }

    @Override
    public String getTrackingId() { return trackingId; }

    @Override
    public void notifyCustomer(String message) {
        System.out.println("   📱 SMS to " + customerName + ": " + message);
    }

    // ── IMPLEMENTING Cancellable ─────────────────────────────

    @Override
    public boolean cancel(String reason) {
        if (!isCancellable()) {
            System.out.println("❌ Order " + orderId + " cannot be cancelled");
            return false;
        }
        isCancelled   = true;
        paymentStatus = "CANCELLED";
        updateStatus("CANCELLED: " + reason);

        if (isPaid) {
            refund(transactionId, calculateTotal(totalAmount));
        }
        return true;
    }

    @Override
    public boolean isCancellable() {
        return !isCancelled
                && !trackingStatus.equals("OUT FOR DELIVERY")
                && !trackingStatus.equals("DELIVERED");
    }

    @Override
    public String getCancellationPolicy() {
        return "Orders can be cancelled before 'Out for Delivery'. "
                + "Refund in 5-7 business days.";
    }

    // ── UTILITY ──────────────────────────────────────────────
    public String getOrderId()     { return orderId; }
    public String getCustomer()    { return customerName; }
    public double getAmount()      { return totalAmount; }
    public boolean isPaid()        { return isPaid; }
    public boolean isCancelled()   { return isCancelled; }
}
