package com.pp.classBank;
import java.text.SimpleDateFormat;
import java.util.Date;
public class dateDemo {
    public static void main(String[] args) throws Exception{
        Date date=new Date();
        System.out.println(date);
        long num=System.currentTimeMillis();//取得当前日期时间数字
        System.out.println(new Date(num));
        System.out.println(new Date(num).getTime());//把时间用long类型取出
        System.out.println(num);
        long test =1231343245242L;
        System.out.println(new Date(test));
        System.out.println("****************SimpleDateFormat*******************");
        String str="yyyy-MM-dd HH:mm:ss.sss";
        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat(str);
        String val=format.format(date1);
        System.out.println(val);
        String str1="1911-11-11 11:11:11.111";
        String pat="yyyy-MM-dd HH:mm:ss.sss";
        format=new SimpleDateFormat(pat);
        Date date2=format.parse(str1);
        System.out.println(date2);
    }
}
