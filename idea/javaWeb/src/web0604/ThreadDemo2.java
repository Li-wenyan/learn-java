package web0604;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class ThreadDemo2 {
    private static long count = 100_0000_0000L;

    public static void main(String[] args) {
        //serial();
        concurrency();
    }
    private static void serial() {
        long beg = System.currentTimeMillis();
        int a = 0;
        for(long i = 0; i <count; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("time： " + (end - beg) + "ms");
    }
    private static void concurrency() {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread() {//匿名内部类

            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread() {//匿名内部类

            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //线程等待，让主线程等待t1和t2执行结束，然后再继续往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //t1   t2  和main线程之间是并发执行的,
        // 调用了t1.start 和t2.start 之后，两个新线程正在紧锣密鼓的进行计算过程中，
        // 此时主线程仍然会继续执行，下面的end就随之被计算了，
        // 正确的做法是要保证t1和t2都计算完毕，再来计算这个end的时间戳
        long end = System.currentTimeMillis();
        System.out.println("time： " + (end - beg) + "ms");
    }


}
