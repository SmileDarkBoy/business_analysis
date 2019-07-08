package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoSqsxEntity {
    //申请失效
    private String id;
    private String infoId; //项目id
    private String sqsxSxyy; //失效原因
    private Date sqsxZbsj; //中标时间
    private String sqsxZbdw; //中标单位
    private String sqsxZbgs; //中标公示
    private String sqsxSxyycs; //失效原因称述
    private int sqsxShzt; //审核状态
    private String sqsxShr; //审核人
    private Date sqsxShsj; //审核时间
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

    public int getSqsxShzt() {
        return sqsxShzt;
    }

    public void setSqsxShzt(int sqsxShzt) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
