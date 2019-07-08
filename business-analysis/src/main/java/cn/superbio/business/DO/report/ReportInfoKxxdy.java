package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_kxxdy")
public class ReportInfoKxxdy {
    private String id;
    private String infoId;
    private Double kxxdyYjhte;
    private String kxxdyZq;
    private Double kxxdyGm;
    private String kxxdyKexxcs;
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
