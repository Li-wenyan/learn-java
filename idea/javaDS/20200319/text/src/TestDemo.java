/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-19
 * Time: 12:13
 */
//声明一个类 Person   类-》对象(实体)
class A {

}
class Person {
    public String name;//属性  // 字段  成员变量
    public int age;
    public static int count;//静态成员属性  不属于对象  属于类本身

    public final int SIZE = 10;//常量 -> 不能被修改的   属于对象
    // 一个属性他存放在内存的哪个区域，和是否被final所修饰无关。
    public static final int SIZE2 = 100;//常量

    public A a;
    //行为 -> 成员方法
    public void eat() {
        System.out.println("吃饭！");
    }
    public void sleep() {
        //eat();
        System.out.println("睡觉！");
    }
    public void show() {
        System.out.println("姓名："+ name + " 年龄： "+ age);
    }
    public static void func() {
        count++;
        //SIZE2 = 99; 常量
        //静态成员方法内 是不可以访问非静态数据成员的。
        System.out.println("static::func()"+SIZE2);
    }
}
public class TestDemo {
    public static void function() {
        System.out.println("static:function()");
    }
    public static void main3(String[] args) {
        Person.func();
        Person person = new Person();
        System.out.println(person.age);
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "张三";
        person1.age = 99;
        person1.show();
        System.out.println("Person："+ Person.count);
        Person.func();
        System.out.println(person1.SIZE);
        System.out.println(Person.SIZE2);
    }

    public static void main1(String[] args) {
        //实例化一个对象  new关键字
       Person person1 = new Person();
       person1.name = "张三";
       person1.age = 99;
       System.out.println(person1.name);
       System.out.println(person1.age);
       person1.eat();
       person1.sleep();
        System.out.println("数组："+ person1.a);

       Person person2 = new Person();
        person2.name = "李四";
        person2.age = 88;
        System.out.println(person2.name);
        System.out.println(person2.age);
        /*Person person3 = new Person();

        Person person4 = new Person();*/

    }
}
