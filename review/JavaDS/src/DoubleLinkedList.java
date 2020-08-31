/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-31
 * Time:10:30
 */

class DoubleNode{
    public int data;
    public DoubleNode next;
    public DoubleNode prev;
    public DoubleNode(int data) {
        this.data = data;
    }
}
public class DoubleLinkedList {
    public DoubleNode head;
    public DoubleNode last;
    //头插法
    public void addFirst(int data){
        DoubleNode node = new DoubleNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        DoubleNode node = new DoubleNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()) {
            throw new RuntimeException("输入的参数有误！");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        DoubleNode node = new DoubleNode(data);
        DoubleNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }

    public int size() {
        DoubleNode cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        DoubleNode cur = this.head;
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
            this.head.prev = null;
            return;
        }
        DoubleNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                cur.prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }else {
                    this.last = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (this.head.data == key) {
            this.head = this.head.next;
            this.head.prev = null;
        }
        DoubleNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                cur.prev.next = cur.next;
                if (cur .next != null) {
                    cur.next.prev = cur.prev;
                }else {
                    this.last = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    public void display(){
        DoubleNode cur = this.head;
        while (cur != null) {
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
