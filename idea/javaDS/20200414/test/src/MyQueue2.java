public class MyQueue2 {
    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    //插入失败返回false
    public Boolean offer(int value) {
        if(size == array.length) {
            return false;
        }
        array[tail] = value;

        tail++;
        if (tail >= array.length) {
            tail = 0;
        }//                                       1
        //tail = tail % array.length;             2
        size++;
        return true;
    }
    public Integer poll(){
        if (size == 0) {
            return null;
        }
        int ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        while(true) {
            Integer cur = myQueue2.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
