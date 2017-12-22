package com.pp.reflect;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class Member{
    @Override
    public String toString() {
        return "Member{}";
    }
}

class MyClassLoader extends  ClassLoader{
    /**
     * 实现一个自定义类加载器操作，传入类的名称，通过指定文件路径加载
     * @param className
     * @return
     * @throws Exception
     */
    public Class<?> loadData(String className) throws  Exception{
        byte classData[]=this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }

    /**
     * 通过指定文件路径进行类的文件加载，就是进行二进制读取
     * @return
     * @throws Exception
     */
    private byte[] loadClassData()throws Exception{
        InputStream inputStream=new FileInputStream("D:"+ File.separator+"Member.class");
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();//取得字节内容
        byte data[]=new byte[20];
        int temp=0;
        while((temp= inputStream.read(data))!=-1){
            byteArrayOutputStream.write(data,0,temp);
        }
        byte ret[]=byteArrayOutputStream.toByteArray();
        inputStream.close();
        byteArrayOutputStream.close();
        return  ret;
    }
}
public class classLoaderDemo {
    public static void main(String[] args) throws  Exception{
//        Class<?>cls=Member.class;
//        System.out.println(cls.getClassLoader());
//        System.out.println(cls.getClassLoader().getParent());
//        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.print(
                Class.forName("com.pp.reflect.Member").getClassLoader().loadClass("com.pp.reflect.Member").newInstance()
        );
        Class<?> cls=new MyClassLoader().loadData("com.pp.reflect.Member");
        System.out.print(cls.newInstance());
    }
}
