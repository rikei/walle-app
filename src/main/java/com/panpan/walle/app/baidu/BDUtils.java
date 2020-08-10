package com.panpan.walle.app.baidu;

import com.alibaba.fastjson.JSON;

import java.util.TreeMap;

public class BDUtils {
    /**
     * www-form-urlencoded 改成 JSON格式报文
     * @param url
     * @return
     */
    public static String convertURLToJSON(String url) {
        String[] ss = url.split("&");
        TreeMap<String, String> map = new TreeMap<>();
        for (String s : ss) {
            int i = s.indexOf('=');
            if (i > 0) {
                map.put(s.substring(0, i), s.substring(i + 1));
            }
        }
        return JSON.toJSONString(map);
    }
}
