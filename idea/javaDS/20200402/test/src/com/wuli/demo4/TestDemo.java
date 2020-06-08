package com.wuli.demo4;
//接口
/*abstract class Shape {
    public abstract void draw() ;//抽象方法
}*/
interface Shape {
    void draw();
    /*public static final int a = 10;
    public abstract void draw() ;
    default void func() {

    }*/
}
interface A {

}
class Cycle implements Shape,A {
    @Override
    public void draw() {
        System.out.println("这是一个圆！");
    }
}
class Rect implements  Shape {
    @Override
    public  void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花！");
    }
}
class Triangle implements Shape {
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
        //接口也可以发生向上转型
        Shape shape1 = new Cycle();
        Shape shape2 = new Rect();
        Shape shape3 = new Flower();

        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);

    }
}
