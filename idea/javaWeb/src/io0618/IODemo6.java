package io0618;

import java.io.*;

class Student implements Serializable{
    public String name;
    public int age;
    public int score;
}
public class IODemo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* Student student = new Student();
        student.name = "张三";
        student.age = 20;
        student.score = 100;
        serializeStudent(student);*/
       Student s = deserializeStudent();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }

    private static void serializeStudent(Student student) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/studnet.txt"));
        //这个writeObject集序列化+写文件  两者同时搞定
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    private static Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/studnet.txt"));
        Student s = (Student) objectInputStream.readObject();
        return s;
    }
}
