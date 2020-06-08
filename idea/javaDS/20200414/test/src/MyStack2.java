//链表实现栈

public class MyStack2 {
    //用链表头部表示栈顶，链表尾部表示栈底
    static class Node {
        public int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    Node head = new Node(-1);
    public void push(int value) {
        //头插
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
    }
    public Integer pop() {
        //头删
        Node toDelete = head.next;
        if (toDelete == null) {
            return null;
        }
        head.next = toDelete.next;
        return toDelete.val;
    }
    public Integer peek() {
        if(head.next == null) {
            return null;
        }
        return head.next.val;
    }

}
