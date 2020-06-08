package web0606;

public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("cxk线程") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    //System.out.println(this.getName());
                    // Thread.currentThread()获取到当前线程的实例，当前代码中相当于this，在Runnable和lambda中不能用this
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //run方法的执行过程就代表着系统内线程的生命周期
                // run方法执行中，内核的线程就存在
                // run方法执行完毕，内核中的线程就随之销毁。
                System.out.println("线程要退出了");
            }
        };
        //这组属性，只要线程创建完毕，属性就不变了
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        //这组属性会随着线程的运行过程而发生改变
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println("cxk线程正在运行");
            System.out.println(t.isInterrupted());
            System.out.println(t.getState());
            Thread.sleep(300);
        }


    }
}
