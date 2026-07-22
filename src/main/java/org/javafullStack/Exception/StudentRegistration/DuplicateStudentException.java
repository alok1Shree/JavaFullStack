package org.javafullStack.Exception.StudentRegistration;

public class DuplicateStudentException extends RegistrationException{
    private String studentId;
    public DuplicateStudentException(String id) {
        super("Student already registered: " + id, 4001);
        this.studentId = id;
    }
    public String getStudentId() {
        return studentId;
    }
}
