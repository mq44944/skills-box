package com.yew1eb.others;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class HTTPClient {
    String host = "www.baidu.com";
    int port = 80;
    Socket socket;

    public void createSocket() throws Exception {
        socket = new Socket(host, port);
    }

    public void communicate() throws Exception {
        StringBuffer sb = new StringBuffer("GET " + "/index.html" + " HTTP/1.1\r\n");
        sb.append("Host: " + host + "\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("Accept-Language: zh-cn\r\n");
        sb.append("Accept-Encoding: gzip, deflate\r\n");
        sb.append("User-Agent: Mozilla/4.0(compatible: MSIE 6.0; Windows NT5.0)\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");

        //发出HTTP请求
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(sb.toString().getBytes());
        socket.shutdownOutput();

        //接收响应结果
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "utf-8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        try {
            if(socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        HTTPClient client = new HTTPClient();
        client.createSocket();
        client.communicate();
    }
}

