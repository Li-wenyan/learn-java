import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//标准库中的Stack和Queue
public class TestStackAndQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);

    }
    public static void main1(String[] args) {
        //Stack 是一个类  继承自Vector,
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //标准库中的Stack如果针对空栈进行pop或者peek就会抛出一个空栈异常，
        while(!stack.empty()) {
            Integer cur = stack.pop();
            System.out.println(cur);
        }
        //Stack 是一个类  继承自Vector,所以Stack可以执行Vector的所有操作，
        // 并没起到限制灵活性的效果，反而增加了代码的复杂程度，实际使用的时候，尽量避免使用这些本来不该有的操作

        /*stack.add(1,100);
        stack.get(0);
        stack.contains(2);*/



        //Queue是一个接口,只能实例化一个实现Queue接口的类,
        /*Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }*/
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        while(true) {
            Integer cur = queue.remove();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
