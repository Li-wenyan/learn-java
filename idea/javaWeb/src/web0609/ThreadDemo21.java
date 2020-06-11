package web0609;

import java.util.Scanner;

public class ThreadDemo21 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {//1
                    while(true) {
                        try {
                            System.out.println("wait 开始");
                            locker.wait();//2 使用锁的对象和调用wait的对应必须是一个
                            System.out.println("wait 结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数，继续执行notify");
                int num = scanner.nextInt();
                synchronized (locker) {//3
                    System.out.println("notify 开始");
                    locker.notify();//4 notify的对象和wait的对象对应了才能生效,这四个位置的对象都必须一致
                    System.out.println("notify 结束");
                }
            }
        };
        t2.start();
    }
}
