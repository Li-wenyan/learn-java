class Money {

}
class Person {
    public Money money;//Person和money构成了组合
}
public class TestDome {
    public static void main(String[] args) {
        Animal animal = new Animal("大黄");
        System.out.println(animal.sex);
    }
    public static void main2(String[] args) {
        Bird bird = new Bird("初一",10);
        //bird.name = "初一";
        bird.eat();
        bird.fly();
    }
    public static void main1(String[] args) {
        Dog dog = new Dog("将军");
        //dog.name = "将军";
        dog.eat();

    }
}
