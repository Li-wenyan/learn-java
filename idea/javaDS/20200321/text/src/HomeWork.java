import java.lang.reflect.Array;
import java.util.Arrays;

class Calculator {
    private int num1;
    private int num2;

    public Calculator() {

    }
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
        return this.num1*this.num2;
    }
    public double dev() {
        return this.num1*1.0/this.num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
class MyValue {
    public int val;
}
public class HomeWork {
    //3.实现交换两个变量的值。要求：需要交换实参的值
    public static void swap(MyValue myValue3,MyValue myValue4) {
        int tmp = myValue3.val;
        myValue3.val = myValue4.val;
        myValue4.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val+" "+myValue2.val);
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+myValue2.val);

    }
    /*public static void swap(int[] array1) {
        int tmp = array1[0];
        array1[0] = array1[1];
        array1[1] = tmp;
    }
    public static void main(String[] args) {
        int[] array = {10,20};
        System.out.println(array[0] + " " +array[1]);
        swap(array);
        System.out.println(array[0] + " " +array[1]);
    }*/
   //1,编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
    //除四种运算
    //2.设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象
   public static void main2(String[] args) {
       Calculator calculator = new Calculator(30,40);
       System.out.println(calculator.add());
       System.out.println(calculator.sub());
       System.out.println(calculator.mul());
       System.out.println(calculator.dev());
   }
   public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.dev());
   }






    /* static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };*/


       /*public String toString() {

           System.out.print("aaa");

           return "bbb";

       }
    public static void main(String[] args) {

        System.out.println(new HomeWork());
    }*/
    //给定两个整型数组, 交换两个数组的内容
    //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
}
