package com.bit.src1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 9:03
 */
// a > b
class  Student implements Comparable<Student>{
    public String naeme;
    public int age;

    public Student(String naeme, int age) {
        this.naeme = naeme;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "naeme='" + naeme + '\'' +
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
        Student[] students = new Student[2];
        students[0] = new Student("bit",8);
        students[1] = new Student("gaobo",5);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
