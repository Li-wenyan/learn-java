package web0606;

public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    System.out.println("我是新线程");
                }

            }
        };
        t.start();
        while (true) {
            System.out.println("我是主线程 ");
            Thread.sleep(100);
        }

    }
}
