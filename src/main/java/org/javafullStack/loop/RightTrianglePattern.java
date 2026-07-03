package org.javafullStack.loop;

public class RightTrianglePattern {
    public static void main(String[] args) {
        for(int i =0; i<=5;i++){ // row
            for(int j=1;j<=i;j++){ // column
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
