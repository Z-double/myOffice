package cn.mylife.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Fileinfo {
    private long id;
    private String name;
    private String filetypeid;
    private String remark;
    private String fileowner;
    private Time createdate;
    private Long parentid;
    private String path;
    private Long isdelete;
    private Filetypeinfo filetype;
    private Set<Accessoryfile> accessoryfiles;

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

    /*@Basic
    @Column(name = "FILETYPEID", nullable = true, length = 50)*/
    public String getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(String filetypeid) {
        this.filetypeid = filetypeid;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "FILEOWNER", nullable = true, length = 50)
    public String getFileowner() {
        return fileowner;
    }

    public void setFileowner(String fileowner) {
        this.fileowner = fileowner;
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
    @Column(name = "PARENTID", nullable = true, precision = 0)
    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    @Basic
    @Column(name = "PATH", nullable = true, length = 50)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "ISDELETE", nullable = true, precision = 0)
    public Long getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Long isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fileinfo fileinfo = (Fileinfo) o;

        if (id != fileinfo.id) return false;
        if (name != null ? !name.equals(fileinfo.name) : fileinfo.name != null) return false;
        if (filetypeid != null ? !filetypeid.equals(fileinfo.filetypeid) : fileinfo.filetypeid != null) return false;
        if (remark != null ? !remark.equals(fileinfo.remark) : fileinfo.remark != null) return false;
        if (fileowner != null ? !fileowner.equals(fileinfo.fileowner) : fileinfo.fileowner != null) return false;
        if (createdate != null ? !createdate.equals(fileinfo.createdate) : fileinfo.createdate != null) return false;
        if (parentid != null ? !parentid.equals(fileinfo.parentid) : fileinfo.parentid != null) return false;
        if (path != null ? !path.equals(fileinfo.path) : fileinfo.path != null) return false;
        if (isdelete != null ? !isdelete.equals(fileinfo.isdelete) : fileinfo.isdelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filetypeid != null ? filetypeid.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (fileowner != null ? fileowner.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (parentid != null ? parentid.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (isdelete != null ? isdelete.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FILETYPEID", referencedColumnName = "ID")
    public Filetypeinfo getFiletype() {
        return filetype;
    }

    public void setFiletype(Filetypeinfo filetype) {
        this.filetype = filetype;
    }

    @OneToMany(mappedBy = "fileinfo")
    public Set<Accessoryfile> getAccessoryfiles() {
        return accessoryfiles;
    }

    public void setAccessoryfiles(Set<Accessoryfile> accessoryfiles) {
        this.accessoryfiles = accessoryfiles;
    }
}

