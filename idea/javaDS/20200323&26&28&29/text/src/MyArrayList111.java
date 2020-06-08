class Node1 {
    public int data;
    public Node1 next;
    public Node1(int data) {
        this.data = data;
    }
}
public class MyArrayList111 {
    public Node1 head;
    public MyArrayList111() {
        this.head = null;
    }
    private Node1 findIndex(int index) {
        int count = 0;
        Node1 cur = this.head;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    private Node1 findPrev(int key) {
        Node1 cur = this.head;
        while(cur.next != null) {
            if(cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //头插法
    public void addFirst(int data) {
        Node1 node = new Node1(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node1 node = new Node1(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node1 cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        Node1 node = new Node1(data);
        if(index < 0 || index > size()) {
            System.out.println("位置不合法！");
            return;
        }
        if(index == 0) {
            addFirst(data);
        }
        if(index == size()) {
            addLast(data);
        }
        Node1 prev = findIndex(index);
        node.next = prev.next;
        prev.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node1 cur = this.head;
        while(cur != null) {
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
        Node1 prev = findPrev(key);
        if(prev == null) {
            System.out.println("没找到关键字！");
            return;
        }
        Node1 cur = prev.next;
        prev.next = cur.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node1 prev = this.head;
        Node1 cur = prev.next;
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
        Node1 cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;

    }
    public void display(){
        Node1 cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(Node1 newHead){
        Node1 cur = newHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){

        //this.head = null;

        while(this.head != null) {
            Node1 del = this.head.next;
            this.head.next = del.next;
        }
        this.head = null;
    }
    //单链表的反转
    public Node1 reverseList() {
        Node1 cur = this.head;
        Node1 prev = null;
        Node1 newHead = null;
        while(cur != null) {
            Node1 curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //返回中间节点
    public Node1 middleNode() {
        Node1 fast = this.head;
        Node1 slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回倒数第k个节点
    public Node1 findKthToTail1(int k) {
        Node1 fast = this.head;
        Node1 slow = this.head;
        if(k <= 0 || this.head == null) {
            System.out.println("bug");
            return null;
        }
        //1、让fast先走k-1步
        /*for (int i = 1; i < k; i++) {
            fast = fast.next;
        }*/
        while(k-1 > 0) {

            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有改节点！");
                return null;
            }
        }
        //2、让两个引用 一起走  直到 fast.next == null
        // slow 所指的位置就是倒数第K个节点
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //给一个基准x，把小于x的数放在左边，大于等于x的数放在右边，不改变数据顺序
    //例如1 4 8 3 6   x为5   则输出  1 4 3 8 6
    public Node1 partition(int x) {
        Node1 bs = null;
        Node1 be = null;
        Node1 as = null;
        Node1 ae = null;
        Node1 cur = this.head;
        while(cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    //第一个线段的第一次插入
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
        //第一个段没有数据，只能返回第二个段
        if(bs == null) {
            return as;
        }
        //代码能执行到这里，说明bs != null 那么把两个段拼接起来
        be.next = as;
        //只要第二个段不为空
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node1 deleteDuplication() {
        Node1 node1 = new Node1(-1);
        Node1 cur = this.head;
        Node1 tmp = node1;
        while(cur != null) {

            if(cur.next != null && cur.data == cur.next.data) {
                while(cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //尾巴节点也是重复的，就把原来的null也删了
        tmp.next = null;
        return node1.next;

    }
    //链表的回文结构
    public boolean chkPalindrome() {
        //1,先找到中间节点
        Node1 fist = this.head;
        Node1 slow = this.head;
        while(fist != null && fist.next != null ) {
            fist = fist.next.next;
            slow = slow.next;
        }
        //此时已找到中间节点slow


        //2，中间节点之后的局部反转
        Node1 cur = slow.next;
        while(cur != null) {
            Node1 curNext1 = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext1;
        }
        //此时slow指向单链表的最后一个节点
        //3,一个从头开始走，一个从尾巴开始走，知道相遇
        while(slow != this.head) {
            if(slow.data != this.head.data) {
                return false;
            }
            if(this.head.next == slow ) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }
    public void createLoop() {
        Node1 cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }
    //给定一个链表，判断链表中是否有环
    public boolean hasCycle() {
        Node1 fast = this.head;
        Node1 slow = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
    //相遇点
    public Node1 meet() {

        Node1 fast = this.head;
        Node1 slow = this.head;

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
    public Node1 detectCycle() {
        Node1 fast = this.head;
        Node1 slow = this.head;

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
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }








}
