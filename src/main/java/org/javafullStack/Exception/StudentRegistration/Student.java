package org.javafullStack.Exception.StudentRegistration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String        id;
    private String        name;
    private String        email;
    private List<String> enrolledCourses;
    private Map<String, Double> marks;

    public Student(String id, String name, String email) {
        this.id              = id;
        this.name            = name;
        this.email           = email;
        this.enrolledCourses = new ArrayList<>();
        this.marks           = new HashMap<>();
    }

    public String       getId()              { return id; }
    public String       getName()            { return name; }
    public String       getEmail()           { return email; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public Map<String, Double> getMarks()    { return marks; }

    public boolean hasCompleted(String course) {
        return marks.containsKey(course) && marks.get(course) >= 40;
    }

    public void addCourse(String course) {
        enrolledCourses.add(course);
    }

    public void addMarks(String subject, double marks) {
        this.marks.put(subject, marks);
    }

    public double calculateGPA() {
        if (marks.isEmpty()) return 0.0;
        double total = 0;
        for (double m : marks.values()) total += m;
        return total / marks.size();
    }

    public void printReport() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.printf ("│  ID      : %-27s│%n", id);
        System.out.printf ("│  Name    : %-27s│%n", name);
        System.out.printf ("│  Email   : %-27s│%n", email);
        System.out.println("│  Courses : " + enrolledCourses + "   │");
        System.out.printf ("│  GPA     : %-27.2f│%n", calculateGPA());
        System.out.println("└──────────────────────────────────────┘");
    }
}
