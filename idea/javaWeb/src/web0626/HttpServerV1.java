package web0626;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    //HTTP底层要基于TCP来实现，需要按照TCP的基本格式来进行开发
    private ServerSocket serverSocket = null;
    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(true) {
            //1.获取连接
            Socket clientSocket = serverSocket.accept();
            //2.处理连接(使用短链接的方式实现)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        //由于HTTP协议是文本协议，所以仍然使用字符流来处理
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //下面的操作都要严格按照HTTP协议来进行操作
            //1.读取请求并解析
            //   a)解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];

            //   b)解析header，按行读取，按照冒号空格来分割键值对
            Map<String, String> headers = new HashMap<>();
            String line = "";
            //readLine读取的一行内容，是会自动去掉换行符的，对于空行来说，去掉了换行符，就变成空字符串
            while((line = bufferedReader.readLine()) != null && line.length() != 0) {
                //不能使用：来切分，像referer字段，里面的内容是可能包括：
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0], headerTokens[1]);
            }
            //    c)解析body（暂时先不考虑）。
            //2.根据请求计算响应
            //3.把响应写回到客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
