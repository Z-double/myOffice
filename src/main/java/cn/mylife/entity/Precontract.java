package cn.mylife.entity;

import javax.persistence.*;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Precontract {
    private long id;
    private Long scheduleid;
    private Long userid;
    private Schedule schedule;
    private Userinfo userinfo;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*@Basic
    @Column(name = "SCHEDULEID", nullable = true, precision = 0)*/
    public Long getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Long scheduleid) {
        this.scheduleid = scheduleid;
    }

   /* @Basic
    @Column(name = "USERID", nullable = true, precision = 0)*/
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Precontract that = (Precontract) o;

        if (id != that.id) return false;
        if (scheduleid != null ? !scheduleid.equals(that.scheduleid) : that.scheduleid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (scheduleid != null ? scheduleid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SCHEDULEID", referencedColumnName = "ID")
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
}
