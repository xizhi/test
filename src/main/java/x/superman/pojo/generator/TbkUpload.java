package x.superman.pojo.generator;

import java.io.Serializable;
import java.util.Date;

public class TbkUpload implements Serializable {
    private Integer id;

    private String name;

    private String path;

    private Date creationTime;

    private Integer count;

    private Integer countRepeat;

    private Date rettleTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountRepeat() {
        return countRepeat;
    }

    public void setCountRepeat(Integer countRepeat) {
        this.countRepeat = countRepeat;
    }

    public Date getRettleTime() {
        return rettleTime;
    }

    public void setRettleTime(Date rettleTime) {
        this.rettleTime = rettleTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbkUpload other = (TbkUpload) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getCountRepeat() == null ? other.getCountRepeat() == null : this.getCountRepeat().equals(other.getCountRepeat()))
            && (this.getRettleTime() == null ? other.getRettleTime() == null : this.getRettleTime().equals(other.getRettleTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getCreationTime() == null) ? 0 : getCreationTime().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getCountRepeat() == null) ? 0 : getCountRepeat().hashCode());
        result = prime * result + ((getRettleTime() == null) ? 0 : getRettleTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", path=").append(path);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", count=").append(count);
        sb.append(", countRepeat=").append(countRepeat);
        sb.append(", rettleTime=").append(rettleTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}