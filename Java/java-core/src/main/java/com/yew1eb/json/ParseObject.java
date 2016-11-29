package com.yew1eb.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhai
 * @createTime 2016/11/10
 * @description
 */
public class ParseObject {

    public static void main(String[] args) {
        String jsonString = "{'id':'324', 'age':'234', 'sex':'male', 'uuid':'234dfasdfqer1433@#DAf'}";
        UserTest user = JSON.parseObject(jsonString, UserTest.class);
        System.out.println(user);

        List<UserTest> ret = new ArrayList<UserTest>();
        ret.add(new UserTest(12,24));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", ret);
        System.out.println(jsonObject);
    }
}
