package com.pp.reflect;

import com.pp.vo.Emp;
import com.pp.vo.EmpAction;

public class reflectDemo5SimpleVo {
    public static void main(String[] args)throws  Exception{
        Emp e=new Emp();
        e.setEname("SMITH");
        e.setJob("CLARK");
//        System.out.println(e);
        //传字符串设值
        String value="emp.ename:SMITH" +
                "|emp.job:CLARK" +
                "|emp.dept.dname:IT部" +
                "|emp.dept.company.address:上海"+
                "|emp.salary:1999.12"+
                "|emp.hiredate:1990-10-11"+
                "|emp.dept.count:712874934"+
                "|emp.dept.company.cid:10"+
                "|emp.dept.company.createDate:1990-10-23  23:23:23"
                ;
        EmpAction empAction=new EmpAction();
        empAction.setVaule(value);
        System.out.print(empAction.getEmp());
    }
}
