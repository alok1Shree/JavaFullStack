package org.javafullStack.Oops;

public class Product {

    String name;
    double price;
    String category;
    int stock;

    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = 0; // Default stock value
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name){
        this(name, 0.0, "General", 0);
    }

    //access modifier -- return type -- method name( parameters ) --> Syntax for creating method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + stock);
        System.out.println("-------------------------------");
    }
}
