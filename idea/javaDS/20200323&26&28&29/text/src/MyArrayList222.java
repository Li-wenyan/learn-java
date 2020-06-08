class Node2 {
    public int data;
    public Node2 next;
    public Node2(int data) {
        this.data = data;
    }
 }
public class MyArrayList222 {
    private Node2 head;
    public MyArrayList222() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        Node2 cur = new Node2(data);
        if(this.head == null) {
            this.head = cur;
            return;
        }
        cur.next = this.head;
        this.head = cur;
    }
    //尾插法
    public void addLast(int data){
        Node2 node2 = new Node2(data);
        if(this.head == null) {
            this.head = node2;
            return;
        }
        Node2 cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node2;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("位置不合法！");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        //先走index-1步
        Node2 prev = findIndex(index);

        Node2 node2 = new Node2(data);
        node2.next = prev.next;
        prev.next = node2;

    }
    public Node2 findIndex(int index) {
        Node2 cur = this.head;
        int count = 0;
        while(count < index-1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node2 cur = this.head;
        while(cur!= null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node2 prev = findKey(key);
        if(prev == null) {
            System.out.println("没找到！");
            return;
        }
        Node2 cur = prev.next;
        prev.next = cur.next;
    }
    public Node2 findKey(int key) {
        Node2 cur = this.head;
        while(cur != null) {
            if(cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node2 cur = this.head.next;
        Node2 prev = this.head;
        while(cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size(){
       int count = 0;
       Node2 cur = this.head;
       while(cur != null) {
           count++;
           cur = cur.next;
       }
       return count;
    }
    public void display(){
        Node2 cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(Node2 newHead){
        Node2 cur = newHead;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        //this.head = null;
        while (this.head.next != null) {
            Node2 del = this.head.next;
            this.head.next = del.next;
        }
        this.head = null;
    }
    //反转一个单链表
    public Node2 reverseList() {
        Node2 prev = null;
        Node2 cur = this.head;

        Node2 newHead = null;
        while(cur != null) {
            Node2 curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }

            cur.next = prev;
            prev = cur;
            cur = curNext;


        }
        return newHead;
    }
    //返回链表的中间结点
    public Node2 middleNode() {
        Node2 fast = this.head;
        Node2 slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //输出该链表中倒数第k个结点
    public Node2 findKthNode(int k) {
        if(k <= 0 || this.head == null) {
            System.out.println("出错了！");
            return null;
        }
        Node2 fast = this.head;
        Node2 slow = this.head;

        for (int i = 1; i < k; i++) {
            if(fast.next != null) {
                fast = fast.next;
            }else {
                return null;
            }
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node2 partition(int x){
        Node2 bs = null;
        Node2 be = null;
        Node2 as = null;
        Node2 ae = null;
        Node2 cur = this.head;
        while(cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }

        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }

        return bs;
    }



}
