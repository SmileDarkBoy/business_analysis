package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_member")
public class ReportInfoMember {
    private String id;
    private String infoId;
    private String memberYgbh;
    private String memberYgxm;
    private String memberZnzw;
    private String memberLxdh;
    private Date memberRzsj;
    private Date memberLzsj;
    private String memberLyfpbl;
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

    public String getMemberYgbh() {
        return memberYgbh;
    }

    public void setMemberYgbh(String memberYgbh) {
        this.memberYgbh = memberYgbh;
    }

    public String getMemberYgxm() {
        return memberYgxm;
    }

    public void setMemberYgxm(String memberYgxm) {
        this.memberYgxm = memberYgxm;
    }

    public String getMemberZnzw() {
        return memberZnzw;
    }

    public void setMemberZnzw(String memberZnzw) {
        this.memberZnzw = memberZnzw;
    }

    public String getMemberLxdh() {
        return memberLxdh;
    }

    public void setMemberLxdh(String memberLxdh) {
        this.memberLxdh = memberLxdh;
    }

    public Date getMemberRzsj() {
        return memberRzsj;
    }

    public void setMemberRzsj(Date memberRzsj) {
        this.memberRzsj = memberRzsj;
    }

    public Date getMemberLzsj() {
        return memberLzsj;
    }

    public void setMemberLzsj(Date memberLzsj) {
        this.memberLzsj = memberLzsj;
    }

    public String getMemberLyfpbl() {
        return memberLyfpbl;
    }

    public void setMemberLyfpbl(String memberLyfpbl) {
        this.memberLyfpbl = memberLyfpbl;
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
