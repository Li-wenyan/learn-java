import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:数组是引用类型
 * User: GAOBO
 * Date: 2020-03-14
 * Time: 9:07
 */
public class TestDemo {

    public static int[] func2() {
        int[] array = {1,2,3,4,5,6};
        return array;
    }

    public static void main9(String[] args) {
        int[] ret = func2();
        System.out.println(Arrays.toString(ret));
    }

    public static void main8(String[] args) {
        String[] strings = new String[2];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.next();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); //"1 12 31 4 5 6 7 8"
        //1、根据空格 先分割字符
        //2、拿到每一个12 ->数字12
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5};
        array = null;
        System.out.println(array[0]);
        System.out.println(array.length);
    }

    public static void swap1(int c,int d) {
        int tmp = c;
        c = d;
        d = tmp;
    }

    public static void swap(int[] array2) {
        int tmp = array2[0];
        array2[0] = array2[1];
        array2[1] = tmp;
    }
    public static void main5(String[] args) {
        int[] array = {10,20};
        System.out.println(array[0]+" "+array[1]);
        swap(array);
        System.out.println(array[0]+" "+array[1]);
    }



    public static void main4(String[] args) {
        //交换两个数字
        int a = 10;
        int b = 20;
        System.out.println(a+" " + b);
        swap1(a,b);
        System.out.println(a+" " + b);
    }


    public static void print(int[] array) {
        array[1] = 9999;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void func(int a) {
        a = 888;
        System.out.println(a);//888
    }

    public static void main3(String[] args) {
        /*int b = 10;
        func(b);
        System.out.println(b);//10*/
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        print(array2);
        System.out.println("================");
        System.out.println(Arrays.toString(array2));
    }

    public static void main2(String[] args) {
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(array2.length);
        System.out.println(array2[0]);
        array2[0] = 888;
        System.out.println(array2[0]);
    }
    
    public static void main1(String[] args) {
        int[] array1 = new int[3];//定义，但是没有初始化,但是默认值为0

        int[] array2 = {1,2,3,4,5,6,7,8,9,10};//定义且初始化了一个数组，数组大小为10

        int[] array3 = new int[]{1,2,3,4,5,6,7};//定义且初始化了一个数组，数组大小为7

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] +" ");
        }
        System.out.println();
        System.out.println("======for  each==========");
        //for  each
        for (int i : array2) {
            System.out.print(i+" ");
        }
        //将数组内容以字符串的形式进行输出
        System.out.println();
        System.out.println("======数组内容以字符串的形式进行输出==========");
        System.out.println(Arrays.toString(array2));
    }
}
