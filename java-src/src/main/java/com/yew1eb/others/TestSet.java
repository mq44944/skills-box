package com.yew1eb.others;

import java.io.File;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.luhuiguo.chinese.ChineseUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhai
 * @createTime 16/3/24
 * @description
 */
public class TestSet {

    public static void main(String[] args) throws Exception{


        Set<String> provinceSet = getProvinceSet();

        File file = new File("/Users/yew1eb/SoftWare/xxx.txt");
        int i = 0;
        for(String line : Files.readLines(file, Charsets.UTF_8)) {

            boolean flag = isInProvinceSet(line, provinceSet);
            if(!flag) {
                System.out.print(i + ":" + line);
                System.out.println(" not found");
            }
            i = i+1;
        }

    }

    public static Set<String> getProvinceSet() throws IOException {
        File file = new File("/Users/yew1eb/SoftWare/city_mapping_province.csv");
        Set<String> ret = new HashSet<String>();

        for(String line : Files.readLines(file, Charsets.UTF_8)) {
            String[] arrs = line.split(",");
            ret.add(arrs[3]);
        }

        return ret;
    }

    private static boolean isInProvinceSet(String city, Set<String> provinceSet) {
        String tempProvince = "";
        String[] splits = city.split("-");
        if(splits.length > 0) {
            tempProvince = splits[0];
        }
        if(tempProvince.length() <= 0) {
            return false;
        }

        String province = ChineseUtils.toSimplified(tempProvince);

        for(String value : provinceSet) {
            if (value.indexOf(province) >= 0 || province.indexOf(value) >= 0) {
                return true;
            }
        }
        return false;
    }
}
