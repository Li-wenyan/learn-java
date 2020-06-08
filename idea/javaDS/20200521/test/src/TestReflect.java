import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private String name = "小猫";
    public Cat() {

    }
    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(name + "正在吃" +food);
    }
    public void eat(String food1, String food2) {
        System.out.println(name + "正在吃" + food1 + "," + food2);
    }
}
public class TestReflect {
    //通过反射来实例化对象
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class catClass = Class.forName("Cat");
        //Cat cat = new Cat();
        Cat cat = (Cat) catClass.newInstance();//不使用new关键字也能创建出对象
    }
    //通过反射来修改或许获取对象的属性
    public static void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1.先获取到类对象
        Class catClass = Class.forName("Cat");
        //2. 借助类对象获取到指定的field对象
        //    现在这一步获取到的field对象相当于从一个大图纸中获取了局部图纸
        Field field = catClass.getDeclaredField("name");
        field.setAccessible(true);//专门处理private成员的方式，破门而入，破坏封装
        //3.根据图纸来修改/获取对象的相关字段
        Cat cat = new Cat();
        //可以通过get方法获取对应属性
        //也可以通过set方法来修改属性
        field.set(cat,"mimi");
        String name = (String) field.get(cat);
        System.out.println(name);
    }
    //通过反射来许获取/调用方法
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.先获取到类对象
        Class catClass = Class.forName("Cat");
        //2.根据类对象，根据名字获取到指定的Method对象
        //    getMethod从第二个参数开始，其实是用来描述当前eat对应的方法应该是哪个版本
        //    （当出现eat被重载的时候，能够借助参数列表的类型区分出来）

        Method method = catClass.getMethod("eat", String.class);//获取到一个参数版本的eat
        //Method method = catClass.getMethod("eat", String.class, String.class);//获取到两个参数版本的eat
        //3.借助Method对象来调用指定的方法（对于非静态方法，需要指定实例来调用）
        Cat cat = new Cat();
        method.invoke(cat,"鱼");
    }
    //调用构造方法
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1. 获取类对象
        Class catClass = Class.forName("Cat");
        //2.借助类对象获取Constructor对象
        Constructor constructor = catClass.getConstructor(String.class);//获取到参数为一个String的构造方法
        constructor.setAccessible(true);
        //3.根据constructor实例化对象
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("猫粮");

    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //testField();
        //testMethod();
        testConstructor();
    }
}
