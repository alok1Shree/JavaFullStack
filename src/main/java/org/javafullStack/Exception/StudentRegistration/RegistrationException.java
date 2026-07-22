package org.javafullStack.Exception.StudentRegistration;

public class RegistrationException extends Exception {
    private int code;
    public RegistrationException(String message,int code) {
        super(message);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {}
}
