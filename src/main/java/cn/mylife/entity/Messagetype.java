package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/26.
 */
@Entity
public class Messagetype {
    private long id;
    private String messagetypename;
    private String messagedesc;
    private Set<Message> messages;
    private Set<Readcommonmessage> readconmessages;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MESSAGETYPENAME", nullable = true, length = 50)
    public String getMessagetypename() {
        return messagetypename;
    }

    public void setMessagetypename(String messagetypename) {
        this.messagetypename = messagetypename;
    }

    @Basic
    @Column(name = "MESSAGEDESC", nullable = true, length = 50)
    public String getMessagedesc() {
        return messagedesc;
    }

    public void setMessagedesc(String messagedesc) {
        this.messagedesc = messagedesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messagetype that = (Messagetype) o;

        if (id != that.id) return false;
        if (messagetypename != null ? !messagetypename.equals(that.messagetypename) : that.messagetypename != null)
            return false;
        if (messagedesc != null ? !messagedesc.equals(that.messagedesc) : that.messagedesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (messagetypename != null ? messagetypename.hashCode() : 0);
        result = 31 * result + (messagedesc != null ? messagedesc.hashCode() : 0);
        return result;
    }
    @OneToMany(mappedBy = "messagetype")
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "message")
    public Set<Readcommonmessage> getReadconmessages() {
        return readconmessages;
    }

    public void setReadconmessages(Set<Readcommonmessage> readconmessages) {
        this.readconmessages = readconmessages;
    }

}
