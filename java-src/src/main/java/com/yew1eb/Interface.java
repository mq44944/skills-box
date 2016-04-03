package com.yew1eb;

/**
 * @author zhouhai
 * @createTime 16/4/3
 * @description
 */

class Pencil {
    String name;
    Pencil() {}
    Pencil(String name) {
        this.name = name;
    }
    void write() {
        System.out.println("handwrite");
    }
}
interface Eraser {
    public static final String color = "white";
    public abstract void clean();
}

// 带橡皮的铅笔类: 继承铅笔类 + 实现橡皮接口
class PencilWithEraser extends Pencil implements Eraser {
    PencilWithEraser() {}
    PencilWithEraser(String name) {
        super(name);
    }

    @Override
    void write() {
        System.out.println(name + ":考试专用");
    }

    public void clean() {
        System.out.println(super.name + ":带橡皮的铅笔, 就是好用");
    }
}
public class Interface {
    public static void main(String[] args) {
        PencilWithEraser pe = new PencilWithEraser("中华2B");
        pe.write();
        pe.clean();
        System.out.println(pe.color);
        System.out.println(PencilWithEraser.color);
    }
}
