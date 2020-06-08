package www.bit.scr3;



class Animal {
    public String name;
    public Animal(String name) {
        this.name = name;
        eat();
    }

    public void eat() {
        System.out.println("Animal:" + this.name + " 正在吃!");
    }
}
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void fly (){
        System.out.println(this.name + "正在飞！");
    }
    @Override
    public void eat() {
        System.out.println("Bird :" + this.name + " 正在吃!");
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
class HelloKit extends Cat {

    public HelloKit(String name) {
        super(name);
    }
}
public class TestMain {
    public static void main(String[] args) {
        Animal animal = new Animal("将军");
        Animal animal2 = new Cat("将军2");
        Animal animal3 = new HelloKit("将军3");

    }
    //面试问题：构造函数中是否可以发生运行时绑定?    可以！
    public static void main4(String[] args) {
        Animal animal = new Animal("将军");
        System.out.println();
        Animal bird = new Bird("鸟儿");

    }
    //演示向下转型不安全示例
    public static void main3(String[] args) {
        Animal animal = new Cat("咪咪");
        //此时animal并不是Bird的一个实例
        if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.fly();
        }

    }
    public static void main2(String[] args) {
        Animal animal = new Bird("鸟儿");
        animal.eat();
        Bird bird = (Bird) animal;//向下转型
        bird.fly();
    }
    public static void main1(String[] args) {
        Animal animal = new Bird("将军");
        animal.eat();

    }
    /*public static void func1(Animal animal) {
        animal.eat();
    }
    public Animal func2 () {
        Bird bird = new Bird("愤怒的系哦啊鸟");
        return bird;
    }
    public static void main(String[] args) {
        Bird bird = new Bird("鸟儿");
        func1(bird);
    }
    public static void main2(String[] args) {
        //父类引用  引用了子类对象  =》向上转型
        Animal animal = new Bird("初一");
        animal.eat();

        //animal.fly();错的   父类引用  只能访问自己的成员方法或属性
    }
    public static void main1(String[] args) {
        Animal animal = new Animal("将军");
        Bird bird = new Bird("初一");
        Cat cat = new Cat("咪咪");

    }*/

}
