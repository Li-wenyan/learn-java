package web0607;

public class ThreadDemo16 {
    static class Test {
        public void method () {
            synchronized (this) {//对t进行加锁
                System.out.println("hehe");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
