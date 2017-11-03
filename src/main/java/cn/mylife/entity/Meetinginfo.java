package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Meetinginfo {
    private long id;
    private String meetingname;
    private Set<Schedule> schedules;


    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MEETINGNAME", nullable = true, length = 50)
    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meetinginfo that = (Meetinginfo) o;

        if (id != that.id) return false;
        if (meetingname != null ? !meetingname.equals(that.meetingname) : that.meetingname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (meetingname != null ? meetingname.hashCode() : 0);
        return result;
    }
    @OneToMany(mappedBy = "meeting")
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
