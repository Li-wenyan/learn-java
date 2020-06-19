package io0616;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("d:/test_dir/test.jpg", "d:/test_dir/test2.jpg");
    }
    private static void copyFile(String srcPath, String destPath) throws IOException {
        //0.先打开文件，才能够读写（创建InputStream/OutputStream对象的过程）
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);

        //1.需要读取srcPath对应的文件内容
        byte[] buffer = new byte[1024];
        //单次读取的内容是存在上限（缓冲区的长度），要想把文件整个都读完，需要搭配循环来使用
        int len = -1;
        //如果读取到的len是-1，说明读取结束，循环就结束了
        while((len = fileInputStream.read(buffer)) != -1) {
            //读取成功,就把读到的内容写入到另外一个文件中即可。
            //因为len的值不一定就是和缓冲区一样长
            // 2.把读取的内容写入到destPath对应的文件中
            fileOutputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
