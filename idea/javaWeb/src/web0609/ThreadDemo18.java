package web0609;

import java.util.Scanner;

public class ThreadDemo18 {
    static class Counter {
        public volatile int flag = 0;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(counter.flag == 0) {
                    //System.out.println("循环1");
                }
                System.out.println("循环结束！");
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数");
                counter.flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}
