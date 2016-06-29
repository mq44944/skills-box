package com.yew1eb.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhai
 * @createTime 16/6/28
 * @description
 */

public class InvokerBean {

    private String secret;
    private String type;
    private String processUnitName;
    private List<Param> data = new ArrayList<Param>();

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcessUnitName() {
        return processUnitName;
    }

    public void setProcessUnitName(String processUnitName) {
        this.processUnitName = processUnitName;
    }

    public List<Param> getData() {
        return data;
    }

    public void setData(List<Param> data) {
        this.data = data;
    }

    public void addParam(Param param) {
        this.data.add(param);
    }

    @Override
    public String toString() {
        return "InvokerBean:[secret:" + secret + ", type:" + type + ", processUnitName:" + processUnitName + ", data:" + data + "]";
    }
}
