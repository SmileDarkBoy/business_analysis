package cn.superbio.business.entity.report;

import cn.superbio.business.entity.sys.SysFileUploadEntity;

import java.util.Date;
import java.util.List;

public class ReportInfoCjshEntity {
    //成交审核
    private String id;
    private String infoId; //项目id
    private String cjshJfmc; //甲方名称
    private String cjshYfmc; //乙方名称
    private String cjshHzlx; //合作类型
    private Date cjshHtqsrq; //合同签署日期
    private Double cjshHtje; //合同金额
    private Date cjshHkrq; //回款日期
    private Double cjshYszk; //应收账款
    private Date cjshHtsxrq; //合同生效日期
    private String cjshBz; //备注说明
    private Date cjshZbsj; //中标时间
    private String cjshZbdw; //中标单位
    private String cjshZbgs; //中标公示
    private Integer cjshShzt; //审核状态
    private String cjshShr; //审核人
    private Date cjshShsj; //审核时间
    private Date createDate; //
    private String createBy; //创建人
    private Integer status; //状态
    private Date cjshGsrq; //公示日期

    private List<String> files;

    public Date getCjshGsrq() {
        return cjshGsrq;
    }

    public void setCjshGsrq(Date cjshGsrq) {
        this.cjshGsrq = cjshGsrq;
    }

    private List<SysFileUploadEntity> fileUploadEntityList;

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

    public String getCjshJfmc() {
        return cjshJfmc;
    }

    public void setCjshJfmc(String cjshJfmc) {
        this.cjshJfmc = cjshJfmc;
    }

    public String getCjshYfmc() {
        return cjshYfmc;
    }

    public void setCjshYfmc(String cjshYfmc) {
        this.cjshYfmc = cjshYfmc;
    }

    public String getCjshHzlx() {
        return cjshHzlx;
    }

    public void setCjshHzlx(String cjshHzlx) {
        this.cjshHzlx = cjshHzlx;
    }

    public Date getCjshHtqsrq() {
        return cjshHtqsrq;
    }

    public void setCjshHtqsrq(Date cjshHtqsrq) {
        this.cjshHtqsrq = cjshHtqsrq;
    }

    public Double getCjshHtje() {
        return cjshHtje;
    }

    public void setCjshHtje(Double cjshHtje) {
        this.cjshHtje = cjshHtje;
    }

    public Date getCjshHkrq() {
        return cjshHkrq;
    }

    public void setCjshHkrq(Date cjshHkrq) {
        this.cjshHkrq = cjshHkrq;
    }

    public Double getCjshYszk() {
        return cjshYszk;
    }

    public void setCjshYszk(Double cjshYszk) {
        this.cjshYszk = cjshYszk;
    }

    public Date getCjshHtsxrq() {
        return cjshHtsxrq;
    }

    public void setCjshHtsxrq(Date cjshHtsxrq) {
        this.cjshHtsxrq = cjshHtsxrq;
    }

    public String getCjshBz() {
        return cjshBz;
    }

    public void setCjshBz(String cjshBz) {
        this.cjshBz = cjshBz;
    }

    public Date getCjshZbsj() {
        return cjshZbsj;
    }

    public void setCjshZbsj(Date cjshZbsj) {
        this.cjshZbsj = cjshZbsj;
    }

    public String getCjshZbdw() {
        return cjshZbdw;
    }

    public void setCjshZbdw(String cjshZbdw) {
        this.cjshZbdw = cjshZbdw;
    }

    public String getCjshZbgs() {
        return cjshZbgs;
    }

    public void setCjshZbgs(String cjshZbgs) {
        this.cjshZbgs = cjshZbgs;
    }

    public Integer getCjshShzt() {
        return cjshShzt;
    }

    public void setCjshShzt(Integer cjshShzt) {
        this.cjshShzt = cjshShzt;
    }

    public String getCjshShr() {
        return cjshShr;
    }

    public void setCjshShr(String cjshShr) {
        this.cjshShr = cjshShr;
    }

    public Date getCjshShsj() {
        return cjshShsj;
    }

    public void setCjshShsj(Date cjshShsj) {
        this.cjshShsj = cjshShsj;
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

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
