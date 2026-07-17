package org.javafullStack.Oops.Interface;

import java.util.ArrayList;
import java.util.List;

public class Product implements Reviewable, Payable{
    private String  name;
    private double  price;
    private String  category;
    private int     stockCount;

    // Review data
    private List<int[]> ratings      = new ArrayList<>();
    private List<String> reviewTexts = new ArrayList<>();

    public Product(String name, double price, String category, int stock) {
        this.name      = name;
        this.price     = price;
        this.category  = category;
        this.stockCount= stock;
    }

    public String getName()  { return name; }
    public double getPrice() { return price; }
    public int    getStock() { return stockCount; }

    public boolean isAvailable() { return stockCount > 0; }

    public boolean purchase(int quantity) {
        if (quantity > stockCount) {
            System.out.println("❌ Insufficient stock for " + name);
            return false;
        }
        stockCount -= quantity;
        System.out.println("✅ " + quantity + " unit(s) of '"
                + name + "' reserved");
        return true;
    }

    // ── IMPLEMENTING Reviewable ──────────────────────────────

    @Override
    public void addReview(String customerName, int rating, String comment) {
        if (rating < 1 || rating > 5) {
            System.out.println("❌ Rating must be between 1 and 5");
            return;
        }
        ratings.add(new int[]{rating});
        reviewTexts.add(customerName + ": [" + rating + "⭐] " + comment);
        System.out.println("✅ Review added by " + customerName);
    }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        int total = 0;
        for (int[] r : ratings) total += r[0];
        return (double) total / ratings.size();
    }

    @Override
    public void displayReviews() {
        System.out.println("⭐ Reviews for: " + name);
        System.out.printf ("   Average Rating: %.1f/5.0 (%d reviews)%n",
                getAverageRating(), ratings.size());
        System.out.println("   ─────────────────────────────────");
        if (reviewTexts.isEmpty()) {
            System.out.println("   No reviews yet.");
        } else {
            for (String review : reviewTexts) {
                System.out.println("   " + review);
            }
        }
    }

    // ── IMPLEMENTING Payable ─────────────────────────────────

    @Override
    public boolean processPayment(double amount) {
        double expected = calculateTotal(price);
        if (Math.abs(amount - expected) > 0.01) {
            System.out.println("❌ Payment failed: incorrect amount");
            return false;
        }
        System.out.println("✅ Product payment of ₹" + amount
                + " processed for: " + name);
        return true;
    }

    @Override
    public void generateReceipt(String orderId) {
        System.out.println("🧾 Receipt: " + name
                + " | ₹" + calculateTotal(price)
                + " | Order: " + orderId);
    }

    @Override
    public String getPaymentMode() { return "Product Payment"; }

    @Override
    public boolean refund(String transactionId, double amount) {
        System.out.println("💸 Product refund ₹" + amount
                + " for Txn: " + transactionId);
        stockCount++;   // return stock
        return true;
    }
}
