package com.yew1eb.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author zhouhai
 * @createTime 16/4/6
 * @description
 */
public class UDPReceive {

    public static void main(String[] args) throws IOException {
        System.out.println("start UDPReceive...");
        //建立UDP的服务, 并且要监听一个端口
        DatagramSocket socket = new DatagramSocket(9090);

        //准备空的数据包用于存放数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收数据
        socket.receive(packet);
        System.out.println("The receive data:\n" + new String(buf,0,packet.getLength()));
        socket.close();
        System.out.println("end UDPReceive...");
    }
}
