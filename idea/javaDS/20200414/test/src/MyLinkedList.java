class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = null;
    }
    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。
    // 插入后，新节点将成为链表的第一个节点
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，
    // 则不会插入节点。如果index小于0，则在头部插入节点
    public void addAtIndex(int index, int val) {
        if (index > size() || this.head == null) {
            throw new RuntimeException("下标越界");
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size()) {
            addAtTail(val);
            return;
        }
        //能走到这里，说明下标合法
        Node prev = findPrev(index);
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;

    }
    public Node findPrev (int index) {
        int count = 0;
        //在此不用判断下标
        /*if (this.head == null || index < 0 || index > size()-1) {
            throw new RuntimeException("下标越界");
        }*/

        Node cur = this.head;
        /*while(cur.next != null) {
            count++;
            if (count == index) {
                return cur;
            }

            cur = cur.next;
        }
        return null;*/
        while(count < index -1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    public int size() {
        /*if (this.head == null) {
            return 0;
        }*/
        int size = 0;
        Node cur = this.head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点
    public Node deleteIndex(int index) {
        if(this.head == null || index < 0 || index > size()-1) {
            throw new RuntimeException("删除失败");
        }
        if (index == 0) {
            Node ret = this.head;
            this.head = this.head.next;
            return ret;
        }
        int count = 0;
        Node cur = this.head;
        Node prev = findPrev(index);
        while(cur != null) {
            if (count == index) {
                prev.next = cur.next;
                return cur;
            }
            count++;
            cur = cur.next;
        }
        return null;

    }
    public void print() {
        /*if (this.head == null) {
            return;
        }*/
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val +" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public int get(int index) {
        if (this.head == null || index < 0 || index > size()) {
            return -1;
        }
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            if (index == count) {
                return cur.val;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }
}
