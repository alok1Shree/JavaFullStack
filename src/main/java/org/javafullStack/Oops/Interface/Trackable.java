package org.javafullStack.Oops.Interface;

public interface Trackable {
    void updateStatus(String status);
    String getCurrentStatus();
    String getTrackingId();
    void notifyCustomer(String message);

    default void printTrackingInfo() {
        System.out.println("📦 Tracking ID : " + getTrackingId());
        System.out.println("   Status      : " + getCurrentStatus());
    }
}
