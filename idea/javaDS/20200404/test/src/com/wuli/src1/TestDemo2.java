package com.wuli.src1;
class Money implements Cloneable{
    public int money = 19;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public int age;
    public Money m;
    public Person(int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
       Person person1 = (Person) super.clone();
       person1.m = (Money) this.m.clone();
       return person1;
    }
}
public class TestDemo2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 = (Person) person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
        System.out.println("=================");
        person1.m.money = 999;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);

    }




    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 = (Person) person.clone();
        /*try {
            Person person1 = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
        System.out.println(person.age);
        System.out.println(person1.age);
        System.out.println("==================");
        person1.age = 999;
        System.out.println(person.age);
        System.out.println(person1.age);
    }
}
