package com.train.day14;

import java.util.Date;

/**
 * @author tjy
 * @version 1.0
 * @date 2019/8/5 15:35
 */
public class HomeWork {
    private String sno;
    private String sname;
    private String ssex;
    private Date sbirthday;
    private String sclass;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                ", sclass='" + sclass + '\'' +
                '}';
    }
}
