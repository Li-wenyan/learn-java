import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {
    //1.实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型)
    public static double avg(int[] array1) {
        double average = 0;
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i];
        }
        average = sum/array1.length;
        return average;
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5};
        double ret = avg(array);
        System.out.println(ret);
    }
    //2.实现一个方法 sum, 以数组为参数, 求数组所有元素之和
    public static int sum(int[] array1) {
        int sumAdd = 0;
        for (int i = 0; i < array1.length; i++) {
            sumAdd += array1[i];
        }
        return sumAdd;
    }
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        int ret = sum(array);
        System.out.println(ret);
    }
    //3.实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static int[] transform(int[] array1) {
        int[] ret1 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            ret1[i] = array1[i]*2;
        }
        return ret1;
    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        int[] ret = transform(array);
        System.out.println(Arrays.toString(ret));
    }
    //4.实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
    public static void printArray(int[] array1) {
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+" ");
        }
    }
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        printArray(array);
    }
    //5.创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }
}
