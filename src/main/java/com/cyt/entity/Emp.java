package com.cyt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ${user}
 * @create 2019-11-20-10:08
 */
@Entity
public class Emp {
    private int eid;
    private String ename;
    private String epwd;
    private String emoney;

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", epwd='" + epwd + '\'' +
                ", emoney='" + emoney + '\'' +
                '}';
    }

    @Id
    @Column(name = "eid")
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "epwd")
    public String getEpwd() {
        return epwd;
    }

    public void setEpwd(String epwd) {
        this.epwd = epwd;
    }

    @Basic
    @Column(name = "emoney")
    public String getEmoney() {
        return emoney;
    }

    public void setEmoney(String emoney) {
        this.emoney = emoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        Emp emp = (Emp) o;

        if (eid != emp.eid) {return false;}
        if (ename != null ? !ename.equals(emp.ename) : emp.ename != null) {return false;}
        if (epwd != null ? !epwd.equals(emp.epwd) : emp.epwd != null) {return false;}
        if (emoney != null ? !emoney.equals(emp.emoney) : emp.emoney != null) {return false;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (epwd != null ? epwd.hashCode() : 0);
        result = 31 * result + (emoney != null ? emoney.hashCode() : 0);
        return result;
    }
}
