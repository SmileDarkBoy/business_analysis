package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoFollowingEntity {
    //跟踪记录
    private String id;
    private String infoId; //项目id
    private String followingDjr; //登记人
    private String followingGznr; //跟踪内容
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

    public String getFollowingDjr() {
        return followingDjr;
    }

    public void setFollowingDjr(String followingDjr) {
        this.followingDjr = followingDjr;
    }

    public String getFollowingGznr() {
        return followingGznr;
    }

    public void setFollowingGznr(String followingGznr) {
        this.followingGznr = followingGznr;
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
