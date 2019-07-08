package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_cjsh")
public class ReportInfoCjsh {
    private String id;
    private String infoId;
    private String cjshJfmc;
    private String cjshYfmc;
    private String cjshHzlx;
    private Date cjshHtqsrq;
    private Double cjshHtje;
    @TableField(value = "cjsh_hkrq",strategy = FieldStrategy.IGNORED)
    private Date cjshHkrq;
    private Double cjshYszk;
    private Date cjshHtsxrq;
    private String cjshBz;
    @TableField(value = "cjsh_zbsj",strategy = FieldStrategy.IGNORED)
    private Date cjshZbsj;
    private String cjshZbdw;
    private String cjshZbgs;
    private Integer cjshShzt;
    private String cjshShr;
    private Date cjshShsj;
    private Date createDate;
    private String createBy;
    private Integer status;
    private Date cjshGsrq;

    public Date getCjshGsrq() {
        return cjshGsrq;
    }

    public void setCjshGsrq(Date cjshGsrq) {
        this.cjshGsrq = cjshGsrq;
    }

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
}
