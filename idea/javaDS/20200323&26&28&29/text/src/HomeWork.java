class NodeHomeWork {
    public int data;
    public NodeHomeWork prev;
    public NodeHomeWork next;
    public NodeHomeWork(int data) {
        this.data = data;
    }
}
public class HomeWork {
    public NodeHomeWork head;
    public NodeHomeWork last;
    public HomeWork() {
        this.head = new NodeHomeWork(-1);
        this.last = this.head;
    }
    //头插法
    public void addFirst(int data){
        NodeHomeWork node = new NodeHomeWork(data);
        if(this.head.next == null) {
            node.prev = this.head;
            this.head.next = node;
            this.last = this.last.next;
            return;
        }
        NodeHomeWork cur = this.head.next;
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }
    //尾插法
    public void addLast(int data){
        NodeHomeWork node = new NodeHomeWork(data);
        node.prev = this.last;
        this.last.next = node;
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){

        if(index < 0 || index > size()) {
            throw new RuntimeException("位置不合法！");
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        NodeHomeWork cur = this.head.next;
        while (index > 0) {
             cur = cur.next;
             index--;
        }
        NodeHomeWork node = new NodeHomeWork(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        NodeHomeWork cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                return  true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        NodeHomeWork cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                cur.prev.next = cur.next;
                if(cur.next != null) {
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
        NodeHomeWork cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                cur.prev.next = cur.next;
                if(cur.next != null) {
                    cur.next.prev = cur.prev;
                }else {
                    this.last = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        NodeHomeWork cur = this.head.next;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        NodeHomeWork cur = this.head.next;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head.next = null;
        this.last = null;
    }

}
