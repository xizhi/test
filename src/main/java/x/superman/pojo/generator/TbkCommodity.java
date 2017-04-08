package x.superman.pojo.generator;

import java.io.Serializable;

public class TbkCommodity implements Serializable {
    private String id;

    private String spid;

    private String spmc;

    private String spzt;

    private String spxqy;

    private String smyjlm;

    private String tbklj;

    private String spjg;

    private String spysl;

    private String srbl;

    private String yj;

    private String mjww;

    private String mjid;

    private String dpmc;

    private String ptlx;

    private String yhqid;

    private String yhqzl;

    private String yhqsyl;

    private String yhqme;

    private String yhqkssj;

    private String yhqjssj;

    private String yhqlj;

    private String spyhqtglj;

    private Integer uploadId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid == null ? null : spid.trim();
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc == null ? null : spmc.trim();
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt == null ? null : spzt.trim();
    }

    public String getSpxqy() {
        return spxqy;
    }

    public void setSpxqy(String spxqy) {
        this.spxqy = spxqy == null ? null : spxqy.trim();
    }

    public String getSmyjlm() {
        return smyjlm;
    }

    public void setSmyjlm(String smyjlm) {
        this.smyjlm = smyjlm == null ? null : smyjlm.trim();
    }

    public String getTbklj() {
        return tbklj;
    }

    public void setTbklj(String tbklj) {
        this.tbklj = tbklj == null ? null : tbklj.trim();
    }

    public String getSpjg() {
        return spjg;
    }

    public void setSpjg(String spjg) {
        this.spjg = spjg == null ? null : spjg.trim();
    }

    public String getSpysl() {
        return spysl;
    }

    public void setSpysl(String spysl) {
        this.spysl = spysl == null ? null : spysl.trim();
    }

    public String getSrbl() {
        return srbl;
    }

    public void setSrbl(String srbl) {
        this.srbl = srbl == null ? null : srbl.trim();
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj == null ? null : yj.trim();
    }

    public String getMjww() {
        return mjww;
    }

    public void setMjww(String mjww) {
        this.mjww = mjww == null ? null : mjww.trim();
    }

    public String getMjid() {
        return mjid;
    }

    public void setMjid(String mjid) {
        this.mjid = mjid == null ? null : mjid.trim();
    }

    public String getDpmc() {
        return dpmc;
    }

    public void setDpmc(String dpmc) {
        this.dpmc = dpmc == null ? null : dpmc.trim();
    }

    public String getPtlx() {
        return ptlx;
    }

    public void setPtlx(String ptlx) {
        this.ptlx = ptlx == null ? null : ptlx.trim();
    }

    public String getYhqid() {
        return yhqid;
    }

    public void setYhqid(String yhqid) {
        this.yhqid = yhqid == null ? null : yhqid.trim();
    }

    public String getYhqzl() {
        return yhqzl;
    }

    public void setYhqzl(String yhqzl) {
        this.yhqzl = yhqzl == null ? null : yhqzl.trim();
    }

    public String getYhqsyl() {
        return yhqsyl;
    }

    public void setYhqsyl(String yhqsyl) {
        this.yhqsyl = yhqsyl == null ? null : yhqsyl.trim();
    }

    public String getYhqme() {
        return yhqme;
    }

    public void setYhqme(String yhqme) {
        this.yhqme = yhqme == null ? null : yhqme.trim();
    }

    public String getYhqkssj() {
        return yhqkssj;
    }

    public void setYhqkssj(String yhqkssj) {
        this.yhqkssj = yhqkssj == null ? null : yhqkssj.trim();
    }

    public String getYhqjssj() {
        return yhqjssj;
    }

    public void setYhqjssj(String yhqjssj) {
        this.yhqjssj = yhqjssj == null ? null : yhqjssj.trim();
    }

    public String getYhqlj() {
        return yhqlj;
    }

    public void setYhqlj(String yhqlj) {
        this.yhqlj = yhqlj == null ? null : yhqlj.trim();
    }

    public String getSpyhqtglj() {
        return spyhqtglj;
    }

    public void setSpyhqtglj(String spyhqtglj) {
        this.spyhqtglj = spyhqtglj == null ? null : spyhqtglj.trim();
    }

    public Integer getUploadId() {
        return uploadId;
    }

    public void setUploadId(Integer uploadId) {
        this.uploadId = uploadId;
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
        TbkCommodity other = (TbkCommodity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpid() == null ? other.getSpid() == null : this.getSpid().equals(other.getSpid()))
            && (this.getSpmc() == null ? other.getSpmc() == null : this.getSpmc().equals(other.getSpmc()))
            && (this.getSpzt() == null ? other.getSpzt() == null : this.getSpzt().equals(other.getSpzt()))
            && (this.getSpxqy() == null ? other.getSpxqy() == null : this.getSpxqy().equals(other.getSpxqy()))
            && (this.getSmyjlm() == null ? other.getSmyjlm() == null : this.getSmyjlm().equals(other.getSmyjlm()))
            && (this.getTbklj() == null ? other.getTbklj() == null : this.getTbklj().equals(other.getTbklj()))
            && (this.getSpjg() == null ? other.getSpjg() == null : this.getSpjg().equals(other.getSpjg()))
            && (this.getSpysl() == null ? other.getSpysl() == null : this.getSpysl().equals(other.getSpysl()))
            && (this.getSrbl() == null ? other.getSrbl() == null : this.getSrbl().equals(other.getSrbl()))
            && (this.getYj() == null ? other.getYj() == null : this.getYj().equals(other.getYj()))
            && (this.getMjww() == null ? other.getMjww() == null : this.getMjww().equals(other.getMjww()))
            && (this.getMjid() == null ? other.getMjid() == null : this.getMjid().equals(other.getMjid()))
            && (this.getDpmc() == null ? other.getDpmc() == null : this.getDpmc().equals(other.getDpmc()))
            && (this.getPtlx() == null ? other.getPtlx() == null : this.getPtlx().equals(other.getPtlx()))
            && (this.getYhqid() == null ? other.getYhqid() == null : this.getYhqid().equals(other.getYhqid()))
            && (this.getYhqzl() == null ? other.getYhqzl() == null : this.getYhqzl().equals(other.getYhqzl()))
            && (this.getYhqsyl() == null ? other.getYhqsyl() == null : this.getYhqsyl().equals(other.getYhqsyl()))
            && (this.getYhqme() == null ? other.getYhqme() == null : this.getYhqme().equals(other.getYhqme()))
            && (this.getYhqkssj() == null ? other.getYhqkssj() == null : this.getYhqkssj().equals(other.getYhqkssj()))
            && (this.getYhqjssj() == null ? other.getYhqjssj() == null : this.getYhqjssj().equals(other.getYhqjssj()))
            && (this.getYhqlj() == null ? other.getYhqlj() == null : this.getYhqlj().equals(other.getYhqlj()))
            && (this.getSpyhqtglj() == null ? other.getSpyhqtglj() == null : this.getSpyhqtglj().equals(other.getSpyhqtglj()))
            && (this.getUploadId() == null ? other.getUploadId() == null : this.getUploadId().equals(other.getUploadId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpid() == null) ? 0 : getSpid().hashCode());
        result = prime * result + ((getSpmc() == null) ? 0 : getSpmc().hashCode());
        result = prime * result + ((getSpzt() == null) ? 0 : getSpzt().hashCode());
        result = prime * result + ((getSpxqy() == null) ? 0 : getSpxqy().hashCode());
        result = prime * result + ((getSmyjlm() == null) ? 0 : getSmyjlm().hashCode());
        result = prime * result + ((getTbklj() == null) ? 0 : getTbklj().hashCode());
        result = prime * result + ((getSpjg() == null) ? 0 : getSpjg().hashCode());
        result = prime * result + ((getSpysl() == null) ? 0 : getSpysl().hashCode());
        result = prime * result + ((getSrbl() == null) ? 0 : getSrbl().hashCode());
        result = prime * result + ((getYj() == null) ? 0 : getYj().hashCode());
        result = prime * result + ((getMjww() == null) ? 0 : getMjww().hashCode());
        result = prime * result + ((getMjid() == null) ? 0 : getMjid().hashCode());
        result = prime * result + ((getDpmc() == null) ? 0 : getDpmc().hashCode());
        result = prime * result + ((getPtlx() == null) ? 0 : getPtlx().hashCode());
        result = prime * result + ((getYhqid() == null) ? 0 : getYhqid().hashCode());
        result = prime * result + ((getYhqzl() == null) ? 0 : getYhqzl().hashCode());
        result = prime * result + ((getYhqsyl() == null) ? 0 : getYhqsyl().hashCode());
        result = prime * result + ((getYhqme() == null) ? 0 : getYhqme().hashCode());
        result = prime * result + ((getYhqkssj() == null) ? 0 : getYhqkssj().hashCode());
        result = prime * result + ((getYhqjssj() == null) ? 0 : getYhqjssj().hashCode());
        result = prime * result + ((getYhqlj() == null) ? 0 : getYhqlj().hashCode());
        result = prime * result + ((getSpyhqtglj() == null) ? 0 : getSpyhqtglj().hashCode());
        result = prime * result + ((getUploadId() == null) ? 0 : getUploadId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spid=").append(spid);
        sb.append(", spmc=").append(spmc);
        sb.append(", spzt=").append(spzt);
        sb.append(", spxqy=").append(spxqy);
        sb.append(", smyjlm=").append(smyjlm);
        sb.append(", tbklj=").append(tbklj);
        sb.append(", spjg=").append(spjg);
        sb.append(", spysl=").append(spysl);
        sb.append(", srbl=").append(srbl);
        sb.append(", yj=").append(yj);
        sb.append(", mjww=").append(mjww);
        sb.append(", mjid=").append(mjid);
        sb.append(", dpmc=").append(dpmc);
        sb.append(", ptlx=").append(ptlx);
        sb.append(", yhqid=").append(yhqid);
        sb.append(", yhqzl=").append(yhqzl);
        sb.append(", yhqsyl=").append(yhqsyl);
        sb.append(", yhqme=").append(yhqme);
        sb.append(", yhqkssj=").append(yhqkssj);
        sb.append(", yhqjssj=").append(yhqjssj);
        sb.append(", yhqlj=").append(yhqlj);
        sb.append(", spyhqtglj=").append(spyhqtglj);
        sb.append(", uploadId=").append(uploadId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}