package org.javafullStack.Array;

import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter your value: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements of the array are: ");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
