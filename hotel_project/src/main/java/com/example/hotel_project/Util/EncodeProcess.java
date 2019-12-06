package com.example.hotel_project.Util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class EncodeProcess {

    /**
     * 密码加密处理（MD5）
     *
     * @param src 原密码
     * @return 加密后的内容
     */
    //类存在问题java.lang.ClassNotFoundException: org.apache.commons.codec.binary.Base64
    public static String md5(String src) {
        out.println("加密测试：");
        try {//采用MD5处理
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(src.getBytes());//加密处理
            //将加密结果output利用Base64转成字符串输出
            String ret = Base64.encodeBase64String(output);
            return ret;
        } catch (Exception e) {
            out.println("加密失败");
            e.printStackTrace();
            return "fail";
        }
    }


    //获取今天日期
    static public String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
