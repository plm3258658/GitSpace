package com.pp.classBank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class dateDemo {
    public static void main(String[] args) throws Exception{
//        Date date=new Date();
//        System.out.println(date);
//        long num=System.currentTimeMillis();//取得当前日期时间数字
//        System.out.println(new Date(num));
//        System.out.println(new Date(num).getTime());//把时间用long类型取出
//        System.out.println(num);
//        long test =1231343245242L;
//        System.out.println(new Date(test));
//        System.out.println("****************SimpleDateFormat*******************");
//        String str="yyyy-MM-dd HH:mm:ss.sss";
//        Date date1=new Date();
//        SimpleDateFormat format=new SimpleDateFormat(str);
//        String val=format.format(date1);
//        System.out.println(val);
//        String str1="1911-11-11 11:11:11.111";
//        String pat="yyyy-MM-dd HH:mm:ss.sss";
//        format=new SimpleDateFormat(pat);
//        Date date2=format.parse(str1);
//        System.out.println(date2);

        //1、取得本地时间：
//        java.util.Calendar cal = java.util.Calendar.getInstance();
//
//        //2、取得时间偏移量：
//        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
//
//        //3、取得夏令时差：
//        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
//
//        //4、从本地时间里扣除这些差量，即可以取得UTC时间：
//        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        //之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
//        System.out.println("UTC:"+new Date(cal.getTimeInMillis()));

        Date date=new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String result = sdf1.format(date) + "T" + sdf2.format(date) + "Z";
        System.out.println(result);

    }
}
