package web0618;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) {
        //分别不使用缓冲区和使用缓冲区来进行读取一个大文件操作，感受时间上的差异
        //testNoBuffer();
        testBuffer();
    }



    private static void testNoBuffer() {
        //读的时候就是一个一个字节的读，完全不使用任何缓冲区
        long beg = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:/Users/dell/Desktop/垃圾.docx");
            int ch = -1;
            while((ch = fileInputStream.read()) != -1) {
                //啥都不干了
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer: " + (end - beg) + "ms");
    }
    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:/Users/dell/Desktop/垃圾.docx"))) {
            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1) {
                //返回
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("has buffer: " + (end - beg) + "ms");
    }

}