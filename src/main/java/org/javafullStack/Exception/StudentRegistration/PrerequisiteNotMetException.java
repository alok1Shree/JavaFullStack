package org.javafullStack.Exception.StudentRegistration;

public class PrerequisiteNotMetException  extends RegistrationException{
    private String courseName;
    private String prerequisiteCourse;
    public PrerequisiteNotMetException(String course, String prerequisite) {
        super("Prerequisite not met for course: " + course + " (Prerequisite: " + prerequisite + ")", 4004);
        this.courseName = course;
        this.prerequisiteCourse = prerequisite;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
}
