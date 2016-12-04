package com.yew1eb.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhouhai
 * @createTime 2016/11/8
 * @description
 */
public class jsonT {
    private static String str = "{'data':'{ 'took' : 94, 'timed_out' : false, '_shards' : { 'total' : 10, 'successful' : 10, 'failed' : 0 }, 'hits' : { 'total' : 149155, 'max_score' : 0.0, 'hits' : [ ] }, 'aggregations' : { 'pushTypeAgg' : { 'doc_count_error_upper_bound' : 0, 'sum_other_doc_count' : 0, 'buckets' : [ { 'key' : 3, 'doc_count' : 149155, 'statusCodeAgg' : { 'doc_count_error_upper_bound' : 0, 'sum_other_doc_count' : 0, 'buckets' : [ ] } } ] } }}','timeCost'}";

    public static void main(String[] args) {
        System.out.println(JSON.parseObject(str).toJSONString());
    }
}
