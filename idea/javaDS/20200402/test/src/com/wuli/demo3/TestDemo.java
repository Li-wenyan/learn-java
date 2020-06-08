package com.wuli.demo3;
//抽象类：包含抽象方法的类
abstract class Shape {
    public int a;
    public void func() {
        System.out.println("func()");
    }
    public abstract void draw() ;//抽象方法
}
abstract class B extends Shape {

}
/*class C extends B {
    //这里必须要重写，出来混迟早要还的
}*/
class A extends Shape {
    @Override
    public void draw() {
        System.out.println("ffsfsffs");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆！");
    }
}
class Rect extends Shape {
    @Override
    public  void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花！");
    }
}
class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个三角形！");
    }
}
public class TestDemo {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        //也可以发生向上转型
        Shape shape1 = new Cycle();
        Shape shape2 = new Rect();
        Shape shape3 = new Flower();

        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);

    }
}
