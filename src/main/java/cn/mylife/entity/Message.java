package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Message {
    private long id;
    private String title;
    private String content;
    private Long messagetypeid;
    private Time begintime;
    private Time endtime;
    private String userid;
    private Long ifpublish;
    private Time recordtime;
    private Messagetype messagetype;
    private Userinfo user;
    private Set<Messagetouser> messagetousers;

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
    @Column(name = "CONTENT", nullable = true, length = 50)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   /* @Basic
    @Column(name = "MESSAGETYPEID", nullable = true, precision = 0)*/
    public Long getMessagetypeid() {
        return messagetypeid;
    }

    public void setMessagetypeid(Long messagetypeid) {
        this.messagetypeid = messagetypeid;
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

    /*@Basic
    @Column(name = "USERID", nullable = true, length = 20)*/
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "IFPUBLISH", nullable = true, precision = 0)
    public Long getIfpublish() {
        return ifpublish;
    }

    public void setIfpublish(Long ifpublish) {
        this.ifpublish = ifpublish;
    }

    @Basic
    @Column(name = "RECORDTIME", nullable = true)
    public Time getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Time recordtime) {
        this.recordtime = recordtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (title != null ? !title.equals(message.title) : message.title != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (messagetypeid != null ? !messagetypeid.equals(message.messagetypeid) : message.messagetypeid != null)
            return false;
        if (begintime != null ? !begintime.equals(message.begintime) : message.begintime != null) return false;
        if (endtime != null ? !endtime.equals(message.endtime) : message.endtime != null) return false;
        if (userid != null ? !userid.equals(message.userid) : message.userid != null) return false;
        if (ifpublish != null ? !ifpublish.equals(message.ifpublish) : message.ifpublish != null) return false;
        if (recordtime != null ? !recordtime.equals(message.recordtime) : message.recordtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (messagetypeid != null ? messagetypeid.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (ifpublish != null ? ifpublish.hashCode() : 0);
        result = 31 * result + (recordtime != null ? recordtime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGETYPEID", referencedColumnName = "ID")
    public cn.mylife.entity.Messagetype getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Messagetype messagetype) {
        this.messagetype = messagetype;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "message")
    public Set<Messagetouser> getMessagetousers() {
        return messagetousers;
    }

    public void setMessagetousers(Set<Messagetouser> messagetousers) {
        this.messagetousers = messagetousers;
    }
}
