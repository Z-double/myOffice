package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Userinfo {
    private String id;
    private String username;
    private String passsword;
    private Long departid;
    private Long gender;
    private Long roleid;
    private long userstateid;
    private Departinfo depart;
    private Userstate userstate;
    private Set<Manualsign> manualsigns;
    private Set<Message> messages;
    private Set<Messagetouser> messtousers;
    private Set<Readcommonmessage> readcommonmesages;
    private Set<Precontract> precontracts;
    private Set<Loginlog> loginlogs;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSSWORD", nullable = true, length = 30)
    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    /*@Basic
    @Column(name = "DEPARTID", nullable = true, precision = 0)*/
    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }

    @Basic
    @Column(name = "GENDER", nullable = true, precision = 0)
    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "ROLEID", nullable = true, precision = 0)
    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /*@Basic
    @Column(name = "USERSTATEID", nullable = false, precision = 0)*/
    public long getUserstateid() {
        return userstateid;
    }

    public void setUserstateid(long userstateid) {
        this.userstateid = userstateid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userinfo userinfo = (Userinfo) o;

        if (userstateid != userinfo.userstateid) return false;
        if (id != null ? !id.equals(userinfo.id) : userinfo.id != null) return false;
        if (username != null ? !username.equals(userinfo.username) : userinfo.username != null) return false;
        if (passsword != null ? !passsword.equals(userinfo.passsword) : userinfo.passsword != null) return false;
        if (departid != null ? !departid.equals(userinfo.departid) : userinfo.departid != null) return false;
        if (gender != null ? !gender.equals(userinfo.gender) : userinfo.gender != null) return false;
        if (roleid != null ? !roleid.equals(userinfo.roleid) : userinfo.roleid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passsword != null ? passsword.hashCode() : 0);
        result = 31 * result + (departid != null ? departid.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (int) (userstateid ^ (userstateid >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTID", referencedColumnName = "ID")
    public Departinfo getDepart() {
        return depart;
    }

    public void setDepart(Departinfo depart) {
        this.depart = depart;
    }

    @ManyToOne
    @JoinColumn(name = "USERSTATEID", referencedColumnName = "ID", nullable = false)
    public Userstate getUserstate() {
        return userstate;
    }

    public void setUserstate(Userstate userstate) {
        this.userstate = userstate;
    }
    @OneToMany(mappedBy = "userinfo")
    public Set<Manualsign> getManualsigns() {
        return manualsigns;
    }

    public void setManualsigns(Set<Manualsign> manualsigns) {
        this.manualsigns = manualsigns;
    }
    @OneToMany(mappedBy = "user")
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "userinfo")
    public Set<Messagetouser> getMesstousers() {
        return messtousers;
    }

    public void setMesstousers(Set<Messagetouser> messtousers) {
        this.messtousers = messtousers;
    }
    @OneToMany(mappedBy = "userinfo")
    public Set<Readcommonmessage> getReadcommonmesages() {
        return readcommonmesages;
    }

    public void setReadcommonmesages(Set<Readcommonmessage> readcommonmesages) {
        this.readcommonmesages = readcommonmesages;
    }
    @OneToMany(mappedBy = "userinfo")
    public Set<Precontract> getPrecontracts() {
        return precontracts;
    }

    public void setPrecontracts(Set<Precontract> precontracts) {
        this.precontracts = precontracts;
    }
    @OneToMany(mappedBy = "user")
    public Set<Loginlog> getLoginlogs() {
        return loginlogs;
    }

    public void setLoginlogs(Set<Loginlog> loginlogs) {
        this.loginlogs = loginlogs;
    }
}
