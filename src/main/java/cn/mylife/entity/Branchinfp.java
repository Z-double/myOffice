package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Branchinfp {
    private long id;
    private String name;
    private String branchshortname;
    private Set<Departinfo> departs;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BRANCHSHORTNAME", nullable = true, length = 50)
    public String getBranchshortname() {
        return branchshortname;
    }

    public void setBranchshortname(String branchshortname) {
        this.branchshortname = branchshortname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branchinfp that = (Branchinfp) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (branchshortname != null ? !branchshortname.equals(that.branchshortname) : that.branchshortname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (branchshortname != null ? branchshortname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "branch")
    public Set<Departinfo> getDeparts() {
        return departs;
    }

    public void setDeparts(Set<Departinfo> departs) {
        this.departs = departs;
    }
}
