package web0607;

public class ThreadDemo15 {
    static class Counter {
        public int count = 0;
        synchronized public void increase() {//进入increase方法之前会先尝试加锁，方法执行完毕会自动解锁
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();
        //两个线程各自自增50000次，最终预期结果应该是10万次
        System.out.println(counter.count);
    }

}
