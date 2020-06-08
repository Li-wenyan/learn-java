
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-05
 * Time: 14:45
 */

class Person implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class TestDemo {

    public static void main(String[] args) {
        try {
            System.out.println(readFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() throws FileNotFoundException {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }

        public static void func3(int x,int y) throws ArithmeticException{
        if(y == 0) {
            //程序员 想自己手动抛出异常--》一般情况：手动抛出的都是自定义异常
            throw new ArithmeticException("你给的y == 0 不能作为除数！");
        }
        System.out.println(x/y);
    }
    /**
     * 抛出异常：
     * @param args
     */
    public static void main6(String[] args) {
        try {
            func3(10,0);
        }catch (ArithmeticException e) {
            System.out.println("除数为0！");
        }
    }


    //throws   声明一个异常，告诉程序员 调用此方法 需要处理异常的
    public static void func2() throws ArrayIndexOutOfBoundsException{
        int[] array = {1,2,3,4,5,6};
        System.out.println(array[100]);
    }

    public static void main5(String[] args) {
        try {
            func2();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
        }

    }


    public static int func() {
        try {
            int a = 10/0;
            return a;
        }catch (ArithmeticException e) {
            System.out.println("捕获数组越界异常！");
            return 80;
        }finally {
            System.out.println("finally被执行了！");
            return 19;
        }
    }
    /**
     * finally的注意事项：笔试的时候 -》选择题
     *   特性：finally当中的代码是肯定会被执行的
     *   1、finally当中的代码是肯定会被执行的 不管是否发生异常
     *   2、finally当中千万不要写 return语句
     *   3、用于资源的释放
     *      例如：I/O   文件  关闭
     * @param args
     */
    public static void main4(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(n);
        } catch (InputMismatchException e) {
            System.out.println("输入参数不匹配！");
        }
        /*int ret = func();
        System.out.println(ret);*/
    }

    public static void main3(String[] args) {
        try {
            int[] array = {1,2,3,4,5,6};
            System.out.println(array[1]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常！");
        }finally {
            System.out.println("finally被执行了！");
        }
        System.out.println("异常处理完了");
    }


    public static void main2(String[] args) {
        try {
            int[] array = {1,2,3,4,5,6};
            //array = null;
            System.out.println(array[1000]);
            System.out.println("gaobo");
        }catch (Exception e) {
            e.printStackTrace();
        }
        /*catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("捕获了NullPointerException 异常!");
        }*//*catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常！");
        }*/
        System.out.println("===========================");
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person) person.clone();
    }
}
