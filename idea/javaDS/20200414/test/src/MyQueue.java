//链表实现队列（简单点）

public class MyQueue {
    //链表尾部作为队尾（插入），链表头部作为队首（删除）
    //tail指向链表的尾部
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head = new Node(-1);
    private Node tail = head;
    private int size;//队列中的元素个数
    public void offer (int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = tail.next;
    }
    public Integer poll() {
        if (head.next == null) {
            return null;
        }
        Node toDelete = head.next;
        head.next = toDelete.next;
        //不要忘了更新tail
        if(head.next == null) {
            tail = head;
        }
        return toDelete.val;
    }
    public Integer peek() {
        if (head.next == null) {
            return null;
        }
        return head.next.val;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        while(true) {
            Integer cur = myQueue.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);

        }

    }
}
