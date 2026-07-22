package org.javafullStack.Exception.StudentRegistration;

public class InvalidMarksException extends RegistrationException {
    private String subjects;
    private double marks;
    public InvalidMarksException(String subjects, double marks) {
        super("Invalid marks for subject: " + subjects + " (Marks: " + marks + ")", 4003);
        this.subjects = subjects;
        this.marks = marks;
    }
    public String getSubjects() {
        return subjects;
    }
    public double getMarks() {
        return marks;
    }
}
