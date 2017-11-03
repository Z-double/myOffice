package cn.mylife.entity;

import javax.persistence.*;

/**存放所有角色权限
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Roleright {
    private long id;
    private Long nodeid;
    private Sysfun node;
    private Roleinfo role;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*@Basic
    @Column(name = "NODEID", nullable = true, precision = 0)*/
    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roleright roleright = (Roleright) o;

        if (id != roleright.id) return false;
        if (nodeid != null ? !nodeid.equals(roleright.nodeid) : roleright.nodeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nodeid != null ? nodeid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NODEID", referencedColumnName = "ID")
    public Sysfun getNode() {
        return node;
    }

    public void setNode(Sysfun node) {
        this.node = node;
    }

    @ManyToOne
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID")
    public Roleinfo getRole() {
        return role;
    }

    public void setRole(Roleinfo role) {
        this.role = role;
    }
}
