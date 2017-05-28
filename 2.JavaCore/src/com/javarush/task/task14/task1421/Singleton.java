package com.javarush.task.task14.task1421;

/**
 * Created by user on 15.04.2017.
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
