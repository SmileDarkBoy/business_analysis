package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoKxxdyEntity {
    //可行性调研
    private String id;
    private String infoId; //项目id
    private Double kxxdyYjhte; //预计合同额
    private String kxxdyZq; //'预计周期
    private Double kxxdyGm; //预计规模
    private String kxxdyKexxcs; //可行性陈述
    private Date createDate; //创建时间
    private String createBy; //创建人
    private Integer status; //状态

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

    public Double getKxxdyYjhte() {
        return kxxdyYjhte;
    }

    public void setKxxdyYjhte(Double kxxdyYjhte) {
        this.kxxdyYjhte = kxxdyYjhte;
    }

    public String getKxxdyZq() {
        return kxxdyZq;
    }

    public void setKxxdyZq(String kxxdyZq) {
        this.kxxdyZq = kxxdyZq;
    }

    public Double getKxxdyGm() {
        return kxxdyGm;
    }

    public void setKxxdyGm(Double kxxdyGm) {
        this.kxxdyGm = kxxdyGm;
    }

    public String getKxxdyKexxcs() {
        return kxxdyKexxcs;
    }

    public void setKxxdyKexxcs(String kxxdyKexxcs) {
        this.kxxdyKexxcs = kxxdyKexxcs;
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
