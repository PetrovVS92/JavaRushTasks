package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int length;
        final Double median;
        length = array.length;
        if (length%2==0) {
            median = (array[length/2-1] + array[length/2]) / 2.0;
        } else {
            median = array[length/2] / 1.0;
        }

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int lip = (int)Math.abs(o1 - median) - (int)Math.abs(o2 - median);
                if (lip == 0) {
                    return 1;
                } else {
                    return lip;
                }
            }
        };

        Arrays.sort(array, compareByMedian);
        return array;
    }
}
