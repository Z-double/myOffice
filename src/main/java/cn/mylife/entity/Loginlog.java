package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Loginlog {
    private long id;
    private String userid;
    private Time logintime;
    private Long ifsuccess;
    private Long loginuserip;
    private Long logindesc;
    private Userinfo user;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   /* @Basic
    @Column(name = "USERID", nullable = true, length = 50)*/
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "LOGINTIME", nullable = true)
    public Time getLogintime() {
        return logintime;
    }

    public void setLogintime(Time logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "IFSUCCESS", nullable = true, precision = 0)
    public Long getIfsuccess() {
        return ifsuccess;
    }

    public void setIfsuccess(Long ifsuccess) {
        this.ifsuccess = ifsuccess;
    }

    @Basic
    @Column(name = "LOGINUSERIP", nullable = true, precision = 0)
    public Long getLoginuserip() {
        return loginuserip;
    }

    public void setLoginuserip(Long loginuserip) {
        this.loginuserip = loginuserip;
    }

    @Basic
    @Column(name = "LOGINDESC", nullable = true, precision = 0)
    public Long getLogindesc() {
        return logindesc;
    }

    public void setLogindesc(Long logindesc) {
        this.logindesc = logindesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loginlog loginlog = (Loginlog) o;

        if (id != loginlog.id) return false;
        if (userid != null ? !userid.equals(loginlog.userid) : loginlog.userid != null) return false;
        if (logintime != null ? !logintime.equals(loginlog.logintime) : loginlog.logintime != null) return false;
        if (ifsuccess != null ? !ifsuccess.equals(loginlog.ifsuccess) : loginlog.ifsuccess != null) return false;
        if (loginuserip != null ? !loginuserip.equals(loginlog.loginuserip) : loginlog.loginuserip != null)
            return false;
        if (logindesc != null ? !logindesc.equals(loginlog.logindesc) : loginlog.logindesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (logintime != null ? logintime.hashCode() : 0);
        result = 31 * result + (ifsuccess != null ? ifsuccess.hashCode() : 0);
        result = 31 * result + (loginuserip != null ? loginuserip.hashCode() : 0);
        result = 31 * result + (logindesc != null ? logindesc.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
    }
}
