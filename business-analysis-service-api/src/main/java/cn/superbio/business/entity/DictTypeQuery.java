package cn.superbio.business.entity;

import java.util.Date;

public class DictTypeQuery {
    private String id;
    private String dictName; //字典名称
    private String dictType; //字典类型


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

}
