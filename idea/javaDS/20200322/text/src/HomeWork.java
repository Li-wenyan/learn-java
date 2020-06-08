/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-22
 * Time: 14:30
 */

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
    public static void swap(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.val;
        myValue1.val = myValue2.val;
        myValue2.val = tmp;
    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val+" " +myValue2.val);
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" " +myValue2.val);
    }

    public static void swap2(int[] array2) {
        int tmp = array2[0];
        array2[0] = array2[1];
        array2[1] = tmp;
    }

    public static void swap1(int x,int y) {
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println(x+" "+y);
    }


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
}
