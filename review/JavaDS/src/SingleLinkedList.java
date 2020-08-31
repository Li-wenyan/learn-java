/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-31
 * Time:9:33
 */

class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SingleLinkedList {
    public Node head;
    public SingleLinkedList() {
        this.head = null;
    }
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    public Node Preindex(int index) {
        int count = 0;
        Node cur = this.head;
        while(count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    public int size() {
        Node cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        if (index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法！");
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        Node preFind = Preindex(index);
        node.next = preFind.next;
        preFind.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node preFind = PreFind(key);
        if (preFind == null) {
            System.out.println("没有这个节点");
            return;
        }
        preFind.next = preFind.next.next;
    }

    private Node PreFind(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
    }
    //单链表的反转
    public Node reverseList(){
        Node newHead = null;
        Node cur = this.head;
        Node prev = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //返回中间节点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回倒数第k个节点
    public Node findKthToTail1(int k){
        Node prev = this.head;
        Node cur = this.head;
        if (k <= 0 || this.head == null) {
            System.out.println("bug");
            return null;
        }
        while (k-1 > 0) {
            if (prev.next != null) {
                prev = prev.next;
                k--;
            }else {
                System.out.println("没有该节点！");
                return null;
            }
        }
        while (prev.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        return cur;
    }
    //给一个基准x，把小于x的数放在左边，大于等于x的数放在右边，不改变数据顺序
    //例如1 4 8 3 6   x为5   则输出  1 4 3 8 6
    public Node partition(int x){
        Node a1 = null;
        Node a2 = null;
        Node b1 = null;
        Node b2 = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (a1 == null) {
                    a1 = cur;
                    a2 = cur;
                }else {
                    a2.next = cur;
                    a2 = cur;
                }
            }else {
                if (b1 == null) {
                    b1 = cur;
                    b2 = cur;
                }else {
                    b2.next = cur;
                    b2 = cur;
                }
            }
            cur = cur.next;
        }
        if (a1 == null) {
            return b1;
        }
        a2.next = b1;
        if (b1 != null) {
            b2.next = null;
        }
        return a1;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node deleteDuplication(){
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmp = node;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome(){
        //找到中间节点
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //将中间节点的后半部分反转
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //此时后半部分的头结点为slow
        //head往后走，slow往前走，直到相遇
        while (this.head != slow) {
            if(this.head.data != slow.data) {
                return false;
            }
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }
    //给定一个链表，判断链表中是否有环
    public boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
    //相遇点
    public Node meet(){
        Node fast = this.head;
        Node slow = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        return fast;
    }
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public Node detectCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public void display(){
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head = null;
    }
}
