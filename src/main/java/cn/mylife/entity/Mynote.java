package cn.mylife.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Mynote {
    private long id;
    private String notetitle;
    private String notecontent;
    private Time createtime;
    private String createuser;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOTETITLE", nullable = true, length = 50)
    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    @Basic
    @Column(name = "NOTECONTENT", nullable = true, length = 50)
    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent;
    }

    @Basic
    @Column(name = "CREATETIME", nullable = true)
    public Time getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Time createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "CREATEUSER", nullable = true, length = 50)
    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mynote mynote = (Mynote) o;

        if (id != mynote.id) return false;
        if (notetitle != null ? !notetitle.equals(mynote.notetitle) : mynote.notetitle != null) return false;
        if (notecontent != null ? !notecontent.equals(mynote.notecontent) : mynote.notecontent != null) return false;
        if (createtime != null ? !createtime.equals(mynote.createtime) : mynote.createtime != null) return false;
        if (createuser != null ? !createuser.equals(mynote.createuser) : mynote.createuser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (notetitle != null ? notetitle.hashCode() : 0);
        result = 31 * result + (notecontent != null ? notecontent.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        return result;
    }
}
