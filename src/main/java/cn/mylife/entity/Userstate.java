package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 可扩展性，设置用户是否被屏蔽的状态
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Userstate {
    private String id;
    private String userstatename;
    private Set<Userinfo> users;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERSTATENAME", nullable = true, length = 50)
    public String getUserstatename() {
        return userstatename;
    }

    public void setUserstatename(String userstatename) {
        this.userstatename = userstatename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userstate userstate = (Userstate) o;

        if (id != null ? !id.equals(userstate.id) : userstate.id != null) return false;
        if (userstatename != null ? !userstatename.equals(userstate.userstatename) : userstate.userstatename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userstatename != null ? userstatename.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userstate")
    public Set<Userinfo> getUsers() {
        return users;
    }

    public void setUsers(Set<Userinfo> users) {
        this.users = users;
    }
}
