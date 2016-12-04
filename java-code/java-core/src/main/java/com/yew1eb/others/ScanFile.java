package com.yew1eb.others;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhouhai
 * @createTime 16/3/28
 * @description
 */
public class ScanFile {
    public static void main(String[] args) throws Exception {

        InsertAcctLoginLogRisk();
    }

    public static void InsertAcctLoginLogRisk() throws Exception {
        File in = new File("/Users/yew1eb/login_risk.data");
        File out = new File("/Users/yew1eb/login_risk.sql");
        StringBuilder outString =new StringBuilder();
        outString.append("INSERT INTO biz_auth.acct_login_log_risk VALUES\n");
        int i = 0;
        for (String line : Files.readLines(in, Charsets.UTF_8)) {
            String[] fields = line.split("\t");
            String t = "";
            if(i > 0) t += ",\n";
            t += "(";
            //t += "null,";
            t += fields[0]+",";                 //id
            t += fields[1]+",";                 //origin_id
            t += fields[2]+",";                 //acct_id
            t += "'"+ fields[3] +"'" + ",";     //acct_login
            t += fields[4]+",";                 //device_id
            t += "'"+ fields[5] +"'" + ",";     //device_uuid
            t +=  "'"+ fields[6] +"'" + ",";    //token
            t += fields[7]+",";                 //ip
            t += "'"+ fields[8] +"'" + ",";     //city
            t += fields[9]+",";                 //source
            t += "'"+ fields[10] +"'" + ",";     //device_snapshot
            t += fields[11]+",";                //ctime
            t += fields[12]+",";                //utime
            t += fields[13]+")";                //risk_type
            i = i + 1;
            outString.append(t);
            //if(i > 5) break;
        }
        outString.append(";");
        Files.write( outString.toString().getBytes(), out);
        System.out.println("count= " + i);
    }

    public static void InsertAcctLoginLog() throws Exception {
        File in = new File("/Users/yew1eb/dump.data");
        File out = new File("/Users/yew1eb/dump.sql");
        StringBuilder outString =new StringBuilder();
        outString.append("USE `biz_auth_qa`;\n" +
                "INSERT INTO `acct_login_log` VALUES\n");
        int i = 0;
        for (String line : Files.readLines(in, Charsets.UTF_8)) {
            String[] fields = line.split("\t");
            String t = "";
            if(i > 0) t += ",\n";
            t += "(";
            t += fields[0]+",";
            t += fields[1]+",";
            t += "'"+ fields[2] +"'" + ",";
            t += fields[3]+",";
            t += "'"+ fields[4] +"'" + ",";
            t +=  "'"+ fields[5] +"'" + ",";
            t += fields[6]+",";
            t += "'"+ fields[7] +"'" + ",";
            t += fields[8]+",";
            t += "'"+ fields[9] +"'" + ",";
            t += fields[10]+")";
            i = i + 1;
            // if(i > 10) break;
            outString.append(t);
        }
        outString.append(";");
        Files.write( outString.toString().getBytes(), out);
        System.out.println("count= " + i);
    }
}
