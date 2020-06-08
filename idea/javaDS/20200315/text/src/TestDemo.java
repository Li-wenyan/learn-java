import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 数组的举例
 * User: GAOBO
 * Date: 2020-03-15
 * Time: 14:48
 */
public class TestDemo {

    public static void main(String[] args) {
        //不规则二维数组  可以手动指定列数
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5,6,7,8};
        System.out.println(Arrays.deepToString(array));
    }

    public static void main6(String[] args) {
        //规则：知道行且知道列
        int[][] array = new int[2][3];
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[][]{{1,2},{3,4},{5,6}};

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
        //自己用foreach   遍历二维数组

        System.out.println(Arrays.deepToString(array2));
    }





    public static void bubbleSort(int[] array) {

        boolean flg = false;
        //i是趟数  1 2 3 4         2 1 3 4
        for (int i = 0; i < array.length-1; i++) {
            flg = false;
            //因为不一定一开始就是有序的
            // 他可能在排序的过程当中的某一次
            //忽然有序了。
            for (int j = 0; j < array.length-1-i; j++) {//j < 3   j == 2
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }

        }
    }

    /**
     *  逆置
     * @param array
     */
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int tmp = array[left];
            array[left] =array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }


    public static void func(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                //偶数
                left++;
            }
            //left下标的值是奇数
            while (left < right && array[right] % 2 != 0) {
                //偶数
                right--;
            }
            //right下标的值是偶数
            int tmp = array[left];
            array[left] = array[right];
            array[right] =  tmp;
        }
    }

    public static void main5(String[] args) {
        int[] array = {1,4,3,2,8,7};
        func(array);
        System.out.println(Arrays.toString(array));
        //System.out.println(array);//地址的哈希值 也是唯一的
    }



    public static boolean isSorted(int[] array) {
        //1 2 3 4 5 6 7
        //0 1 2 3 4 5 6
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,61,7};
        System.out.println(isSorted(array));
    }




    //A OF B   -> B的A
    public static int maxOfArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    public static double avg(int[] array) {
        double sum = 0;
        for (int x:array) {
            sum += x;
        }
        return sum/array.length;
    }


    public static int findNum(int[] array,int num) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == num) {
                return i;//代表函数的结束
            }
        }
        //////////
        return -1;//因为数组是没有-1下标的。
    }

    public static int count = 0;//成员变量

    public static int binarySearch(int[] array,int key){
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            count++;
            int mid = (left+right)/2;
            if(array[mid] < key) {//10    30
                left = mid+1;
            }else if(array[mid] > key) {
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main2(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7};
        int[] array2 = {1,2,3,4,5,6,7};

        //两个数组当中的内容是否相同
        System.out.println(Arrays.equals(array1,array2));
        System.out.println(array1 == array2);
    }

    public static void main1(String[] args) {
        /*int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }*/
        int[] array = {1,2,31,4,15,6,7};
        Arrays.sort(array);//就会对数组进行排序
        System.out.println(Arrays.toString(array));
        int n = binarySearch(array,15);
        System.out.println(n);

        System.out.println(Arrays.binarySearch(array, -32));


        //System.out.println(count);
       //System.out.println(maxOfArray(array));
        //[from,to)-->一般在java当中看到的from...tom  范围：[ ) ctr+左键
       /* int[] ret = Arrays.copyOfRange(array,1,4);
        System.out.println(Arrays.toString(ret));*/
    }
}
