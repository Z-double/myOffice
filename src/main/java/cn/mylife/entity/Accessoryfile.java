package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;

/**附件文件
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Accessoryfile {
    private long id;
    private String accessorypath;
    private String accessoryname;
    private Long accessorysize;
    private Long fileid;
    private Time createdate;
    private Long filetypeid;
    private Fileinfo fileinfo;
    private Filetypeinfo filetype;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCESSORYPATH", nullable = true, length = 50)
    public String getAccessorypath() {
        return accessorypath;
    }

    public void setAccessorypath(String accessorypath) {
        this.accessorypath = accessorypath;
    }

    @Basic
    @Column(name = "ACCESSORYNAME", nullable = true, length = 50)
    public String getAccessoryname() {
        return accessoryname;
    }

    public void setAccessoryname(String accessoryname) {
        this.accessoryname = accessoryname;
    }

    @Basic
    @Column(name = "ACCESSORYSIZE", nullable = true, precision = 0)
    public Long getAccessorysize() {
        return accessorysize;
    }

    public void setAccessorysize(Long accessorysize) {
        this.accessorysize = accessorysize;
    }

    @Basic
    @Column(name = "FILEID", nullable = true, precision = 0)
    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    @Basic
    @Column(name = "CREATEDATE", nullable = true)
    public Time getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Time createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "FILETYPEID", nullable = true, precision = 0)
    public Long getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(Long filetypeid) {
        this.filetypeid = filetypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accessoryfile that = (Accessoryfile) o;

        if (id != that.id) return false;
        if (accessorypath != null ? !accessorypath.equals(that.accessorypath) : that.accessorypath != null)
            return false;
        if (accessoryname != null ? !accessoryname.equals(that.accessoryname) : that.accessoryname != null)
            return false;
        if (accessorysize != null ? !accessorysize.equals(that.accessorysize) : that.accessorysize != null)
            return false;
        if (fileid != null ? !fileid.equals(that.fileid) : that.fileid != null) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;
        if (filetypeid != null ? !filetypeid.equals(that.filetypeid) : that.filetypeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accessorypath != null ? accessorypath.hashCode() : 0);
        result = 31 * result + (accessoryname != null ? accessoryname.hashCode() : 0);
        result = 31 * result + (accessorysize != null ? accessorysize.hashCode() : 0);
        result = 31 * result + (fileid != null ? fileid.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (filetypeid != null ? filetypeid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FILEID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Fileinfo getFileinfo() {
        return fileinfo;
    }

    public void setFileinfo(Fileinfo fileinfo) {
        this.fileinfo = fileinfo;
    }

    @ManyToOne
    @JoinColumn(name = "FILETYPEID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Filetypeinfo getFiletype() {
        return filetype;
    }

    public void setFiletype(Filetypeinfo filetype) {
        this.filetype = filetype;
    }
}
