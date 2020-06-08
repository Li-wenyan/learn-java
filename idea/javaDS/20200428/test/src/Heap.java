import java.util.Arrays;

public class Heap {
    //向下调整
    //堆是一个完全二叉树，通常使用数组来表示,size：数组中哪些元素是堆【0，size），index表示从哪个下标出发进行调整
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        //根据父节点下边，先找到左子树的下标
        int child = 2 * parent + 1;
        //循环条件的意思是，如果child对应的节点存在，就继续调整
        // 如果超过size，说明当前的parent已经是叶子节点了，没有子节点了
        while(child < size) {
            //再去找一下右子树对应的节点
            if(child + 1 < size && array[child +1] > array[child]) {
                child = child + 1;
            }
            //child经过上面的条件已经不知道指向的是parent的左子树还是右子树了，但是一定是左右子树中较大的那个

            //接下来就可以拿刚才child位置的元素和parent进行对比对比了，看看是否符合大堆的要求
            //如果不符合大堆（child位置的元素比parent位置的元素大），就交换child和parent位置的元素
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                //当前child和parent的关系已经符合大堆的要求了，说明就调整完毕了
                break;
            }
            //下次循环之前，需要先更新parent和child
            parent = child;
            child = parent *2 + 1;

        }
    }
    //建堆
    public static void createHeap(int[] array, int size) {
        //从后往前遍历，从最后一个非叶子节点出发，依次进行向下调整
        //size-1 得到最后一个元素的下标，再次-1/2是为了根据最后一个节点的下标找打该节点对应的父节点的下标
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,6,3,8};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
