import java.util.Arrays;

class Books {
    private String name;
    private String author;
    private int price;
    private static int count;
    static {
        count=199;
        System.out.println("静态代码块");
    }
    {
        this.name = "天下";
        this.author = "张杰";
        this.price = 1220;
        count = 200;
        System.out.println("实例代码块/构造代码块");
    }
    public Books() {
        System.out.println("book");
    }
    public Books(String name,String author,int price) {
        this.name = name;
        this.author = author;
        this.price = price;
        System.out.println("book(String,String,int)");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void show() {
        System.out.println("书名： "+name+",作者："+author+",价格："+price);
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
public class Practice {
    public static void func(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    public static int sum (int a,int b) {
        return a+b;
    }
    public static int sum(int a,int b,int c) {
        return a+b+c;
    }
    public static int sum(int...array) {
        int ret = 0;
        for (int x:array) {
            ret += x;
        }
        return ret;
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(sum(array));
        System.out.println(sum(new int[]{1,2,3,4,5,6}));
        System.out.println(sum(1,2,3,4,5,6,7));
    }

    public static void main3(String[] args) {
        Books book = new Books("西游记","吴承恩",88);
        System.out.println("======================");
        book.show();
        System.out.println("=====================");
        System.out.println(book);//toString方法
        System.out.println("==========================");
        new Books().show();
        System.out.println("=====================");
        String s = new Books().toString();
        System.out.println(s);
    }

    public static void main2(String[] args) {
        Books book = new Books();
        System.out.println(book.getName());
        System.out.println("===============");
        Books book2 = new Books();
    }

    public static void main(String[] args) {
        Books book = new Books();
        book.setName("李文艳");
        System.out.println(book.getName());
        Books book2 = new Books();
        Books book3 = new Books();
        Books book4 = new Books();
    }
}
