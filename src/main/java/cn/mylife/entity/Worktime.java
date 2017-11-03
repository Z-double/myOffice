package cn.mylife.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Worktime {
    private long id;
    private String ondutytime;
    private String offdutytime;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ONDUTYTIME", nullable = true, length = 50)
    public String getOndutytime() {
        return ondutytime;
    }

    public void setOndutytime(String ondutytime) {
        this.ondutytime = ondutytime;
    }

    @Basic
    @Column(name = "OFFDUTYTIME", nullable = true, length = 50)
    public String getOffdutytime() {
        return offdutytime;
    }

    public void setOffdutytime(String offdutytime) {
        this.offdutytime = offdutytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worktime worktime = (Worktime) o;

        if (id != worktime.id) return false;
        if (ondutytime != null ? !ondutytime.equals(worktime.ondutytime) : worktime.ondutytime != null) return false;
        if (offdutytime != null ? !offdutytime.equals(worktime.offdutytime) : worktime.offdutytime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ondutytime != null ? ondutytime.hashCode() : 0);
        result = 31 * result + (offdutytime != null ? offdutytime.hashCode() : 0);
        return result;
    }
}
