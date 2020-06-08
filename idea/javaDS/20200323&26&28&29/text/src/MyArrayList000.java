//节点类
class Node0 {
    public int data;
    public Node0 next;
     public Node0(int data) {
         this.data = data;
         this.next = null;
     }


}
//单链表
public class MyArrayList000 {
    public Node0 head;
    public MyArrayList000() {
        this.head = null;
    }
    //找到index位置的前驱
    private Node0 findIndex(int index) {
        Node0 cur = this.head;
        int count = 0;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //找到关键字key的前驱
    private Node0  findPrev(int key) {
        Node0 prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //头插法
    public void addFirst(int data){
        Node0 node = new Node0(data);
        if(this.head == null) {
            //第一次插入节点
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node0 node = new Node0(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node0 cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;

    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法！");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        //1、让一个引用先走index-1步
        Node0 prev = findIndex(index);
        //2、
        Node0 node = new Node0(data);
        node.next = prev.next;
        prev.next = node;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node0 cur = this.head;
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
            this.head =this.head.next;
            return;
        }
        Node0 prev = findPrev(key);
        if(prev == null) {
            System.out.println("没有这个节点！");
            return;
        }
        Node0 del = prev.next;
        prev.next = del.next;


    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node0 prev = this.head;
        Node0 cur = this.head.next;
        while(cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;//prev = prev.next;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }



    }
    //得到单链表的长度
    public int size(){
        Node0 cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //
    public void display(){
        Node0 cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head = null;
    }
}
