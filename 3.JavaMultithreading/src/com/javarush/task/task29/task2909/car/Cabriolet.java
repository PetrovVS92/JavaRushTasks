package com.javarush.task.task29.task2909.car;

/**
 * Created by user on 31.05.2017.
 */
public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }

    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
