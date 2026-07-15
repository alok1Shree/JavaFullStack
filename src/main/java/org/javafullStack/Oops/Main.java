package org.javafullStack.Oops;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("Nitin",24, 85.5);
//        Student student1 = new Student("Pavan",24, 86.5);
//        Student student2 = new Student("Sashi",26, 87.5);
////        System.out.println("Name: " + student.name);
////        System.out.println("Age: " + student.age);
////        System.out.println("Marks: " + student.marks);
////        System.out.println("Name: " + student1.name);
////        System.out.println("Age: " + student1.age);
////        System.out.println("Marks: " + student1.marks);
////        System.out.println("Name: " + student2.name);
////        System.out.println("Age: " + student2.age);
////        System.out.println("Marks: " + student2.marks);
//
//
//        Product product = new Product("Pizza",12.5);
//        Product product1 = new Product("Laptop",12.5,"Electronic", 10);
//        Product product2 = new Product("Mobile",12.5,"Electronic");
//        Product product3 = new Product("Milk");
//
//        product.display();
//        product1.display();
//        product2.display();
//        product3.display();

//        Dog d = new Dog("Bruno", "Labrador");
//        Cat c = new Cat("Whiskers", true);
//
//        d.makeSound();   // Inherited from Animal → "Bruno says: Woof"
//        d.sleep();       // Inherited from Animal → "Bruno is sleeping..."
//        d.fetch();       // Dog's own method
//
//        c.makeSound();   // Inherited from Animal → "Whiskers says: Meow"
//        c.purr();        // Cat's own method
//
//        System.out.println(d.getBreed());  // Labrador
//        System.out.println(c.isIndoor()); // true

           Calculator calc = new Calculator();
            System.out.println("==== METHOD OVERLOADING ====");
            System.out.println(calc.add(5, 3));           // add(int, int)    → 8
            System.out.println(calc.add(5, 3, 2));        // add(int,int,int) → 10
            System.out.println(calc.add(5.5, 3.3));
    }
}
