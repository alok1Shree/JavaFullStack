package org.javafullStack.Exception.StudentRegistration;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String       code;
    private String       name;
    private int          maxCapacity;
    private int          enrolled;
    private String       prerequisite;   // null if none
    private List<String> studentIds;

    public Course(String code, String name,
                  int maxCapacity, String prerequisite) {
        this.code         = code;
        this.name         = name;
        this.maxCapacity  = maxCapacity;
        this.enrolled     = 0;
        this.prerequisite = prerequisite;
        this.studentIds   = new ArrayList<>();
    }

    public String getCode()         { return code; }
    public String getName()         { return name; }
    public int    getMaxCapacity()  { return maxCapacity; }
    public int    getEnrolled()     { return enrolled; }
    public String getPrerequisite() { return prerequisite; }

    public boolean isFull() { return enrolled >= maxCapacity; }
    public boolean hasPrerequisite() { return prerequisite != null; }

    public void addStudent(String studentId) {
        studentIds.add(studentId);
        enrolled++;
    }
}
