package web0627;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket = null;
    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }
    private void process(Socket clientSocket) {

        try {
            //1.读取并解析请求
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println("request: " + request);
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type", "text/html");
            //2.根据请求计算响应
            if(request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>hello</h1>");
            }else if (request.getUrl().startsWith("/calc")) {
                //这个逻辑要根据参数的内容进行计算
                //先获取到A和B两个参数的值
                String astr = request.getParameter("a");
                String bstr = request.getParameter("b");
                System.out.println("a: " + astr + ", b: " + bstr);
                int a = Integer.parseInt(astr);
                int b = Integer.parseInt(bstr);
                int result = a + b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>result = " + result + "</h1>");
            }else if(request.getUrl().startsWith("/cookieUser")) {
                response.setStatus(200);
                response.setMessage("OK");
                //Http 的header中允许有多个Set-Cookie字段，
                // 但是此处response中使用hashMap来表示header的，此时相同的key就覆盖了
                response.setHeaders("Set-Cookie", "user=tz");
                response.writeBody("<h1>set cookieUser</h1>");
            }else if(request.getUrl().startsWith("/cookieTime")) {
                response.setStatus(200);
                response.setMessage("OK");
                //Http 的header中允许有多个Set-Cookie字段，
                // 但是此处response中使用hashMap来表示header的，此时相同的key就覆盖了
                response.setHeaders("Set-Cookie", "time=" + (System.currentTimeMillis()/1000));
                response.writeBody("<h1>set cookieTime</h1>");
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>default</h1>");
            }
            //3.把响应写回到客户端
            response.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }finally {
            try {
                //这个操作会同时关闭getInputStream和getOutputStream对象
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 serverV2 = new HttpServerV2(9090);
        serverV2.start();
    }
}
