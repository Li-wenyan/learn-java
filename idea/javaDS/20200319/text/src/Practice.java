
class B {

}
class Chinese {
    public String name;
    public int age;
    public static int count;

    public final int SIZE = 20;
    public static final int SIZE2 = 30;
    public B b;
    public void eat() {
        System.out.println("吃饭");
    }
    public void sleep(){
        //eat();
        System.out.println("睡觉");
    }
    public void show() {
        System.out.println("姓名：" + name +", 年龄："+ age);
    }
    public static void func() {
        count++;
        //SIZE2 = 99;
        System.out.println("static : func" + SIZE2);
    }
}
public class Practice {
     public static void function() {
         System.out.println("static :function");
     }
    public static void main3(String[] args) {
        Chinese.func();
        Chinese person = new Chinese();
        System.out.println(person.age);
    }

    public static void main2(String[] args) {
        Chinese person1 = new Chinese();
        person1.name = "吴睿曦";
        person1.age = 18;
        person1.show();
        System.out.println(Chinese.count);
        Chinese.func();
        System.out.println(person1.SIZE);
        System.out.println(Chinese.SIZE2);
    }

    public static void main1(String[] args) {
        Chinese person1 = new Chinese();
        person1.name = "李文艳";
        person1.age = 3;
        System.out.println(person1.name);
        System.out.println(person1.age);
        person1.eat();
        person1.sleep();
        System.out.println("数组" +person1.b);
        Chinese person2 = new Chinese();
        person2.name = "liwenyan";
        person2.age = 18;
        System.out.println(person2.name);
        System.out.println(person2.age);
    }

    public static void main5(String[] args) {
        Student2 student2 = new Student2("李文艳",18);
        System.out.println(student2.getName());
        Student2 student3 = new Student2();
        System.out.println(student3.getName());
        System.out.println("哈哈哈"+student3.getAge());
    }

    public static void main(String[] args) {
        Student2 student = new Student2();
        student.setAge(99);
        System.out.println(student.getAge());
        System.out.println("=================");
        student.setName("Jason");
        System.out.println(student.getName());
    }
}
class Student2 {
    private String name;
    private int age;

    public Student2() {
        this("李文艳",3);
        System.out.println("Student()");
    }
    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /*public static void func() {
        this.name = "bit";
    }*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void func() {
        this.getAge();
    }

   /* public String getName() {
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
    }*/

}