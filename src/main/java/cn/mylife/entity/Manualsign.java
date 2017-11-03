package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;

/**考勤信息
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Manualsign {
    private long id;
    private Long userid;
    private Time signtime;
    private String signdesc;
    private Long signtag;
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
    @Column(name = "USERID", nullable = true, precision = 0)*/
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "SIGNTIME", nullable = true)
    public Time getSigntime() {
        return signtime;
    }

    public void setSigntime(Time signtime) {
        this.signtime = signtime;
    }

    @Basic
    @Column(name = "SIGNDESC", nullable = true, length = 50)
    public String getSigndesc() {
        return signdesc;
    }

    public void setSigndesc(String signdesc) {
        this.signdesc = signdesc;
    }

    @Basic
    @Column(name = "SIGNTAG", nullable = true, precision = 0)
    public Long getSigntag() {
        return signtag;
    }

    public void setSigntag(Long signtag) {
        this.signtag = signtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manualsign that = (Manualsign) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (signtime != null ? !signtime.equals(that.signtime) : that.signtime != null) return false;
        if (signdesc != null ? !signdesc.equals(that.signdesc) : that.signdesc != null) return false;
        if (signtag != null ? !signtag.equals(that.signtag) : that.signtag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (signtime != null ? signtime.hashCode() : 0);
        result = 31 * result + (signdesc != null ? signdesc.hashCode() : 0);
        result = 31 * result + (signtag != null ? signtag.hashCode() : 0);
        return result;
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
