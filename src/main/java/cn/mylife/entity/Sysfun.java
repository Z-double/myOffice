package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**存放菜单功能基本信息
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Sysfun {
    private long id;
    private String displayname;
    private String nodeurl;
    private Long displayorder;
    private long parentnodeid;
    private Set<Roleright> menus;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DISPLAYNAME", nullable = true, length = 50)
    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @Basic
    @Column(name = "NODEURL", nullable = true, length = 50)
    public String getNodeurl() {
        return nodeurl;
    }

    public void setNodeurl(String nodeurl) {
        this.nodeurl = nodeurl;
    }

    @Basic
    @Column(name = "DISPLAYORDER", nullable = true, precision = 0)
    public Long getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Long displayorder) {
        this.displayorder = displayorder;
    }

    @Basic
    @Column(name = "PARENTNODEID", nullable = false, precision = 0)
    public long getParentnodeid() {
        return parentnodeid;
    }

    public void setParentnodeid(long parentnodeid) {
        this.parentnodeid = parentnodeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sysfun sysfun = (Sysfun) o;

        if (id != sysfun.id) return false;
        if (parentnodeid != sysfun.parentnodeid) return false;
        if (displayname != null ? !displayname.equals(sysfun.displayname) : sysfun.displayname != null) return false;
        if (nodeurl != null ? !nodeurl.equals(sysfun.nodeurl) : sysfun.nodeurl != null) return false;
        if (displayorder != null ? !displayorder.equals(sysfun.displayorder) : sysfun.displayorder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (displayname != null ? displayname.hashCode() : 0);
        result = 31 * result + (nodeurl != null ? nodeurl.hashCode() : 0);
        result = 31 * result + (displayorder != null ? displayorder.hashCode() : 0);
        result = 31 * result + (int) (parentnodeid ^ (parentnodeid >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "node")
    public Set<Roleright> getMenus() {
        return menus;
    }

    public void setMenus(Set<Roleright> menus) {
        this.menus = menus;
    }
}
