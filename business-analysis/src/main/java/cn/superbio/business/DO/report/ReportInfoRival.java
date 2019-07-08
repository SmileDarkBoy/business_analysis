package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_rival")
public class ReportInfoRival {
    private String id;
    private String infoId;
    private String rivalGsxx;
    private String rivalFzrxx;
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

    public String getRivalGsxx() {
        return rivalGsxx;
    }

    public void setRivalGsxx(String rivalGsxx) {
        this.rivalGsxx = rivalGsxx;
    }

    public String getRivalFzrxx() {
        return rivalFzrxx;
    }

    public void setRivalFzrxx(String rivalFzrxx) {
        this.rivalFzrxx = rivalFzrxx;
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
