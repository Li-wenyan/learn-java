public class Bird extends Animal{
    //public String name;

    /*public void eat() {
        System.out.println(this.name + " 正在吃！");
    }*/

    public int age;
    public Bird(String name,int age) {
        //构造父类

        super(name);//代表调用父类的带有一个参数的构造方法,子类并没有调用父类的构造方法，只是在子类当中，进行了显示的调用，通过super
        //super(name,"bit"); //只能调用一次
        this.age = age;
    }
    /*public Bird() {
        super("初一");
    }*/
    public void fly() {
        System.out.println(this.name + "正在飞！");
        System.out.println(super.name);
        super.eat();
    }
    public void testProtected() {
        System.out.println(this.sex);
    }
}
