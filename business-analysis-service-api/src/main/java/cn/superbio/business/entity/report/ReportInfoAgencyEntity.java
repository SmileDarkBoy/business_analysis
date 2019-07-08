package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoAgencyEntity {
    //代理商信息
    private String id;
    private String infoId; //项目id
    private String agencyDlsqc; //代理商全称
    private String agencyLxrxm; //联系人姓名
    private String agencyLxdh; //联系电话
    private Date createDate; //创建时间
    private String createBy; //创建人
    private Integer status; //状态
    private String agencyAreaCode;
    private String agencyAreaName;

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

    public String getAgencyDlsqc() {
        return agencyDlsqc;
    }

    public void setAgencyDlsqc(String agencyDlsqc) {
        this.agencyDlsqc = agencyDlsqc;
    }

    public String getAgencyLxrxm() {
        return agencyLxrxm;
    }

    public void setAgencyLxrxm(String agencyLxrxm) {
        this.agencyLxrxm = agencyLxrxm;
    }

    public String getAgencyLxdh() {
        return agencyLxdh;
    }

    public void setAgencyLxdh(String agencyLxdh) {
        this.agencyLxdh = agencyLxdh;
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

    public String getAgencyAreaCode() {
        return agencyAreaCode;
    }

    public void setAgencyAreaCode(String agencyAreaCode) {
        this.agencyAreaCode = agencyAreaCode;
    }

    public String getAgencyAreaName() {
        return agencyAreaName;
    }

    public void setAgencyAreaName(String agencyAreaName) {
        this.agencyAreaName = agencyAreaName;
    }
}
