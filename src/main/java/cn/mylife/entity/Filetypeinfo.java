package cn.mylife.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yzz on 2017/10/31.
 */
@Entity
public class Filetypeinfo {
    private long id;
    private String name;
    private String typeimage;
    private String typesuffix;
    private Set<Fileinfo> fileinfos;
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

    @Basic
    @Column(name = "TYPEIMAGE", nullable = true, length = 50)
    public String getTypeimage() {
        return typeimage;
    }

    public void setTypeimage(String typeimage) {
        this.typeimage = typeimage;
    }

    @Basic
    @Column(name = "TYPESUFFIX", nullable = true, length = 20)
    public String getTypesuffix() {
        return typesuffix;
    }

    public void setTypesuffix(String typesuffix) {
        this.typesuffix = typesuffix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filetypeinfo that = (Filetypeinfo) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typeimage != null ? !typeimage.equals(that.typeimage) : that.typeimage != null) return false;
        if (typesuffix != null ? !typesuffix.equals(that.typesuffix) : that.typesuffix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeimage != null ? typeimage.hashCode() : 0);
        result = 31 * result + (typesuffix != null ? typesuffix.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "filetype")
    public Set<Fileinfo> getFileinfos() {
        return fileinfos;
    }

    public void setFileinfos(Set<Fileinfo> fileinfos) {
        this.fileinfos = fileinfos;
    }

    @OneToMany(mappedBy = "filetype")
    public Set<Accessoryfile> getAccessoryfiles() {
        return accessoryfiles;
    }

    public void setAccessoryfiles(Set<Accessoryfile> accessoryfiles) {
        this.accessoryfiles = accessoryfiles;
    }
}
