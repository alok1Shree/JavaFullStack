package org.javafullStack.Array;


public class TraverseArray {
    public static void main(String[] args) {
        int arr[] = {2,4,6,7,1,4,5};
       // System.out.println(arr[7]); //ArrayIndexOutOfBoundsException: if we access array out of its size
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Size of Array:"+arr.length);
    }
}
