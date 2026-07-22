package org.javafullStack.Exception;

// ============================================================
// FILE: ExceptionMethods.java
// All important methods on Exception objects
// ============================================================

public class ExceptioniMethods {
    public static void level3() throws Exception {
        throw new Exception("Something went wrong at level 3");
    }

    public static void level2() throws Exception {
        try {
            level3();
        } catch (Exception e) {
            throw new RuntimeException("Level 2 wrapped error", e);
        }
    }

    public static void level1() {
        try {
            level2();
        } catch (Exception e) {

            System.out.println("==== EXCEPTION METHODS ====\n");

            // getMessage() — just the message string
            System.out.println("getMessage():");
            System.out.println("  " + e.getMessage());

            // toString() — class name + message
            System.out.println("\ntoString():");
            System.out.println("  " + e.toString());

            // getCause() — the original wrapped exception
            System.out.println("\ngetCause():");
            System.out.println("  " + e.getCause());
            System.out.println("  Cause message: "
                    + e.getCause().getMessage());

            // getClass() — the exception class
            System.out.println("\ngetClass().getSimpleName():");
            System.out.println("  " + e.getClass().getSimpleName());
            System.out.println("getClass().getName():");
            System.out.println("  " + e.getClass().getName());

            // getSuppressed() — for try-with-resources
            System.out.println("\ngetSuppressed().length:");
            System.out.println("  " + e.getSuppressed().length);

            // printStackTrace() — full stack trace to console
            System.out.println("\nstackTrace (top 3 lines):");
            StackTraceElement[] trace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, trace.length); i++) {
                System.out.println("  at " + trace[i]);
            }
        }
    }

    public static void main(String[] args) {
        level1();
    }
}
