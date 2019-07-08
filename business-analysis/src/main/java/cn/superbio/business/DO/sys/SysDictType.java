package cn.superbio.business.DO.sys;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("dict_type")
public class SysDictType {
    private String id;
    private String dictName; //�ֵ�����
    private String dictType; //�ֵ�����
    private String remarks; //��ע��Ϣ
    private Date createDate; //����ʱ��
    private String createBy; //������
    private Integer status; //״̬

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
