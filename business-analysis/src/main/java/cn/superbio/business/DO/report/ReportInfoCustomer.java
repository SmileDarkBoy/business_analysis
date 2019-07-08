package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName("business_report_info_customer")
public class ReportInfoCustomer {
    private String id;
    private String infoId;
    private String customerDwmc;
    private String customerKhsx;
    private String customerQrfs;
    private String customerFzr;
    private String customerLxdh;
    private String customerZw;
    private String customerKs;
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
