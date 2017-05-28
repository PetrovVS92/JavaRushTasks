package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (args[0].equals("-c")) {
            Person person;
            try {
                Date date = simpleDateFormat.parse(args[3]);
                if (args[2].equals("ж")){
                    person = Person.createFemale(args[1], date);
                    allPeople.add(person);
                } else {
                    person = Person.createMale(args[1], date);
                    allPeople.add(person);
                }
                System.out.println(allPeople.lastIndexOf(person));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (args[0].equals("-u")) {
            try {
                Date date = simpleDateFormat.parse(args[4]);
                allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (args[0].equals("-d")) {
            allPeople.set(Integer.parseInt(args[1]), new Person());
        }
        if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String name = person.getName();
            String sex = "0";
            if (person.getSex().equals(Sex.MALE)) {
                sex = "м";
            } else {
                sex = "ж";
            }
            SimpleDateFormat iDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = iDateFormat.format(person.getBirthDay());
            System.out.println(name + " " + sex + " " + date);
        }
    }
}
