package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

/**
 * 日程表
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Schedule {
    private long id;
    private String title;
    private String address;
    private Long meetingid;
    private Time begintime;
    private Time endtime;
    private String schcontent;
    private String createuser;
    private Time createtime;
    private Long ifprivate;
    private Meetinginfo meeting;
    private Set<Precontract> precontracts;


    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*@Basic
    @Column(name = "MEETINGID", nullable = true, precision = 0)*/
    public Long getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(Long meetingid) {
        this.meetingid = meetingid;
    }

    @Basic
    @Column(name = "BEGINTIME", nullable = true)
    public Time getBegintime() {
        return begintime;
    }

    public void setBegintime(Time begintime) {
        this.begintime = begintime;
    }

    @Basic
    @Column(name = "ENDTIME", nullable = true)
    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "SCHCONTENT", nullable = true, length = 50)
    public String getSchcontent() {
        return schcontent;
    }

    public void setSchcontent(String schcontent) {
        this.schcontent = schcontent;
    }

    @Basic
    @Column(name = "CREATEUSER", nullable = true, length = 50)
    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
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
    @Column(name = "IFPRIVATE", nullable = true, precision = 0)
    public Long getIfprivate() {
        return ifprivate;
    }

    public void setIfprivate(Long ifprivate) {
        this.ifprivate = ifprivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (id != schedule.id) return false;
        if (title != null ? !title.equals(schedule.title) : schedule.title != null) return false;
        if (address != null ? !address.equals(schedule.address) : schedule.address != null) return false;
        if (meetingid != null ? !meetingid.equals(schedule.meetingid) : schedule.meetingid != null) return false;
        if (begintime != null ? !begintime.equals(schedule.begintime) : schedule.begintime != null) return false;
        if (endtime != null ? !endtime.equals(schedule.endtime) : schedule.endtime != null) return false;
        if (schcontent != null ? !schcontent.equals(schedule.schcontent) : schedule.schcontent != null) return false;
        if (createuser != null ? !createuser.equals(schedule.createuser) : schedule.createuser != null) return false;
        if (createtime != null ? !createtime.equals(schedule.createtime) : schedule.createtime != null) return false;
        if (ifprivate != null ? !ifprivate.equals(schedule.ifprivate) : schedule.ifprivate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (meetingid != null ? meetingid.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (schcontent != null ? schcontent.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (ifprivate != null ? ifprivate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MEETINGID", referencedColumnName = "ID")
    public Meetinginfo getMeeting() {
        return meeting;
    }

    public void setMeeting(Meetinginfo meeting) {
        this.meeting = meeting;
    }

    @OneToMany(mappedBy = "schedule")
    public Set<Precontract> getPrecontracts() {
        return precontracts;
    }

    public void setPrecontracts(Set<Precontract> precontracts) {
        this.precontracts = precontracts;
    }
}
