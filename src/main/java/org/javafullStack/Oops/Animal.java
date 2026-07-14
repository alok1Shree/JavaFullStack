package org.javafullStack.Oops;

public class Animal {
    private String name;    // private — child cannot access directly
    private String sound;

    // Constructor
    public Animal(String name, String sound) {
        this.name  = name;
        this.sound = sound;
    }

    // Getters (child inherits these methods)
    public String getName()  { return name; }
    public String getSound() { return sound; }

    // Method inherited by ALL children
    public void makeSound() {
        System.out.println(name + " says: " + sound);
    }

    public void sleep() {
        System.out.println(name + " is sleeping... 💤");
    }
}
