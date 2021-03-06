package web0607;

import java.util.Scanner;

public class ThreadDemo17 {
    public static void main(String[] args) {
        Object locker = new Object();
        Object locker2 = new Object();

        Thread t = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);

                synchronized (locker.getClass()) {
                    System.out.println("请输入一个数");
                    int num = scanner.nextInt();//用户如果不输入，就会一直阻塞在nextInt，这个锁就会被一直占有
                    System.out.println("num= " + num);
                }

            }
        };
        t.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while(true) {
                    synchronized (locker2) {
                        System.out.println("线程2获取到锁了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        t2.start();
    }
}
