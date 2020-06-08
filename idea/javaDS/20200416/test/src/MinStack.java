import java.util.Stack;

public class MinStack {
    //A中是按照正常的栈存储元素，
    // B中每个元素都是A中对应元素个数情况下的最小值
    //A和B中的元素要同步变化
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public MinStack() {

    }
    public void pop(int x) {
        A.push(x);
        //判断一下B中的元素要放啥
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();//取出上一轮的最小值
        if(x < min) {
            //新插入的元素比原来的最小值还小，把x入B栈
            min = x;
        }
        B.push(min);

    }
    public void pop() {
        if (A.empty()) {
            return;
        }
        A.pop();
        B.pop();

    }
    public int top() {
        if(A.empty()) {
            return 0;
        }
        return A.peek();
    }
    public int getMin() {
        if (B.empty()) {
            return 0;
        }
        return B.peek();
    }
}
