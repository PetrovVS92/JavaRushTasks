package com.javarush.task.task01;

/**
 * Created by user on 28.04.2017.
 */
public class proba {
    public static void main(String[] args) {

        int marks[] = {10,3,3,2,1,4,5,9};
        int m = marks[0] + marks[1];
        for(int i=1;i<marks.length-1;i++){
            if(marks[i] + marks[i+1] > m)
                m=marks[i] + marks[i+1];
        }
        System.out.println("m=" + m);
    }
}
