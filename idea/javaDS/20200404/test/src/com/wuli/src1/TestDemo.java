package com.wuli.src1;

import java.util.Arrays;

class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("wuli",18);
        students[1] = new Student("wuliwuli",28);
        students[2] = new Student("wuliwuliwuli",38);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
