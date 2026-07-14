package org.javafullStack.Oops;

public class Dog extends Animal {
    private String breed;   // NEW field only Dog has

    // Constructor — MUST call super() first
    public Dog(String name, String breed) {
        super(name, "Woof");   // calls Animal's constructor
        this.breed = breed;
    }

    public String getBreed() { return breed; }

    // NEW method — only Dog has this
    public void fetch() {
        System.out.println(getName() + " fetches the ball! 🎾");
    }
}
