package com.yew1eb;

import java.net.Socket;
import java.io.IOException;

/**
 * Created by yew1eb on 2016/1/22 0022.
 * Socket编程 扫描端口
 */
public class PostSanner {
    public static void main(String args[]) {
        String host = "localhost";
        if( args.length > 0) host = args[0];
        new PostSanner().scan(host);
    }
    public void scan(String host) {
        Socket socket = null;
        for(int port=1; port<1024; ++port) {
            try {
                socket = new Socket(host, port);
                System.out.println("There is a server on port " + port);
            } catch (IOException e) {
                System.out.println("Can't connect to port " + port);
            } finally {
                try {
                    if(socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
