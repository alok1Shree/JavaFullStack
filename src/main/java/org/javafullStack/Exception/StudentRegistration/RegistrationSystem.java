package org.javafullStack.Exception.StudentRegistration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationSystem {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course>  courses  = new HashMap<>();
    private List<String> auditLog = new ArrayList<>();

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
        log("Course added: " + course.getCode() + " — " + course.getName());
    }

    public Student registerStudent(String id, String name, String email)
            throws DuplicateStudentException, RegistrationException {

        if (id == null || id.trim().isEmpty())
            throw new RegistrationException("Student ID is required", 4000);

        if (students.containsKey(id))
            throw new DuplicateStudentException(id);

        Student student = new Student(id, name, email);
        students.put(id, student);
        log("Student registered: " + id + " — " + name);
        System.out.println("✅ Registered: " + name + " [" + id + "]");
        return student;
    }

    public void enrollInCourse(String studentId, String courseCode)
            throws RegistrationException,
            CourseFullException,
            PrerequisiteNotMetException {

        Student student = getStudent(studentId);
        Course  course  = getCourse(courseCode);

        // Check already enrolled
        if (student.getEnrolledCourses().contains(courseCode))
            throw new RegistrationException(
                    "Already enrolled in " + courseCode, 4005);

        // Check prerequisite
        if (course.hasPrerequisite()) {
            String prereq = course.getPrerequisite();
            if (!student.hasCompleted(prereq))
                throw new PrerequisiteNotMetException(
                        course.getName(), prereq);
        }

        // Check capacity
        if (course.isFull())
            throw new CourseFullException(course.getName(),
                    course.getMaxCapacity());

        // All checks passed — enroll
        student.addCourse(courseCode);
        course.addStudent(studentId);
        log("Enrolled: " + studentId + " in " + courseCode);
        System.out.printf("✅ %s enrolled in %s%n",
                student.getName(), course.getName());
    }

    public void submitMarks(String studentId, String subject, double marks)
            throws RegistrationException, InvalidMarksException {

        if (marks < 0 || marks > 100)
            throw new InvalidMarksException(subject, marks);

        Student student = getStudent(studentId);

        if (!student.getEnrolledCourses().contains(subject))
            throw new RegistrationException(
                    "Student not enrolled in: " + subject, 4006);

        student.addMarks(subject, marks);
        String grade = marks >= 90 ? "A" : marks >= 75 ? "B"
                : marks >= 60 ? "C" : marks >= 40 ? "D" : "F";
        log("Marks added: " + studentId + " | "
                + subject + " | " + marks + " | " + grade);
        System.out.printf("📝 Marks for %s | %s: %.1f (%s)%n",
                student.getName(), subject, marks, grade);
    }

    private Student getStudent(String id) throws RegistrationException {
        Student s = students.get(id);
        if (s == null)
            throw new RegistrationException(
                    "Student not found: " + id, 4007);
        return s;
    }

    private Course getCourse(String code) throws RegistrationException {
        Course c = courses.get(code);
        if (c == null)
            throw new RegistrationException(
                    "Course not found: " + code, 4008);
        return c;
    }

    public void printAllReports() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          STUDENT REPORTS                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
        for (Student s : students.values()) s.printReport();
    }

    public void printAuditLog() {
        System.out.println("\n==== AUDIT LOG ====");
        auditLog.forEach(l -> System.out.println("  📋 " + l));
    }

    public void printCourseStatus() {
        System.out.println("\n==== COURSE STATUS ====");
        System.out.printf("%-10s %-25s %10s%n",
                "Code", "Name", "Enrolled/Max");
        System.out.println("─".repeat(48));
        for (Course c : courses.values()) {
            System.out.printf("%-10s %-25s %5d/%-5d%n",
                    c.getCode(), c.getName(),
                    c.getEnrolled(), c.getMaxCapacity());
        }
    }

    private void log(String entry) {
        String time = java.time.LocalTime.now()
                .format(java.time.format.DateTimeFormatter
                        .ofPattern("HH:mm:ss"));
        auditLog.add("[" + time + "] " + entry);
    }
}
