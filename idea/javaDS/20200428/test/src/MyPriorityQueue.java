public class MyPriorityQueue {
    private int[] array = new int[100];//暂时不考虑扩容
    private int size = 0;//[0,size) 表示有效元素区间
    public void offer(int x) {
        //1,先把x放到数组元素的末尾
        array[size] = x;
        size++;
        //2,把x进行向上调整即可
        //第一个参数表示用来承载堆 的数组
        //第二个参数表示数组中有效元素的个数
        //第三个参数表示从哪个位置进行向上调整
        shiftUp(array,size,size-1);
    }

    private void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        //如果child为0，说明child就已经是根节点了，根节点没有父节点，调整到这里就到顶了
        while(child > 0) {
            //比较当前child和parent之间的大小关系，看看是否符合大堆
            if(array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    public Integer poll() {
        if(size <= 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size-1];
        size--;
        shiftDown(array,size,0);

        return ret;
    }
    public void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while(child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;

        }
    }
    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[0];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }

}
