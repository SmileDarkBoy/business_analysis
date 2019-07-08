package cn.superbio.business.entity.sys;

import java.util.Date;

public class SysFileUploadEntity {
    private String id;
    private String fileId; //文件编号
    private String fileName; //文件名称
    private String fileType; //文件类型
    private String bizKey; //业务主键
    private String bizType; //业务类型
    private Date createDate; //创建时间
    private String createBy; //创建人
    private Integer status; //状态
    private SysFileEntityEntity fileEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
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

    public SysFileEntityEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(SysFileEntityEntity fileEntity) {
        this.fileEntity = fileEntity;
    }
}
