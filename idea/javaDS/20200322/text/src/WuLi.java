import java.util.Arrays;

class ArrayList {
    private int[] elem;
    private int usedSize;

    private static int FULL_SIZE = 3;


    public ArrayList() {
        this.elem = new int[FULL_SIZE];
        this.usedSize = 0;
    }
    public Boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
            //throw new RuntimeException("数组满了！");
        }
        return false;

    }
    public void isPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            //return false;
            throw new ArrayIndexOutOfBoundsException("pos位置不合法！");
        }
    }
    public Boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
    }
    public void grow() {
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }
    public void print() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    public void add(int pos,int data){
        if(isFull()) {
            System.out.println("顺序表是满的！");
            //return;
            grow();
        }
        //isFull();
        isPos(pos);
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //判断是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
          if(isEmpty()) {
              return -1;
          }
          isPos(pos);
          return this.elem[pos];
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if(index == -1) {
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

