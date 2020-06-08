import java.util.Arrays;

public class Sort {
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //此时已经借助bound把数组分成两个区间了
            // [0,bound)已排序区间
            //[bound,size)待排序区间
            //接下来就需要在待排序区间中找到最小值，放到bound位置上
            for (int cur = bound; cur < array.length; cur++) {
                if(array[bound] > array[cur]) {
                    //以bound位置的元素作为擂台
                    //拿当前元素和擂台上的元素进行pk
                    //pk赢了就进行交换，当前是升序排序，谁小谁就赢
                    swap(array, bound, cur);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void heapSort(int[] array) {
        //1.先建立堆
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            //2.交换堆顶元素和堆中的最后一个元素
            swap(array, 0, heapSize - 1);
            //3.把最后一个元素从堆中删除掉
            heapSize--;
            //4.针对当前的堆，从根节点开始进行向下调整
            shiftDown(array,heapSize,0);
        }

    }

    private static void createHeap(int[] array) {
        //从最后一个非叶子节点出发，从后往前遍历，以此进行向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            //当前是建立大堆，找出左右子树中的大堆，然后再和根节点比较
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[parent] < array[child]) {
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    public static void bubbleSort(int[] array) {
        //从后往前遍历，每次找最小元素放前面
        //[0,bound)已排序区间
        //[bound,size)待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            //接下来就需要在待排序区间中找到当前的最小值
            //具体的找发就是，比较相邻元素，看是否符号升序要求，不符合就交换元素
            for (int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur -1] > array[cur]) {
                    swap(array, cur, cur - 1);
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }
    //[left,right]表示针对当前的范围进行快速排序
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //区间中有0个元素或者一个元素
            return;
        }
        //返回值表示整理之后，基准值所处在的位置
        int index = partition(array, left, right);
        //[left,index - 1]
        //[index + 1, right]
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array, index + 1,right);
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

    public static void main(String[] args) {
        int[] array = {9,5,2,7,6,3,8};
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
