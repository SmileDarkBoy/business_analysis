package cn.superbio.business.entity.report;

import java.util.Date;
import java.util.List;

public class ReportInfoEntity {
    //项目信息
    private String id;
    private String infoXmbm; //项目编码
    private String infoYwlx; //业务类型
    private String infoXmlx; //项目类型
    private String areaCode; //地区编码
    private String infoSsdq; //所属地区
    private String infoSsxq; //所属辖区
    private String infoFzr; //项目责任人
    private String infoGsbm; //归属部门
    private String infoJfly; //经费来源
    private Double infoXmys; //项目预算
    private String infoZbfs; //招标方式
    private Date infoZbsj; //招标时间
    private Integer infoSfztb; //是否招投标
    private Integer infoSfclxmz; //是否成立项目组
    private String infoBz; //备注
    private String infoXmzt; //项目状态
    private Date createDate; //创建时间
    private String createBy; //创建人
    private Integer status; //状态

    private List<ReportInfoAgencyEntity> infoAgencyEntityList; //代理商
    private List<ReportInfoRivalEntity> infoRivalEntityList; //竞争对手
    private List<ReportInfoCustomerEntity> infoCustomerEntityList; //客户
    private List<ReportInfoMemberEntity> infoMemberEntityList; //成员
    private List<ReportInfoFollowingEntity> infoFollowingEntityList; //跟踪记录
    private List<ReportInfoRevenueEntity> infoRevenueEntityList; //收入信息
    private List<ReportInfoExpensesEntity> infoExpensesEntityList; //支出

    private ReportInfoCjshEntity infoCjshEntity; //成交审核
    private ReportInfoKxxdyEntity infoKxxdyEntity; //可行性调研
    private ReportInfoSqsxEntity infoSqsxEntity; //申请失效


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

    public String getInfoXmlx() {
        return infoXmlx;
    }

    public void setInfoXmlx(String infoXmlx) {
        this.infoXmlx = infoXmlx;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getInfoJfly() {
        return infoJfly;
    }

    public void setInfoJfly(String infoJfly) {
        this.infoJfly = infoJfly;
    }

    public Double getInfoXmys() {
        return infoXmys;
    }

    public void setInfoXmys(Double infoXmys) {
        this.infoXmys = infoXmys;
    }

    public String getInfoZbfs() {
        return infoZbfs;
    }

    public void setInfoZbfs(String infoZbfs) {
        this.infoZbfs = infoZbfs;
    }

    public Date getInfoZbsj() {
        return infoZbsj;
    }

    public void setInfoZbsj(Date infoZbsj) {
        this.infoZbsj = infoZbsj;
    }

    public Integer getInfoSfztb() {
        return infoSfztb;
    }

    public void setInfoSfztb(Integer infoSfztb) {
        this.infoSfztb = infoSfztb;
    }

    public Integer getInfoSfclxmz() {
        return infoSfclxmz;
    }

    public void setInfoSfclxmz(Integer infoSfclxmz) {
        this.infoSfclxmz = infoSfclxmz;
    }

    public String getInfoBz() {
        return infoBz;
    }

    public void setInfoBz(String infoBz) {
        this.infoBz = infoBz;
    }

    public String getInfoXmzt() {
        return infoXmzt;
    }

    public void setInfoXmzt(String infoXmzt) {
        this.infoXmzt = infoXmzt;
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

    public List<ReportInfoAgencyEntity> getInfoAgencyEntityList() {
        return infoAgencyEntityList;
    }

    public void setInfoAgencyEntityList(List<ReportInfoAgencyEntity> infoAgencyEntityList) {
        this.infoAgencyEntityList = infoAgencyEntityList;
    }

    public List<ReportInfoRivalEntity> getInfoRivalEntityList() {
        return infoRivalEntityList;
    }

    public void setInfoRivalEntityList(List<ReportInfoRivalEntity> infoRivalEntityList) {
        this.infoRivalEntityList = infoRivalEntityList;
    }

    public List<ReportInfoCustomerEntity> getInfoCustomerEntityList() {
        return infoCustomerEntityList;
    }

    public void setInfoCustomerEntityList(List<ReportInfoCustomerEntity> infoCustomerEntityList) {
        this.infoCustomerEntityList = infoCustomerEntityList;
    }

    public List<ReportInfoMemberEntity> getInfoMemberEntityList() {
        return infoMemberEntityList;
    }

    public void setInfoMemberEntityList(List<ReportInfoMemberEntity> infoMemberEntityList) {
        this.infoMemberEntityList = infoMemberEntityList;
    }

    public List<ReportInfoFollowingEntity> getInfoFollowingEntityList() {
        return infoFollowingEntityList;
    }

    public void setInfoFollowingEntityList(List<ReportInfoFollowingEntity> infoFollowingEntityList) {
        this.infoFollowingEntityList = infoFollowingEntityList;
    }

    public List<ReportInfoRevenueEntity> getInfoRevenueEntityList() {
        return infoRevenueEntityList;
    }

    public void setInfoRevenueEntityList(List<ReportInfoRevenueEntity> infoRevenueEntityList) {
        this.infoRevenueEntityList = infoRevenueEntityList;
    }

    public List<ReportInfoExpensesEntity> getInfoExpensesEntityList() {
        return infoExpensesEntityList;
    }

    public void setInfoExpensesEntityList(List<ReportInfoExpensesEntity> infoExpensesEntityList) {
        this.infoExpensesEntityList = infoExpensesEntityList;
    }

    public ReportInfoCjshEntity getInfoCjshEntity() {
        return infoCjshEntity;
    }

    public void setInfoCjshEntity(ReportInfoCjshEntity infoCjshEntity) {
        this.infoCjshEntity = infoCjshEntity;
    }

    public ReportInfoKxxdyEntity getInfoKxxdyEntity() {
        return infoKxxdyEntity;
    }

    public void setInfoKxxdyEntity(ReportInfoKxxdyEntity infoKxxdyEntity) {
        this.infoKxxdyEntity = infoKxxdyEntity;
    }

    public ReportInfoSqsxEntity getInfoSqsxEntity() {
        return infoSqsxEntity;
    }

    public void setInfoSqsxEntity(ReportInfoSqsxEntity infoSqsxEntity) {
        this.infoSqsxEntity = infoSqsxEntity;
    }


}
