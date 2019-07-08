package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_sqsx")
public class ReportInfoSqsx {
    private String id;
    private String infoId;
    private String sqsxSxyy;
    private Date sqsxZbsj;
    private String sqsxZbdw;
    private String sqsxZbgs;
    private String sqsxSxyycs;
    private Integer sqsxShzt;
    private String sqsxShr;
    private Date sqsxShsj;
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

    public String getSqsxSxyy() {
        return sqsxSxyy;
    }

    public void setSqsxSxyy(String sqsxSxyy) {
        this.sqsxSxyy = sqsxSxyy;
    }

    public Date getSqsxZbsj() {
        return sqsxZbsj;
    }

    public void setSqsxZbsj(Date sqsxZbsj) {
        this.sqsxZbsj = sqsxZbsj;
    }

    public String getSqsxZbdw() {
        return sqsxZbdw;
    }

    public void setSqsxZbdw(String sqsxZbdw) {
        this.sqsxZbdw = sqsxZbdw;
    }

    public String getSqsxZbgs() {
        return sqsxZbgs;
    }

    public void setSqsxZbgs(String sqsxZbgs) {
        this.sqsxZbgs = sqsxZbgs;
    }

    public String getSqsxSxyycs() {
        return sqsxSxyycs;
    }

    public void setSqsxSxyycs(String sqsxSxyycs) {
        this.sqsxSxyycs = sqsxSxyycs;
    }

    public Integer getSqsxShzt() {
        return sqsxShzt;
    }

    public void setSqsxShzt(Integer sqsxShzt) {
        this.sqsxShzt = sqsxShzt;
    }

    public String getSqsxShr() {
        return sqsxShr;
    }

    public void setSqsxShr(String sqsxShr) {
        this.sqsxShr = sqsxShr;
    }

    public Date getSqsxShsj() {
        return sqsxShsj;
    }

    public void setSqsxShsj(Date sqsxShsj) {
        this.sqsxShsj = sqsxShsj;
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
