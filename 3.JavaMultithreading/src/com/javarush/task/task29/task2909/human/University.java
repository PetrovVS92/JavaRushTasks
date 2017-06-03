package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    String name;
    int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student: students) {
            if (averageGrade == student.getAverageGrade()) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student maxAverageGrade;
        Comparator<Student> compareByAverageGrade = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return (int) Math.round (o1.getAverageGrade() - o2.getAverageGrade());
            }
        };
        maxAverageGrade = Collections.max(students, compareByAverageGrade);
        return maxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade(){
        if (!students.isEmpty())
        {
            Student student = students.get(0);
            for (Student current: students){
                if(current.getAverageGrade() < student.getAverageGrade()){
                    student = current;
                }
            }
            return student;
        }
        return null;
    }

    public void expel(Student student) {
        if(students.contains(student))
        {
            students.remove(student);
        }
    }
}