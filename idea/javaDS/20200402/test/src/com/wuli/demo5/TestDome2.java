package com.wuli.demo5;

import java.util.Arrays;

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age < o.age) {
            return -1;
        }
        if(this.age == o.age) {
            return 0;
        }
        return 1;*/
        //return this.age - o.age;//从小到大    从大到小 o.age-this.age
        //return this.score - o.score;
        return this.name.compareTo(o.name);//字符串的比较大小会用compareTo
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDome2 {
    //对自定义类型进行排序  一定要实现implements Comparable 接口
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("bit",10,89);
        students[1] = new Student("wuli",18,99);
        students[2] = new Student("sdv",23,59);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }
    public static void main1(String[] args) {
        int[] array = {18,1,2,6,3,8};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
