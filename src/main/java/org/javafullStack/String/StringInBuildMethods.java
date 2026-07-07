package org.javafullStack.String;

public class StringInBuildMethods {
    public static void main(String[] args) {
        String s = "hello";
        s.toUpperCase();
        System.out.println(s); // hello
        String s1 = s.toUpperCase();
        System.out.println(s1); // HELLO
        s =  new String("hello");
        s.toUpperCase();
        System.out.println(s);

    }
}
