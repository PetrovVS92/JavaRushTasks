package com.javarush.task.task29.task2909.car;

/**
 * Created by user on 31.05.2017.
 */
public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
