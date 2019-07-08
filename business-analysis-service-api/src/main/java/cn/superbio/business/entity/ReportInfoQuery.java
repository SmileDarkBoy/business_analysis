package cn.superbio.business.entity;

import cn.superbio.business.entity.judicial_user.CurrentUser;

import java.util.Date;
import java.util.List;

public class ReportInfoQuery extends CurrentUser {
    //项目信息
    private String id;
    private String infoXmbm; //项目编码
    private String infoYwlx; //业务类型
    private String infoSsdq; //所属地区
    private String infoSsxq; //所属辖区
    private String infoFzr; //项目责任人
    private String infoGsbm; //归属部门
    private String infoXmzt; //项目状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoXmbm() {
        return infoXmbm;
    }

    public void setInfoXmbm(String infoXmbm) {
        this.infoXmbm = infoXmbm;
    }

    public String getInfoYwlx() {
        return infoYwlx;
    }

    public void setInfoYwlx(String infoYwlx) {
        this.infoYwlx = infoYwlx;
    }

    public String getInfoSsdq() {
        return infoSsdq;
    }

    public void setInfoSsdq(String infoSsdq) {
        this.infoSsdq = infoSsdq;
    }

    public String getInfoSsxq() {
        return infoSsxq;
    }

    public void setInfoSsxq(String infoSsxq) {
        this.infoSsxq = infoSsxq;
    }

    public String getInfoFzr() {
        return infoFzr;
    }

    public void setInfoFzr(String infoFzr) {
        this.infoFzr = infoFzr;
    }

    public String getInfoGsbm() {
        return infoGsbm;
    }

    public void setInfoGsbm(String infoGsbm) {
        this.infoGsbm = infoGsbm;
    }

    public String getInfoXmzt() {
        return infoXmzt;
    }

    public void setInfoXmzt(String infoXmzt) {
        this.infoXmzt = infoXmzt;
    }

}
