package com.yew1eb.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author zhouhai
 * @createTime 16/4/7
 * @description
 */
public class ChatReceive extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            boolean flag = true;
            while (flag) {
                socket.receive(packet);
                System.out.println(packet.getAddress().getHostAddress() + ": " + new String(buf, 0, packet.getLength()));
            }
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
