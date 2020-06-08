import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    //四种拷贝方式
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        /*int[] ret = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));
        ret[0] = 999;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ret));*/
        //方法4：clone
        /*int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));*/
        //方法3：Arrays.copyOf
       /* int[] ret = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));*/
       //方法2：System.arraycopy
       /*int[] ret = new int[array.length];
       System.arraycopy(array,0,ret,0,array.length);
       System.out.println("System:"+Arrays.toString(ret));*/
       //方法1：for循环
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        System.out.println("for:"+Arrays.toString(ret));
    }
    //实现方法将数组以字符串的形式输出
    public static String myToString(int[] array1) {
        String ret = "[";
        for (int i = 0; i < array1.length; i++) {
            ret += array1[i];
            if(i < array1.length-1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
    public static void main11(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        System.out.println(myToString(array));
    }
    //数组作为参数返回
    public static int[] fac2() {
        int[] array = {1,2,3,4,5};
        return array;
    }
    public static void main10(String[] args) {
        int[] ret = fac2();
        System.out.println(Arrays.toString(ret));
    }
    //输入字符串数组
    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i] = scan.next();
        }
        System.out.println(Arrays.toString(str));
    }
    //输入整型数组
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
    }
    //null
    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5};
        array = null;
        System.out.println(array[0]);
        System.out.println(array.length);
    }
    //交换两个数字
    public static void swap1(int[] array1) {
        int tmp = array1[0];
        array1[0] = array1[1];
        array1[1] = tmp;
    }
    public static void main6(String[] args) {
        int[] array = {10,20};
        System.out.println(array[0]+" "+array[1]);
        swap1(array);
        System.out.println(array[0]+" "+array[1]);
    }
    public static void swap(int x,int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    public static void main5(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println(a+" "+b);
        swap(a,b);
        System.out.println(a+" "+b);
    }
    public static void fac(int a) {
        a = 888;
        System.out.println(a);
    }
    public static void print(int[] array1) {
        array1[0] = 999;
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+" ");
        }
        System.out.println();
    }
    //深拷贝、浅拷贝
    public static void main4(String[] args) {
        /*int a = 10;
        fac(a);
        System.out.println(a);*/
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        print(array);
        System.out.println("===========");
        System.out.println(Arrays.toString(array));
    }
    //改变数组中某个元素的值
    public static void main3(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(array1.length);
        System.out.println(array1[0]);
        array1[0] = 999;
        System.out.println(array1[0]);
    }
    //三种打印方式
    public static void main2(String[] args) {
        int[] array1 = new int[3];
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        int[] array3 = new int[] {1,2,3,4,5,6,7};
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+" ");
        }
        System.out.println();
        System.out.println("======for each==========");
        for (int x:array2) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("=======数组内容以字符串形式输出");
        System.out.println(Arrays.toString(array3));
    }
    //for循环实现打印
    public static int[] copyArray(int[] array) {
        int[] ret = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }
    public static void main0(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));
    }
}