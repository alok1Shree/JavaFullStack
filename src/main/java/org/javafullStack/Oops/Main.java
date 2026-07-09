package org.javafullStack.Oops;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Nitin",24, 85.5);
        Student student1 = new Student("Pavan",24, 86.5);
        Student student2 = new Student("Sashi",26, 87.5);
//        System.out.println("Name: " + student.name);
//        System.out.println("Age: " + student.age);
//        System.out.println("Marks: " + student.marks);
//        System.out.println("Name: " + student1.name);
//        System.out.println("Age: " + student1.age);
//        System.out.println("Marks: " + student1.marks);
//        System.out.println("Name: " + student2.name);
//        System.out.println("Age: " + student2.age);
//        System.out.println("Marks: " + student2.marks);


        Product product = new Product("Pizza",12.5);
        Product product1 = new Product("Laptop",12.5,"Electronic", 10);
        Product product2 = new Product("Mobile",12.5,"Electronic");
        Product product3 = new Product("Milk");

        product.display();
        product1.display();
        product2.display();
        product3.display();

    }
}
