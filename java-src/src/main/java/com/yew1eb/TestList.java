package com.yew1eb;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.luhuiguo.chinese.ChineseUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhouhai
 * @createTime 16/3/24
 * @description
 */
public class TestList {

    public static void main(String[] args) throws Exception {
        List<Long> list = new ArrayList<Long>();
        list.add(5L);
        list.add(1L);
        list.add(3L);
        list.add(2L);

        for(int i=0; i<list.size(); ++i) {
            System.out.println(list.get(i));
        }

        Object obj = 23;
        int x = Integer.parseInt(obj.toString());
        System.out.println(x);
        List<Long> LL = new ArrayList<Long>();
        LL.addAll(list);
        LL.addAll(list);
        System.out.println("LL.size() = "+LL.size());
    }
}
