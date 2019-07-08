package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_revenue")
public class ReportInfoRevenue {
    private String id;
    private String infoId;
    private String revenueGssyb;
    private String revenueGsejbm;
    private String revenueGssjbm;
    private String revenueGsr;
    private String revenueGsrgh;
    private Date revenueLxrq;
    private String revenueYw;
    private String revenueXm;
    private String revenueDq;
    private String revenueKhlx;
    private Date revenueDzrq;
    private Double revenueHkje;
    private String revenueCwbz;
    private Date createDate;
    private String createBy;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getRevenueGssyb() {
        return revenueGssyb;
    }

    public void setRevenueGssyb(String revenueGssyb) {
        this.revenueGssyb = revenueGssyb;
    }

    public String getRevenueGsejbm() {
        return revenueGsejbm;
    }

    public void setRevenueGsejbm(String revenueGsejbm) {
        this.revenueGsejbm = revenueGsejbm;
    }

    public String getRevenueGssjbm() {
        return revenueGssjbm;
    }

    public void setRevenueGssjbm(String revenueGssjbm) {
        this.revenueGssjbm = revenueGssjbm;
    }

    public String getRevenueGsr() {
        return revenueGsr;
    }

    public void setRevenueGsr(String revenueGsr) {
        this.revenueGsr = revenueGsr;
    }

    public String getRevenueGsrgh() {
        return revenueGsrgh;
    }

    public void setRevenueGsrgh(String revenueGsrgh) {
        this.revenueGsrgh = revenueGsrgh;
    }

    public Date getRevenueLxrq() {
        return revenueLxrq;
    }

    public void setRevenueLxrq(Date revenueLxrq) {
        this.revenueLxrq = revenueLxrq;
    }

    public String getRevenueYw() {
        return revenueYw;
    }

    public void setRevenueYw(String revenueYw) {
        this.revenueYw = revenueYw;
    }

    public String getRevenueXm() {
        return revenueXm;
    }

    public void setRevenueXm(String revenueXm) {
        this.revenueXm = revenueXm;
    }

    public String getRevenueDq() {
        return revenueDq;
    }

    public void setRevenueDq(String revenueDq) {
        this.revenueDq = revenueDq;
    }

    public String getRevenueKhlx() {
        return revenueKhlx;
    }

    public void setRevenueKhlx(String revenueKhlx) {
        this.revenueKhlx = revenueKhlx;
    }

    public Date getRevenueDzrq() {
        return revenueDzrq;
    }

    public void setRevenueDzrq(Date revenueDzrq) {
        this.revenueDzrq = revenueDzrq;
    }

    public Double getRevenueHkje() {
        return revenueHkje;
    }

    public void setRevenueHkje(Double revenueHkje) {
        this.revenueHkje = revenueHkje;
    }

    public String getRevenueCwbz() {
        return revenueCwbz;
    }

    public void setRevenueCwbz(String revenueCwbz) {
        this.revenueCwbz = revenueCwbz;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
