import java.util.LinkedList;
import java.util.Queue;

//借助两个队列实现一个栈
public class MyStack {
    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();
    public  MyStack() {

    }
    public  void push(int x) {
        A.offer(x);
    }
    public int pop() {
        //如果栈为空
        if (empty()) {
            return  0;
        }
        while (A.size() > 1) {
            Integer cur = A.poll();
            B.offer(cur);
        }
        swapAB();
        return A.poll();

    }
    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }
    public int top() {
        if (empty()) {
            return  0;
        }
        while (A.size() > 1) {
            Integer cur = A.poll();
            B.offer(cur);
        }
        int cur = A.poll();
        B.offer(cur);
        swapAB();
        return cur;
    }
    public boolean empty() {
        if (A.isEmpty() && B.isEmpty()) {
            return  true;
        }
        return  false;
    }
}
