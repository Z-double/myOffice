package cn.mylife.entity;

import javax.persistence.*;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Messagetouser {
    private long id;
    private Long messageid;
    private Long touserid;
    private Long ifread;
    private Userinfo userinfo;
    private Message message;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*@Basic
    @Column(name = "MESSAGEID", nullable = true, precision = 0)*/
    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    /*@Basic
    @Column(name = "TOUSERID", nullable = true, precision = 0)*/
    public Long getTouserid() {
        return touserid;
    }

    public void setTouserid(Long touserid) {
        this.touserid = touserid;
    }

    @Basic
    @Column(name = "IFREAD", nullable = true, precision = 0)
    public Long getIfread() {
        return ifread;
    }

    public void setIfread(Long ifread) {
        this.ifread = ifread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messagetouser that = (Messagetouser) o;

        if (id != that.id) return false;
        if (messageid != null ? !messageid.equals(that.messageid) : that.messageid != null) return false;
        if (touserid != null ? !touserid.equals(that.touserid) : that.touserid != null) return false;
        if (ifread != null ? !ifread.equals(that.ifread) : that.ifread != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (messageid != null ? messageid.hashCode() : 0);
        result = 31 * result + (touserid != null ? touserid.hashCode() : 0);
        result = 31 * result + (ifread != null ? ifread.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TOUSERID", referencedColumnName = "ID")
    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEID", referencedColumnName = "ID")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
