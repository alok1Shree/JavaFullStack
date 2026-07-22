package org.javafullStack.Exception.StudentRegistration;

public class StudentRegistrationSystem {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     STUDENT REGISTRATION SYSTEM          ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        RegistrationSystem system = new RegistrationSystem();

        // Setup courses
        system.addCourse(new Course("PY101", "Python Basics",    30, null));
        system.addCourse(new Course("PY201", "Advanced Python",  20, "PY101"));
        system.addCourse(new Course("DB101", "MySQL Basics",     25, null));
        system.addCourse(new Course("FL101", "Flask Framework",  15, "PY101"));
        system.addCourse(new Course("WD101", "Web Development",  5,  null));   // small cap

        // ── STUDENT REGISTRATIONS ────────────────────────────
        System.out.println("==== REGISTRATIONS ====");
        Student aman = null, riya = null, zoya = null;

        try {
            aman = system.registerStudent("STU001", "Aman Kumar",  "aman@acte.com");
            riya = system.registerStudent("STU002", "Riya Sharma", "riya@acte.com");
            zoya = system.registerStudent("STU003", "Zoya Patel",  "zoya@acte.com");
        } catch (RegistrationException e) {
            System.out.println("❌ Registration failed: " + e.getMessage());
        }

        // Duplicate registration
        System.out.println("\n--- Testing Duplicate ---");
        try {
            system.registerStudent("STU001", "Duplicate User", "dup@test.com");
        } catch (DuplicateStudentException e) {
            System.out.println("❌ [Code:" + e.getCode() + "] "
                    + e.getMessage());
        } catch (RegistrationException e) {
            System.out.println("❌ " + e.getMessage());
        }

        // ── COURSE ENROLLMENT ────────────────────────────────
        System.out.println("\n==== ENROLLMENTS ====");
        String[][] enrollments = {
                {"STU001", "PY101"},
                {"STU001", "DB101"},
                {"STU002", "PY101"},
                {"STU002", "DB101"},
                {"STU003", "PY101"},
                {"STU001", "PY201"},   // ❌ prereq not met yet
                {"STU001", "WD101"},
        };

        for (String[] e : enrollments) {
            try {
                system.enrollInCourse(e[0], e[1]);
            } catch (PrerequisiteNotMetException ex) {
                System.out.println("❌ Prerequisite: " + ex.getMessage());
            } catch (CourseFullException ex) {
                System.out.println("❌ Course full: " + ex.getMessage());
            } catch (RegistrationException ex) {
                System.out.println("❌ Error [" + ex.getCode() + "]: "
                        + ex.getMessage());
            }
        }

        // ── SUBMIT MARKS ─────────────────────────────────────
        System.out.println("\n==== SUBMITTING MARKS ====");
        String[][] marksData = {
                {"STU001", "PY101", "92"},
                {"STU001", "DB101", "78"},
                {"STU002", "PY101", "85"},
                {"STU002", "DB101", "110"},  // ❌ invalid marks
                {"STU003", "PY101", "45"},
        };

        for (String[] m : marksData) {
            try {
                system.submitMarks(m[0], m[1], Double.parseDouble(m[2]));
            } catch (InvalidMarksException ex) {
                System.out.println("❌ " + ex.getMessage());
            } catch (RegistrationException ex) {
                System.out.println("❌ [" + ex.getCode() + "] "
                        + ex.getMessage());
            }
        }

        // ── NOW ENROLL Aman in Advanced Python ───────────────
        System.out.println("\n==== RE-ATTEMPTING ENROLLMENT ====");
        System.out.println("(Aman now completed PY101 with 92%)");
        try {
            system.enrollInCourse("STU001", "PY201");
        } catch (RegistrationException ex) {
            System.out.println("❌ " + ex.getMessage());
        }

        // ── REPORTS ──────────────────────────────────────────
        system.printCourseStatus();
        system.printAllReports();
        system.printAuditLog();
    }
}
