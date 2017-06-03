package com.javarush.task.task29.task2909.human;

/**
 * Created by user on 29.05.2017.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
        super.live();
        fight();
    }

    public void fight() {
    }
}
