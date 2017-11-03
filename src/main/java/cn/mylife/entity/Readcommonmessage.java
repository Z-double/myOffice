package cn.mylife.entity;

import javax.persistence.*;

/**用户已读信息表
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Readcommonmessage {
    private long id;
    private Long messageid;
    private Long userid;
    private Message message;
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
    @Column(name = "MESSAGEID", nullable = true, precision = 0)*/
    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    /*@Basic
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

        Readcommonmessage that = (Readcommonmessage) o;

        if (id != that.id) return false;
        if (messageid != null ? !messageid.equals(that.messageid) : that.messageid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (messageid != null ? messageid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEID", referencedColumnName = "ID")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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
