import java.util.Arrays;

public class HomeWork {
    //1.给定一个整型数组, 实现冒泡排序(升序排序)
    public static void bubbleSort(int[] array1) {
        for (int i = 0; i < array1.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < array1.length-1-i; j++) {
                if(array1[j] > array1[j+1]) {
                    int tmp = array1[j];
                    array1[j] = array1[j+1];
                    array1[j+1] = tmp;
                    flag = true;
                }
            }
            if(flag == false) {
                return;
            }
        }
    }
    public static void main1(String[] args) {
        int[] array = {4,2,8,5,0,6,1,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    //2.给定一个整型数组, 判定数组是否有序（递增）
    public static boolean isSort(int[] array1) {
        for (int i = 0; i < array1.length-1; i++) {
            if(array1[i] > array1[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,3,2,1,0};
        System.out.println(isSort(array));
    }
    //3.给定一个有序整型数组, 实现二分查找
    public static int binarySearch(int[] array1,int num) {
        int left = 0;
        int right = array1.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(array1[mid] < num) {
                left = mid+1;
            }else if(array1[mid] > num) {
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int n = binarySearch(array,8);
        System.out.println(n);
    }
    //4.实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
    public static int[] copyOf(int[] array1) {
        int[] tmp = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            tmp[i] = array1[i];
        }
        return tmp;
    }
    public static void main4(String[] args) {
        int[] array = {2,5,9,1,7,4};
        int[] ret = copyOf(array);
        System.out.println(Arrays.toString(ret));
    }
    //5.实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
    public static String toString(int[] array1) {
        String tmp = "[";
        for (int i = 0; i < array1.length; i++) {
            tmp += array1[i];
            if(i < array1.length-1)
            tmp += ", ";
        }
        tmp += "]";
        return tmp;
    }
    public static void main(String[] args) {
        int[] array = {3,6,9};
        String ret = toString(array);
        System.out.println(ret);
    }

}
