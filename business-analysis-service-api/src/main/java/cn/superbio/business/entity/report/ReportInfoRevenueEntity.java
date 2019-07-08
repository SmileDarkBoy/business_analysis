package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoRevenueEntity {
    //收入信息
    private String id;
    private String infoId; //项目id
    private String revenueGssyb; // 归属事业部
    private String revenueGsejbm; // 归属二级部门
    private String revenueGssjbm; // 归属三级部门
    private String revenueGsr; // 归属人
    private String revenueGsrgh; // 归属人工号
    private Date revenueLxrq; // 立项日期
    private String revenueYw; // 业务
    private String revenueXm; // 项目
    private String revenueDq; // 地区
    private String revenueKhlx; // 客户类型
    private Date revenueDzrq; // 到账日期
    private Double revenueHkje; // 回款金额
    private String revenueCwbz; // 财务备注
    private Date createDate; //创建时间
    private String createBy; //创建人
    private int status; //状态

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
