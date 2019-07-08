package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoMemberEntity {
    //成员
    private String id;
    private String infoId; //项目id
    private String memberYgbh; //员工编号
    private String memberYgxm; //员工姓名
    private String memberZnzw; //组内职务
    private String memberLxdh; //联系电话
    private Date memberRzsj; //入组时间
    private Date memberLzsj; //离组时间
    private String memberLyfpbl; //利益分配比例
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
