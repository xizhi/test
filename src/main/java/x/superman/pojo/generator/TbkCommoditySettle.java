package x.superman.pojo.generator;

import java.io.Serializable;
import java.util.Date;

public class TbkCommoditySettle implements Serializable {
    private String id;

    private String mc;

    private String lm;

    private String zt;

    private Double jg;

    private Double yxl;

    private Double srbl;

    private Double yj;

    private String ptlx;

    private Integer yhqSl;

    private Integer yhqSy;

    private String yhqMe;

    private Double yhqJe;

    private Date yhqSksj;

    private Date yhqJssj;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc == null ? null : mc.trim();
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm == null ? null : lm.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public Double getJg() {
        return jg;
    }

    public void setJg(Double jg) {
        this.jg = jg;
    }

    public Double getYxl() {
        return yxl;
    }

    public void setYxl(Double yxl) {
        this.yxl = yxl;
    }

    public Double getSrbl() {
        return srbl;
    }

    public void setSrbl(Double srbl) {
        this.srbl = srbl;
    }

    public Double getYj() {
        return yj;
    }

    public void setYj(Double yj) {
        this.yj = yj;
    }

    public String getPtlx() {
        return ptlx;
    }

    public void setPtlx(String ptlx) {
        this.ptlx = ptlx == null ? null : ptlx.trim();
    }

    public Integer getYhqSl() {
        return yhqSl;
    }

    public void setYhqSl(Integer yhqSl) {
        this.yhqSl = yhqSl;
    }

    public Integer getYhqSy() {
        return yhqSy;
    }

    public void setYhqSy(Integer yhqSy) {
        this.yhqSy = yhqSy;
    }

    public String getYhqMe() {
        return yhqMe;
    }

    public void setYhqMe(String yhqMe) {
        this.yhqMe = yhqMe == null ? null : yhqMe.trim();
    }

    public Double getYhqJe() {
        return yhqJe;
    }

    public void setYhqJe(Double yhqJe) {
        this.yhqJe = yhqJe;
    }

    public Date getYhqSksj() {
        return yhqSksj;
    }

    public void setYhqSksj(Date yhqSksj) {
        this.yhqSksj = yhqSksj;
    }

    public Date getYhqJssj() {
        return yhqJssj;
    }

    public void setYhqJssj(Date yhqJssj) {
        this.yhqJssj = yhqJssj;
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
        TbkCommoditySettle other = (TbkCommoditySettle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getLm() == null ? other.getLm() == null : this.getLm().equals(other.getLm()))
            && (this.getZt() == null ? other.getZt() == null : this.getZt().equals(other.getZt()))
            && (this.getJg() == null ? other.getJg() == null : this.getJg().equals(other.getJg()))
            && (this.getYxl() == null ? other.getYxl() == null : this.getYxl().equals(other.getYxl()))
            && (this.getSrbl() == null ? other.getSrbl() == null : this.getSrbl().equals(other.getSrbl()))
            && (this.getYj() == null ? other.getYj() == null : this.getYj().equals(other.getYj()))
            && (this.getPtlx() == null ? other.getPtlx() == null : this.getPtlx().equals(other.getPtlx()))
            && (this.getYhqSl() == null ? other.getYhqSl() == null : this.getYhqSl().equals(other.getYhqSl()))
            && (this.getYhqSy() == null ? other.getYhqSy() == null : this.getYhqSy().equals(other.getYhqSy()))
            && (this.getYhqMe() == null ? other.getYhqMe() == null : this.getYhqMe().equals(other.getYhqMe()))
            && (this.getYhqJe() == null ? other.getYhqJe() == null : this.getYhqJe().equals(other.getYhqJe()))
            && (this.getYhqSksj() == null ? other.getYhqSksj() == null : this.getYhqSksj().equals(other.getYhqSksj()))
            && (this.getYhqJssj() == null ? other.getYhqJssj() == null : this.getYhqJssj().equals(other.getYhqJssj()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getLm() == null) ? 0 : getLm().hashCode());
        result = prime * result + ((getZt() == null) ? 0 : getZt().hashCode());
        result = prime * result + ((getJg() == null) ? 0 : getJg().hashCode());
        result = prime * result + ((getYxl() == null) ? 0 : getYxl().hashCode());
        result = prime * result + ((getSrbl() == null) ? 0 : getSrbl().hashCode());
        result = prime * result + ((getYj() == null) ? 0 : getYj().hashCode());
        result = prime * result + ((getPtlx() == null) ? 0 : getPtlx().hashCode());
        result = prime * result + ((getYhqSl() == null) ? 0 : getYhqSl().hashCode());
        result = prime * result + ((getYhqSy() == null) ? 0 : getYhqSy().hashCode());
        result = prime * result + ((getYhqMe() == null) ? 0 : getYhqMe().hashCode());
        result = prime * result + ((getYhqJe() == null) ? 0 : getYhqJe().hashCode());
        result = prime * result + ((getYhqSksj() == null) ? 0 : getYhqSksj().hashCode());
        result = prime * result + ((getYhqJssj() == null) ? 0 : getYhqJssj().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mc=").append(mc);
        sb.append(", lm=").append(lm);
        sb.append(", zt=").append(zt);
        sb.append(", jg=").append(jg);
        sb.append(", yxl=").append(yxl);
        sb.append(", srbl=").append(srbl);
        sb.append(", yj=").append(yj);
        sb.append(", ptlx=").append(ptlx);
        sb.append(", yhqSl=").append(yhqSl);
        sb.append(", yhqSy=").append(yhqSy);
        sb.append(", yhqMe=").append(yhqMe);
        sb.append(", yhqJe=").append(yhqJe);
        sb.append(", yhqSksj=").append(yhqSksj);
        sb.append(", yhqJssj=").append(yhqJssj);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}