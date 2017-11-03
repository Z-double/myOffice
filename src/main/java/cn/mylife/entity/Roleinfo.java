package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Roleinfo {
    private long id;
    private String rolename;
    private String roledesc;
    private Set<Roleright> roles;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLENAME", nullable = true, length = 50)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic
    @Column(name = "ROLEDESC", nullable = true, length = 50)
    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roleinfo roleinfo = (Roleinfo) o;

        if (id != roleinfo.id) return false;
        if (rolename != null ? !rolename.equals(roleinfo.rolename) : roleinfo.rolename != null) return false;
        if (roledesc != null ? !roledesc.equals(roleinfo.roledesc) : roleinfo.roledesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        result = 31 * result + (roledesc != null ? roledesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "role")
    public Set<Roleright> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roleright> roles) {
        this.roles = roles;
    }
}
