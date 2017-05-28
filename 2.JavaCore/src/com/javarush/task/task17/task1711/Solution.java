package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int peoplesC = (args.length - 1) / 3;
                    Person person;
                    for (int i = 0; i < peoplesC; i++) {
                        try {
                            Date date = simpleDateFormat.parse(args[3 + 3 * i]);
                            if (args[2 + 3 * i].equals("м")) {
                                person = Person.createMale(args[1 + 3 * i], date);
                                allPeople.add(person);
                            } else {
                                person = Person.createFemale(args[1 + 3 * i], date);
                                allPeople.add(person);
                            }
                            System.out.println(allPeople.lastIndexOf(person));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    int peoplesU = (args.length - 1) / 4;
                    for (int i = 0; i < peoplesU; i++) {
                        try {
                            Date date = simpleDateFormat.parse(args[4 + 4 * i]);
                            if (args[3 + 4 * i].equals("м")) {
                                allPeople.set(Integer.parseInt(args[1 + 4 * i]), Person.createMale(args[2 + 4 * i], date));
                            } else {
                                allPeople.set(Integer.parseInt(args[1 + 4 * i]), Person.createFemale(args[2 + 4 * i], date));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        Person personNull = new Person();
                        allPeople.set(Integer.parseInt(args[1 + i]), personNull);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        Person personGet = allPeople.get(Integer.parseInt(args[1 + i]));
                        String name = personGet.getName();
                        String sex = "0";
                        if (personGet.getSex().equals(Sex.MALE)) {
                            sex = "м";
                        } else {
                            sex = "ж";
                        }
                        SimpleDateFormat iDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String date = iDateFormat.format(personGet.getBirthDay());
                        System.out.println(name + " " + sex + " " + date);

                    }
                }
                break;
        }
    }
}
