import java.util.InputMismatchException;
import java.util.Scanner;

class Person implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TestDemo {
    //抛出异常
    public static void func3(int x,int y) throws ArithmeticException {
        if(y == 0) {
            //程序员想自己手动抛出异常，一般手动抛出的异常是自定义异常
            throw new ArithmeticException("你给的y=0，不能作为除数");
        }
        System.out.println(x/y);
    }
    public static void main(String[] args) {
        try {
            func3(10,0);
        }catch(ArithmeticException e) {
            System.out.println("除数为0");
        }

    }
    //throws 声明一个异常，告诉程序员调用此方法需要处理异常
    public static void func2 () throws ArrayIndexOutOfBoundsException {
        int[] array = {1,2,3,4,5};
        System.out.println(array[100]);
    }
    public static void main5(String[] args) {
        try {
            func2();
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常！");
        }

    }
    public static int func (int a){
        try {
            a = 10/0;
            return a;
        }catch(ArithmeticException e) {
            System.out.println("捕获算数异常");
            return 80;
        }finally {
            System.out.println("finally被执行了！");
            return 19;
        }

    }
    public static void main4(String[] args) {
        /*int ret = func(10);
        System.out.println(ret);*/
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(n);
        } catch (InputMismatchException e) {
            System.out.println("输入参数不匹配异常！");
        }

    }
    public static void main3(String[] args) {
        try {
            int[] array = {1,2,3,4,5,6};
            System.out.println(array[1000]);
            System.out.println("after");
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常");
        }finally {
            System.out.println("finally被执行了！");
        }
        System.out.println("异常处理完了");
    }
    public static void main2(String[] args) {
        try {
            int[] array = null;
            System.out.println(array.length);
            System.out.println("wuli");//不会执行
        }catch (NullPointerException e) {
            e.printStackTrace();//打印异常信息
            System.out.println("捕获了NullPointerException异常");
        }
        System.out.println("==============");//会执行
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();//编译时异常
    }
}
