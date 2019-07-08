package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoCustomerEntity {
    //客户信息
    private String id;
    private String infoId; //项目id
    private String customerDwmc; //单位名称
    private String customerKhsx; //客户属性
    private String customerQrfs; //切入方式
    private String customerFzr; //负责人
    private String customerLxdh; //联系号码
    private String customerZw; //职务
    private String customerKs; //科室
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

    public String getCustomerDwmc() {
        return customerDwmc;
    }

    public void setCustomerDwmc(String customerDwmc) {
        this.customerDwmc = customerDwmc;
    }

    public String getCustomerKhsx() {
        return customerKhsx;
    }

    public void setCustomerKhsx(String customerKhsx) {
        this.customerKhsx = customerKhsx;
    }

    public String getCustomerQrfs() {
        return customerQrfs;
    }

    public void setCustomerQrfs(String customerQrfs) {
        this.customerQrfs = customerQrfs;
    }

    public String getCustomerFzr() {
        return customerFzr;
    }

    public void setCustomerFzr(String customerFzr) {
        this.customerFzr = customerFzr;
    }

    public String getCustomerLxdh() {
        return customerLxdh;
    }

    public void setCustomerLxdh(String customerLxdh) {
        this.customerLxdh = customerLxdh;
    }

    public String getCustomerZw() {
        return customerZw;
    }

    public void setCustomerZw(String customerZw) {
        this.customerZw = customerZw;
    }

    public String getCustomerKs() {
        return customerKs;
    }

    public void setCustomerKs(String customerKs) {
        this.customerKs = customerKs;
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
