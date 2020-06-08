import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5,6,7,8,9,0};
        System.out.println(Arrays.deepToString(array));
    }
    public static void main8(String[] args) {
        int[][] array = new int[2][3];
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==================");
        System.out.println(Arrays.deepToString(array2));
    }
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
    public static void func(int[] array1) {
        int left = 0;
        int right = array1.length-1;
        while(left < right) {
            while((left < right) && (array1[left]%2 == 0)) {
                left++;
            }
            while((left < right) && (array1[right]%2 != 0)) {
                right--;
            }
            int tmp = array1[left];
            array1[left] = array1[right];
            array1[right] = tmp;
        }
    }
    public static void reverse1(int[] array1) {
        int left = 0;
        int right = array1.length-1;
        while(left < right) {
            int tmp = array1[left];
            array1[left] = array1[right];
            array1[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main7(String[] args) {
        int[] array = {1,4,7,2,9,6};
        //func(array);
        //reverse1(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static boolean isSorted(int[] array1) {
        for (int i = 0; i < array1.length-1; i++) {
            if(array1[i] > array1[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main6(String[] args) {
        int[] array = {1,2,5,8,3,6,7,0};
        System.out.println(isSorted(array));
    }
    public static void main5(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};
        System.out.println(Arrays.equals(array1,array2));
        System.out.println(array1 == array2);
    }
    public static int count = 0;
    public static int binarySearch1(int[] array1,int n) {
        int left = 0;
        int right = array1.length-1;
        while(left <= right) {
            count++;
            int mid = (left+right)/2;
            if(array1[mid] < n) {
                left = mid+1;
            }else if(array1[mid] > n) {
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int maxOfArray(int[] array1) {
        int max = array1[0];
        for (int i = 0; i < array1.length; i++) {
            if(array1[i] > max) {
                max = array1[i];
            }
        }
        return max;
    }
    public static int findNum(int[] array1,int num) {
        for (int i = 0; i < array1.length; i++) {
            if(array1[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public static double avg(int[] array1) {
        double sum = 0;
        for (int x:array1) {
            sum += x;
        }
        return sum/array1.length;
    }
    public static void main4(String[] args) {
       /* int[] array1 = new int[1000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
        }*/
        int[] array = {1,4,8,3,5,9,2};
        //Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        /*int n = binarySearch1(array1,888);
        System.out.println(n);*/
        //System.out.println(Arrays.binarySearch(array,6));
        //System.out.println(count);
        //System.out.println(maxOfArray(array));
        /*int[] ret = Arrays.copyOfRange(array,2,5);
        System.out.println(Arrays.toString(ret));*/
        //System.out.println(findNum(array,5));
        System.out.println(avg(array));
    }
    public static void reverse(int[] array1) {
        int left = 0;
        int right = array1.length-1;
       while(left <= right) {
            int tmp = array1[left];
            array1[left] = array1[right];
            array1[right] = tmp;
            left ++;
            right--;
        }
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
    public static int binarySearch(int[] array1,int n) {
        int left = 0;
        int right = array1.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(array1[mid] < n) {
                left = mid + 1;
            }else if(array1[mid] > n) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int ret = binarySearch(array,3);
        System.out.println(ret);
    }
}
