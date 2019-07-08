package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoRivalEntity {
    //竞争对手
    private String id;
    private String infoId; //项目id
    private String rivalGsxx; //公司信息
    private String rivalFzrxx; //负责人信息
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
