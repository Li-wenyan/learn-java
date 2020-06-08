class ListNode1 {
    public int data;
    public ListNode1 prev;
    public ListNode1 next;
    public ListNode1(int data) {
        this.data = data;
    }
}


public class DoubleLinedList {
    public ListNode1 head;//头
    public ListNode1 last;//尾
    //头插法
    public void addFirst(int data) {
        ListNode1 node = new ListNode1(data);
        if(this.head == null) {
            this.head =node;
            this.last =node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        ListNode1 node = new ListNode1(data);
        if(this.head == null) {
            this.head =node;
            this.last =node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode1 node = new ListNode1(data);
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
        ListNode1 cur = this.head;
        while(index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode1 cur = this.head;
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
        //删除第一次出现关键字为key的节点

        ListNode1 cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                //当前cur是不是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
                return ;
            }else {
                cur = cur.next;
            }
        }


    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode1 cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                //当前cur是不是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }

            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode1 cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        ListNode1 cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head = null;
        this.last = null;
    }

}
