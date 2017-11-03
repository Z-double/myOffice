package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Departinfo {
    private long id;
    private String name;
    private String userid;
    private String phone;
    private String mobile;
    private String faxes;
    private String branchid;
    private Set<Userinfo> users;
    private Branchinfp branch;

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
    @Column(name = "USERID", nullable = true, length = 50)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "MOBILE", nullable = true, length = 50)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "FAXES", nullable = true, length = 30)
    public String getFaxes() {
        return faxes;
    }

    public void setFaxes(String faxes) {
        this.faxes = faxes;
    }

    /*@Basic
    @Column(name = "BRANCHID", nullable = true, length = 50)*/
    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departinfo that = (Departinfo) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (faxes != null ? !faxes.equals(that.faxes) : that.faxes != null) return false;
        if (branchid != null ? !branchid.equals(that.branchid) : that.branchid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (faxes != null ? faxes.hashCode() : 0);
        result = 31 * result + (branchid != null ? branchid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "depart")
    public Set<Userinfo> getUsers() {
        return users;
    }

    public void setUsers(Set<Userinfo> users) {
        this.users = users;
    }

    @ManyToOne
    @JoinColumn(name = "BRANCHID", referencedColumnName = "ID")
    public Branchinfp getBranch() {
        return branch;
    }

    public void setBranch(Branchinfp branch) {
        this.branch = branch;
    }
}
