/*
import java.util.Arrays;

public class Practice {
    public int[] elem;//null
    public int usedSize;//0

    //设置默认容量
    public static final int DEFAULT_SIZE = 10;

    public Practice() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void add(int pos,int data) {
        if(isFull()) {
            return;
        }
        if(pos< 0 || pos > this.usedSize) {
            return;
        }
        for(int i = this.usedSize-1; i >= pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        isFull();
        for (int i =0 ; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i =0 ; i < this.usedSize-1; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < this.usedSize && pos > 0) {
            return this.elem[pos];
        }
        return -1;
    }
    public void remove(int key) {
        if(this.search(key) == -1) {
            return;
        }
        int index = getPos(key);
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    public static void main(String[] args) {
        Practice array = new Practice();
        array.elem[0] = 1;
        array.elem[1] = 2;
        array.elem[2] = 3;
        array.elem[3] = 4;
        array.elem[4] = 5;
        array.add(3,8);
        System.out.println(Arrays.toString(array.elem));
        */
/*array.contains(3);
        array.search(3);
        array.getPos(3);*//*

        array.remove(3);
        System.out.println(Arrays.toString(array.elem));
        System.out.println(array.contains(3)+" "+array.search(3)+" "+array.getPos(3));
    }
}





*/
public class Practice {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0,10);
        arrayList.add(1,20);
        arrayList.add(2,30);
        arrayList.print();
        System.out.println(arrayList.contains(20));
        System.out.println(arrayList.search(20));
        System.out.println(arrayList.getPos(1));
        arrayList.remove(30);
        arrayList.print();
        System.out.println(arrayList.size());
        System.out.println("=================================");
        arrayList.clear();
        arrayList.print();
        /*arrayList.add(3,40);
        arrayList.print();*/
    }
    public int size() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public Boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.date == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
