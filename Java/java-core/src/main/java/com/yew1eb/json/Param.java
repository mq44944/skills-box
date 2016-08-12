package com.yew1eb.json;

/**
 * @author zhouhai
 * @createTime 16/6/28
 * @description
 */
public class Param {
    private String type;
    private Object value;

    public Param(){}
    public Param(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Param [type=" + type + ", value=" + value + "]";
    }
}