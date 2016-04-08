package com.yew1eb.socket.udp;

import javafx.scene.chart.PieChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author zhouhai
 * @createTime 16/4/7
 * @description
 */
public class ChatSender extends Thread {
    @Override
    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket();
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            DatagramPacket packet = null;
            while ((line = keyReader.readLine()) != null) {
                packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.10.255"), 9090);
                socket.send(packet);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
