package org.javafullStack.Exception.StudentRegistration;

public class CourseFullException extends RegistrationException{
    private String courseNmae;
    private int maxCapacity;
    public CourseFullException(String course, int max) {
        super("Course is full: " + course + " (MaX Capacity: " + max + ")", 4002);
        this.courseNmae = course;
        this.maxCapacity = maxCapacity;
    }
    public String getCourseName() {
        return courseNmae;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
}
