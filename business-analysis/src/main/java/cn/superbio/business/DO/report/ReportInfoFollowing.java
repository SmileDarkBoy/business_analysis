package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_following")
public class ReportInfoFollowing {
    private String id;
    private String infoId;
    private String followingDjr;
    private String followingGznr;
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
