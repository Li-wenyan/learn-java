package web0606;

public class Threaddemo5 {
    public static void main(String[] args) {
        Thread t = new Thread("这是一个线程的名字，可以起的很长") {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
    }
}
