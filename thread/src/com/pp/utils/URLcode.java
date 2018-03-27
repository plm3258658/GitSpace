package com.pp.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class URLcode {
    public static void main(String[] args) throws Exception {
/*
        //将application/x-www-form-urlencoded字符串

        //转换成普通字符串

        //必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8

        String keyWord = URLDecoder.decode("%E6%96%87%E6%A1%A3", "UTF-8");

        System.out.println(keyWord);



        //将普通字符串转换成

        //application/x-www-form-urlencoded字符串

        //必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8

        String urlStr1 = URLEncoder.encode("文档", "UTF-8");
        String urlStr = URLEncoder.encode("AccessKeyId", "UTF-8");

        System.out.println(urlStr);
        System.out.println(urlStr1);

        String test="+*%7E".replace("+","%20").replace("*","%2A").replace("%7E","~");
//        test=test.replace("+","%20");
//        test=test.replace("*","%2A");
//        test=test.replace("%7E","~");
        System.out.println(test);
        System.out.println(URLEncoder.encode("/","UTF-8"));
        String key="testsecret&";
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] HMAC=mac.doFinal(key.toString().getBytes());
        System.out.println(HMAC);
        System.out.println(Base64.getEncoder().encodeToString(HMAC));

*/
        //第一步
        StringBuffer sb=new StringBuffer();
        sb.append(URLEncoder.encode("AccessKeyId","UTF-8")
                .replace("+","%20")
                .replace("*","%2A")
                .replace("%7E","~"));
        System.out.println(sb.toString());
        sb.append("=");
        sb.append(URLEncoder.encode("testid","UTF-8")
                .replace("+","%20")
                .replace("*","%2A")
                .replace("%7E","~"));
        System.out.println(sb.toString());

        //第二步
        StringBuffer sb2=new StringBuffer();
        sb2.append("GET&%2F&");
        sb2.append(URLEncoder.encode(sb.toString(),"UTF-8"));
        System.out.println(sb2.toString());
        //第三步
        String key="testsecret&";
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] HMAC=mac.doFinal(sb2.toString().getBytes());
        //第四步
        String Signature=Base64.getEncoder().encodeToString(HMAC);
        System.out.println(Signature);
    }

}
