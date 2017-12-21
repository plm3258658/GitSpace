package com.pp.vo;

import com.pp.utils.BeanOperation;

public class EmpAction {
    private Emp emp;
    public void setVaule(String value){
        try {
            BeanOperation.setBeanValue(this,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
