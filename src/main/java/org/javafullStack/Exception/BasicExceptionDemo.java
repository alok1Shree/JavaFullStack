package org.javafullStack.Exception;

public class BasicExceptionDemo {
    public static void main(String[] args) {
        System.out.println("==== EXAMPLE 1: ArithmeticException ====");

        try {
            int a = 10;
            int b = 0;
            System.out.println("Attempting: 10 / 0");
            int result = a / b;              // throws ArithmeticException
            System.out.println("Result: " + result);   // NEVER executes
        } catch (ArithmeticException e) {
            System.out.println("❌ Caught: " + e.getMessage());
            // Output: ❌ Caught: / by zero
        }
        System.out.println("✅ Program continues normally\n");

        // ─────────────────────────────────────────────────────
        System.out.println("==== EXAMPLE 2: NumberFormatException ====");

        String input = "abc123";
        try {
            int number = Integer.parseInt(input);   // throws NumberFormatException
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("❌ Cannot convert '" + input
                    + "' to integer");
            System.out.println("   Error: " + e.getMessage());
        }
        System.out.println("✅ Program continues normally\n");

        // ─────────────────────────────────────────────────────
        System.out.println("==== EXAMPLE 3: NullPointerException ====");

        String name = null;
        try {
            System.out.println("Length: " + name.length());  // NPE
        } catch (Exception e) {
            System.out.println("❌ Variable is null — cannot call method");
        }
        System.out.println("✅ Program continues normally\n");

        // ─────────────────────────────────────────────────────
        System.out.println("==== EXAMPLE 4: ArrayIndexOutOfBounds ====");

        int[] numbers = {10, 20, 30};
        try {
            System.out.println("numbers[5] = " + numbers[5]); // only 0,1,2 exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Index 5 doesn't exist. Array size: "
                    + numbers.length);
        }
        System.out.println("✅ Program continues normally");

    }
}
