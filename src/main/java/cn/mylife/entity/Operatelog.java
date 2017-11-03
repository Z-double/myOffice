package cn.mylife.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Operatelog {
    private long id;
    private String userid;
    private String operatename;
    private String objectid;
    private String operatedesc;
    private Time operatetime;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERID", nullable = true, length = 50)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "OPERATENAME", nullable = true, length = 20)
    public String getOperatename() {
        return operatename;
    }

    public void setOperatename(String operatename) {
        this.operatename = operatename;
    }

    @Basic
    @Column(name = "OBJECTID", nullable = true, length = 20)
    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    @Basic
    @Column(name = "OPERATEDESC", nullable = true, length = 200)
    public String getOperatedesc() {
        return operatedesc;
    }

    public void setOperatedesc(String operatedesc) {
        this.operatedesc = operatedesc;
    }

    @Basic
    @Column(name = "OPERATETIME", nullable = true)
    public Time getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Time operatetime) {
        this.operatetime = operatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operatelog that = (Operatelog) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (operatename != null ? !operatename.equals(that.operatename) : that.operatename != null) return false;
        if (objectid != null ? !objectid.equals(that.objectid) : that.objectid != null) return false;
        if (operatedesc != null ? !operatedesc.equals(that.operatedesc) : that.operatedesc != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (operatename != null ? operatename.hashCode() : 0);
        result = 31 * result + (objectid != null ? objectid.hashCode() : 0);
        result = 31 * result + (operatedesc != null ? operatedesc.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        return result;
    }
}
