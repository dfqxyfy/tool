package cn.ccs.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 用Java语言实现HTTP服务器,首先启动一个java.net.ServerSocket在提供服务的端口上监听连接.向客户返回文本时,可以用
 * PrintWriter,但是如果返回二进制数据,则必须使用OutputStream.write(byte[])方法,返回的应答消息字符串可以使用
 * String.getBytes()方法转换为字节数组返回,或者使用PrintStream的print()方法写入文本,用
 * write(byte[])方法写入二进制数据.
 * <p>
 * 以工程所在目录为web的根目录。 在工程的根目录下放一个大概如下的index.html
 * <p>
 * <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 * "http://www.w3.org/TR/html4/loose.dtd"> <html> <head> <meta
 * http-equiv="Content-Type" content="text/html; charset=gbk">
 * <title>简单的测试</title> </head> <body> 你好！这是一个 简单的web服务器。<br>
 * 这是一个图片！<br>
 * <p>
 * <form action="/index.html"> <img alt="" src="images/test.gif"><br>
 * 姓名：<input type="text" name="name" /><br>
 * 密码：<input type="password" name="pass"></input><br>
 * <input type="submit"/> </form> </body> </html>
 * <p>
 * 放入图片位置： 工程根目录/images/test.gif <br>
 * 打开浏览器输入http://localhost/index.html 可以展示index.html
 *
 * @author rommel1
 */
public class SimpleHttpServer {


    ServerSocket serverSocket;// 服务器Socket
    ExecutorService pool = Executors.newFixedThreadPool(2);


    /**
     * 服务器监听端口, 默认为 80.
     */
    public static int PORT = 8099;// 标准HTTP端口


    /**
     * 开始服务器 Socket 线程.
     */
    public SimpleHttpServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法启动HTTP服务器:" + e.getMessage());
        }
        if (serverSocket == null) {
            System.exit(1);// 无法开始服务器
        }


// new Thread(this).start();
        System.out.println("HTTP服务器正在运行,端口:" + PORT);
        while (true) {
            pool.execute(new Process(serverSocket));
        }
    }


/**
 * 运行服务器主线程, 监听客户端请求并返回响应.
 */


/** */
    /**
     * 启动 HTTP 服务器
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("这是一个简单的web服务器 ，端口是： 80.");
            } else if (args.length == 1) {
                PORT = Integer.parseInt(args[0]);
            }
        } catch (Exception ex) {
            System.err.println("服务器初始化错误" + ex.getMessage());
        }


        new SimpleHttpServer();
    }
}


class Process extends Thread {
    private ServerSocket serverSocket;// 服务器Socket


    Process(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            Socket client = null;// 客户Socket
            client = serverSocket.accept();// 客户机(这里是 IE 等浏览器)已经连接到当前服务器
            if (client != null) {
                System.out.println("连接到服务器的用户:" + client);
                try {
// 第一阶段: 打开输入流
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));


                    System.out.println("客户端发送的请求信息: ***************");
// 读取第一行, 请求地址
                    System.out.println("http协议头部信息：");
                    String line = in.readLine();
                    System.out.println(line);
                    String resource = line.substring(line.indexOf('/'),
                            line.lastIndexOf('/') - 5);
// 获得请求的资源的地址
                    resource = URLDecoder.decode(resource, "gbk");// 反编码


                    String method = new StringTokenizer(line).nextElement()
                            .toString();// 获取请求方法, GET 或者 POST


// 读取浏览器发送过来的请求参数头部信息
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);


                        if (line.equals("")) {
                            break;
                        }
                    }


                    System.out.println("http协议头部结束 ***************");
                    System.out.println("用户请求的资源是:" + resource);
                    System.out.println("请求的类型是: " + method);


                    String params = null;


                    if (resource.indexOf("?") > -1) {
                        params = resource.substring(resource.indexOf("?") + 1);
                        resource = resource.substring(0, resource.indexOf("?"));
                    }


// 显示 POST 表单提交的内容, 这个内容位于请求的主体部分
                    if ("POST".equalsIgnoreCase(method)) {
                        if (params != null) {
                            params += "&" + in.readLine();
                        } else {
                            params = in.readLine();
                        }
                    }


                    System.out.println("打印提交的数据：");
                    printParams(params);


// 读取资源并返回给客户端
                    fileReaderAndReturn(resource, client);
// 关闭客户端链接
                    client.close();
                    System.out.println("客户端返回完成！");
                } catch (Exception e) {
                    System.out.println("HTTP服务器错误:" + e.getMessage());
                }
            }


        } catch (Exception e) {
            System.out.println("HTTP服务器错误:" + e.getMessage());
        }
    }


    /**
     * 读取一个文件的内容并返回给浏览器端.
     *
     * @param fileName 文件名
     * @param socket   客户端 socket.
     * @throws IOException
     */
    void fileReaderAndReturn(String fileName, Socket socket) throws IOException {
        if ("/".equals(fileName)) {// 设置欢迎页面，呵呵！
            fileName = "/index.html";
        }
        fileName = fileName.substring(1);


        PrintStream out = new PrintStream(socket.getOutputStream(), true);
        File fileToSend = new File(fileName);


        String fileEx = fileName.substring(fileName.indexOf(".") + 1);
        String contentType = null;
// 设置返回的内容类型
// 此处的类型与tomcat/conf/web.xml中配置的mime-mapping类型是一致的。测试之用，就写这么几个。
        if ("htmlhtmxml".indexOf(fileEx) > -1) {
            contentType = "text/html;charset=GBK";
        } else if ("jpegjpggifbpmpng".indexOf(fileEx) > -1) {
            contentType = "application/binary";
        }


        if (fileToSend.exists() && !fileToSend.isDirectory()) {
// http 协议返回头
            out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            out.println("Content-Type:" + contentType);
            out.println("Content-Length:" + fileToSend.length());// 返回内容字节数
            out.println();// 根据 HTTP 协议, 空行将结束头信息


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileToSend);
            } catch (FileNotFoundException e) {
                out.println("<h1>404错误！</h1>" + e.getMessage());
            }
            byte data[];
            try {
                data = new byte[fis.available()];


                fis.read(data);
                out.write(data);
            } catch (IOException e) {
                out.println("<h1>500错误!</h1>" + e.getMessage());
                e.printStackTrace();
            } finally {
                out.close();
                try {
                    fis.close();
                } catch (IOException e) {


                    e.printStackTrace();
                }
            }
        } else {
            out.println("<h1>404错误！</h1>" + "文件没有找到");
            out.close();


        }


    }


    void printParams(String params) throws IOException {
        if (params == null) {
            return;
        }
        String[] maps = params.split("&");
        for (String temp : maps) {
            String[] map = temp.split("=");
            System.out.println(map[0] + "==" + map[1]);
        }
    }
}