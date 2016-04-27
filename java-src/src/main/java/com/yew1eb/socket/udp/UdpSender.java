package com.yew1eb.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zhouhai
 * @createTime 16/4/6
 * @description
 */
/*
public class UDPSender {

    public static void main(String[] args ) throws IOException {
        System.out.println("start UDPSender...");
        //建立UDP服务
        DatagramSocket datagramSocket = new DatagramSocket();

        String data = "DF23A#*DQ#$%#!#F2ADS&^F@#$啊啊啊";
        InetAddress address = InetAddress.getLocalHost();
        int port = 9090;
        //创建一个数据包
        DatagramPacket packet = new DatagramPacket(data.getBytes(),
                data.getBytes().length, address, port);
        //发送数据包
        datagramSocket.send(packet);
        //关闭资源
        datagramSocket.close();
        System.out.println("end UDPSender...");
    }
}


*/