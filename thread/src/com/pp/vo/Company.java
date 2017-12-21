package com.pp.vo;

import java.util.Date;

public class Company {
    private Integer cid;
    private String address;
    private String tell;
    private Date createDate;

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", address='" + address + '\'' +
                ", tell='" + tell + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
