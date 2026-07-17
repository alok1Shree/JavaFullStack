package org.javafullStack.Oops.Interface;

public interface Reviewable {
    void addReview(String customerName, int rating, String comment);
    double getAverageRating();
    void displayReviews();
}
