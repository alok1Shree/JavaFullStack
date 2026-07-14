package org.javafullStack.Oops;

public class Cat extends Animal{
    private boolean isIndoor;

    public Cat(String name, boolean isIndoor) {
        super(name, "Meow");
        this.isIndoor = isIndoor;
    }

    public void purr() {
        System.out.println(getName() + " purrs... 😻");
    }

    public boolean isIndoor() {
        return isIndoor;
    }
}
