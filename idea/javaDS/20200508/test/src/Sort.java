import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Sort {
    //非递归快速排序，参考非递归前向遍历二叉树
    public static void quickSortByLoop(int[] array) {
        //栈中保存的元素相当于当前要进行partition操作的范围下标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length -1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                //区间为空或者区间中只有一个元素，此时不需要进行partition操作
                continue;
            }
            int index = partition(array,left,right);
            //把右子树入栈[index + 1,right]
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈[left,index-1]
            stack.push(left);
            stack.push(index - 1);
        }
    }
    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            //1，先从左往右找到一个大于基准值的元素
            while(i < j && array[i] <= baseValue) {
                i++;
            }
            //此时i指向的位置，要么和j重合，要么就是一个比基准值大的元素
            //2,再从右往左找到一个小于基准值的元素
            while(i <j && array[j] >= baseValue) {
                j--;
            }
            //此时j指向的元素，要么和i重合，要么就是比基准值小的元素
            //3，交换i和j的值
            if(i < j) {
                swap(array,i,j);
            }
        }
        //当整个循环结束，i和j就重合了，接下来就把基准值位置的元素交换到i/j重合位置上
        //此时i和j重合位置的元素一定是大于基准值
        swap(array, i, right);
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void mergeSort(int[] array) {
        //[0,length)
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        //[left,right)
        if(right - left  <= 1) {
            //当前区间中有0个或者1个元素，不需要进行排序
            return;
        }
        //System.out.println("left: " + left + "right: " + right);
        //针对[left,right)区间，分为对等的两个区间
        int mid = (left + right) / 2;
        //两个区间分别就是
        //[left,mid)
        //[mid,right)
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        //通过上面的递归，认为这两个区间都被排好序了，接下来就可以进行合并了
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //当前有两个有序数组
        //[left,mid)
        //[mid,right]
        int cur1 = left;
        int cur2 = mid;
        //临时空间需要能容纳下两个数组合并后的结果
        int[] output = new int[right-left];
        int outputIndex = 0;//当前output中被插入了几个元素
        while(cur1 <mid && cur2 <right) {
            //此处必须是<=,不能是<,否则不能保证稳定性
            if(array[cur1] <= array[cur2]) {
                //把cur1位置的元素插入到output中
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while(cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while(cur2 < right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        //最后一步要把数据从临时空间中拷贝回原来的数组中
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }

    //非递归归并排序
    public static void mergeSortByLoop(int[] array) {
        //gap表示当前每个组中的元素个数
        for (int gap = 0; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2*gap) {
                //每次执行一遍这个循环体，相当于把两个长度为gap的相邻组进行了合并
                //[i,i+gap)
                //[i + gap,i + 2 * gap)
                int left = i;
                int mid = i + gap;
                int right = i + 2 * gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if(right > array.length) {
                    right = array.length;
                }
                merge(array, left, mid, right);
            }
        }
    }
    public static void main(String[] args) {
       /* ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(6);
        arrayList.add(3);
        arrayList.add(8);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        int[] array = {9,5,2,7,6,3,8};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));*/
       int[] array = {9, 5, 2, 7, 3, 6, 8};
       //quickSortByLoop(array);
        mergeSort(array);
       System.out.println(Arrays.toString(array));
    }
}
