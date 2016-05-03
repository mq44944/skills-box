package com.yew1eb.socket.udp;

/**
 * @author zhouhai
 * @createTime 16/4/7
 * @description
 */
public class ChatMain {

    public static void main(String[] args) {
        ChatReceive chatReceive = new ChatReceive();
        chatReceive.start();

        ChatSender chatSender = new ChatSender();
        chatSender.start();
    }
}
