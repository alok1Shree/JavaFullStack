package org.javafullStack.Oops;

//This is the example for Polymorphism - Compile time polymorphism (Method Overloading)
public class Calculator {

    public  int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d ) {
        return a + b + c + d;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
