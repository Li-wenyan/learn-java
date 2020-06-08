package web0604;

public class ThreadDemo1 {   //创建出的新线程
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello world, 我是一个线程");
            while(true) {

            }
        }
    }
    public static void main(String[] args) {    //main方法对应的主线程
        //创建线程需要使用Thread类来创建一个Thread的实例
        //另一方面，还需要给这个线程指定要执行哪些指令/代码
        //指定指令的方式有很多种，此处先用一种简单的，直接继承Thread类
        //重写Thread类中的run方法

        //[注意]当Thread对象被创建出来的时候，内核中并没有随之产生一个线程（PCB）
        Thread t = new MyThread();
        //执行这个start方法，才是真的创建出了一个线程
        //此时内核中才随之出现了一个PCB,这个PCB就会对应让CPU来执行该线程的代码（上面的run逻辑）
        t.start();
        while(true) {

        }
    }
}
