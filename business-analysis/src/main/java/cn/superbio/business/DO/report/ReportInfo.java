package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info")
public class ReportInfo {
    private String id;
    private String infoXmbm;
    private String infoYwlx;
    private String infoXmlx;
    private String areaCode;
    private String infoSsdq;
    private String infoSsxq;
    private String infoFzr;
    private String infoGsbm;
    private String infoJfly;
    private Double infoXmys;
    private String infoZbfs;
    private Date infoZbsj;
    private Integer infoSfztb;
    private Integer infoSfclxmz;
    private String infoBz;
    private String infoXmzt;
    private Date createDate;
    private String createBy;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoXmbm() {
        return infoXmbm;
    }

    public void setInfoXmbm(String infoXmbm) {
        this.infoXmbm = infoXmbm;
    }

    public String getInfoYwlx() {
        return infoYwlx;
    }

    public void setInfoYwlx(String infoYwlx) {
        this.infoYwlx = infoYwlx;
    }

    public String getInfoXmlx() {
        return infoXmlx;
    }

    public void setInfoXmlx(String infoXmlx) {
        this.infoXmlx = infoXmlx;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getInfoSsdq() {
        return infoSsdq;
    }

    public void setInfoSsdq(String infoSsdq) {
        this.infoSsdq = infoSsdq;
    }

    public String getInfoSsxq() {
        return infoSsxq;
    }

    public void setInfoSsxq(String infoSsxq) {
        this.infoSsxq = infoSsxq;
    }

    public String getInfoFzr() {
        return infoFzr;
    }

    public void setInfoFzr(String infoFzr) {
        this.infoFzr = infoFzr;
    }

    public String getInfoGsbm() {
        return infoGsbm;
    }

    public void setInfoGsbm(String infoGsbm) {
        this.infoGsbm = infoGsbm;
    }

    public String getInfoJfly() {
        return infoJfly;
    }

    public void setInfoJfly(String infoJfly) {
        this.infoJfly = infoJfly;
    }

    public Double getInfoXmys() {
        return infoXmys;
    }

    public void setInfoXmys(Double infoXmys) {
        this.infoXmys = infoXmys;
    }

    public String getInfoZbfs() {
        return infoZbfs;
    }

    public void setInfoZbfs(String infoZbfs) {
        this.infoZbfs = infoZbfs;
    }

    public Date getInfoZbsj() {
        return infoZbsj;
    }

    public void setInfoZbsj(Date infoZbsj) {
        this.infoZbsj = infoZbsj;
    }

    public Integer getInfoSfztb() {
        return infoSfztb;
    }

    public void setInfoSfztb(Integer infoSfztb) {
        this.infoSfztb = infoSfztb;
    }

    public Integer getInfoSfclxmz() {
        return infoSfclxmz;
    }

    public void setInfoSfclxmz(Integer infoSfclxmz) {
        this.infoSfclxmz = infoSfclxmz;
    }

    public String getInfoBz() {
        return infoBz;
    }

    public void setInfoBz(String infoBz) {
        this.infoBz = infoBz;
    }

    public String getInfoXmzt() {
        return infoXmzt;
    }

    public void setInfoXmzt(String infoXmzt) {
        this.infoXmzt = infoXmzt;
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
