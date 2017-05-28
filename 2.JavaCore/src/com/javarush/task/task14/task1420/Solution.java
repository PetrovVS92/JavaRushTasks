package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int numberFirst = Integer.parseInt(reader.readLine());
            if (numberFirst <= 0) throw new Exception();
            int numberSecond = Integer.parseInt(reader.readLine());
            if (numberSecond <= 0) throw new Exception();
            while (numberSecond != 0) {
                int tmp = numberFirst % numberSecond;
                numberFirst = numberSecond;
                numberSecond = tmp;
            }
            System.out.println(numberFirst);


    }
}
