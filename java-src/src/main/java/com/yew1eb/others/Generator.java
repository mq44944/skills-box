package com.yew1eb.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhouhai
 * @createTime 16/4/23
 * @description
 */
public class Generator {
    private  List<String> generate(int n) {
        List<String> list = new ArrayList<String>();
        for(String s:generate2(n)){
            list.add(s);
        }
        return list;
    }
    private  Set<String> generate2(int n) {
        Set<String> set = new HashSet<String>();
        if(n==0) return set;
        if(n==1) {
            set.add("()");
            return set;
        }
        for(String s : generate2(n-1)) {
            set.add("()"+s);
            for(int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0,i)+"()"+s.substring(i));
            }
        }
        return set;
    }

    public static int main(String[] args) {
        xxxx(4);
        return 0;
    }
    public static String[] xxxx(int n) {
        Generator solver = new Generator();
        List<String> list = solver.generate(n);

        return (String[]) list.toArray();
    }
}