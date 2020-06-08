//顺序表实现栈
public class MyStack {

    private int[] array = new int[100];
    //[0,size)区间中的元素是栈中的有效元素
    //0号元素相当于栈底，size-1相当于栈顶
    private int size = 0;
    public void push(int value) {
       //把value放到数组末尾 ,没有考虑扩容
        array[size] = value;
        size++;
    }
    public Integer pop() {
        if (size <= 0) {
            //此处的失败有两种方式：返回非法值和抛出异常
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }
    public Integer peek() {
        if (size <= 0) {
            //此处的失败有两种方式：返回非法值和抛出异常
            return null;
        }
        return array[size-1];
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        /*Integer cur =null;
        while((cur = myStack.pop())!= null) {
            System.out.println(cur);
        }*/
        while(true) {
            Integer cur = myStack.pop();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}

