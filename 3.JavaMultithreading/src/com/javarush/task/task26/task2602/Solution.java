package com.javarush.task.task26.task2602;

import java.util.Set;
import java.util.TreeSet;

/* 
Был бы ум - будет и успех
*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        Soldier a1 = new Soldier("Ivanov", 170);
        Soldier a2 = new Soldier("Petrov", 180);
        Soldier a3 = new Soldier("Sidorov", 175);
        soldiers.add(a1);
        soldiers.add(a2);
        soldiers.add(a3);

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Soldier o) {
            return o.height - this.height;
        }
    }
}
