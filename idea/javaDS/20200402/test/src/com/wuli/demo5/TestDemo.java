package com.wuli.demo5;

interface A{
    void func1();
}
interface B  {
    void func2();
}
//扩展
interface C extends B,A{
    void func3();
}

class AA implements C {
    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }
}
class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying {
    void flay();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}
//一个类可以继承一个类，并且同时实现多个接口
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在跑！");
    }
}
class Flog extends Animal implements IRunning,ISwimming {
    public Flog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在跑！");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在游！");
    }
}
class Robot implements IRunning {
    @Override
    public void run() {
        System.out.println("机器人会跑");
    }
}
public class TestDemo {
    public static void walk(IRunning iRunning) {
        iRunning.run();
    }
    public static void swim(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("小花");
        walk(cat);
        Flog flog = new Flog("小哇");
        walk(flog);
        swim(flog);
        //swim(cat);
        Robot robot = new Robot();
        walk(robot);
    }
}
