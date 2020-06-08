import java.util.Stack;
//借助两个栈实现一个队列
public class MyQueue {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public MyQueue() {

    }
    public void push(int x) {
        while (!B.isEmpty()) {
            Integer cur = B.pop();
            A.push(cur);
        }
        A.push(x);
    }
    public int pop() {
        if (Empty()) {
            return 0;
        }
        while(!A.isEmpty()) {
            Integer cur = A.pop();
            B.push(cur);
        }
        return B.pop();

    }
    public int peek() {
        if (Empty()) {
            return 0;
        }
        while(!A.isEmpty()) {
            Integer cur = A.pop();
            B.push(cur);
        }
        return B.peek();
    }
    public boolean Empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
