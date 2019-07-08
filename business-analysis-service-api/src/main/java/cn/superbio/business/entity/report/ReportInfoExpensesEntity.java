package cn.superbio.business.entity.report;

import java.util.Date;

public class ReportInfoExpensesEntity {
    //支出信息
    private String id;
    private String infoId; //项目id
    private String expensesLcbh; //流程编号 泛微流程编号
    private String expensesLcsqr; //流程申请人
    private String expensesCdsyb; //承担事业部
    private String expensesCdejbm; //承担二级部门
    private String expensesCdsjbm; //承担三级部门
    private String expensesCdr; //承担人
    private String expensesCdrgh; //承担人工号
    private String expensesFykm; //费用科目
    private Double expensesJe; //金额
    private Date expensesCnczrq; //出纳操作日期
    private String expensesCwcnyj; //财务出纳意见
    private Date expensesLcsqrq; //流程申请日期
    private String expensesSm; //说明
    private String expensesCdjsyb; //承担旧事业部
    private String expensesTdrcs; //提单人参数
    private String expensesTdrgh; //提单人工号
    private String expensesHdzt; //核对状态
    private Date createDate; //创建时间
    private String createBy; //创建人
    private int status; //状态

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

    public String getExpensesLcbh() {
        return expensesLcbh;
    }

    public void setExpensesLcbh(String expensesLcbh) {
        this.expensesLcbh = expensesLcbh;
    }

    public String getExpensesLcsqr() {
        return expensesLcsqr;
    }

    public void setExpensesLcsqr(String expensesLcsqr) {
        this.expensesLcsqr = expensesLcsqr;
    }

    public String getExpensesCdsyb() {
        return expensesCdsyb;
    }

    public void setExpensesCdsyb(String expensesCdsyb) {
        this.expensesCdsyb = expensesCdsyb;
    }

    public String getExpensesCdejbm() {
        return expensesCdejbm;
    }

    public void setExpensesCdejbm(String expensesCdejbm) {
        this.expensesCdejbm = expensesCdejbm;
    }

    public String getExpensesCdsjbm() {
        return expensesCdsjbm;
    }

    public void setExpensesCdsjbm(String expensesCdsjbm) {
        this.expensesCdsjbm = expensesCdsjbm;
    }

    public String getExpensesCdr() {
        return expensesCdr;
    }

    public void setExpensesCdr(String expensesCdr) {
        this.expensesCdr = expensesCdr;
    }

    public String getExpensesCdrgh() {
        return expensesCdrgh;
    }

    public void setExpensesCdrgh(String expensesCdrgh) {
        this.expensesCdrgh = expensesCdrgh;
    }

    public String getExpensesFykm() {
        return expensesFykm;
    }

    public void setExpensesFykm(String expensesFykm) {
        this.expensesFykm = expensesFykm;
    }

    public Double getExpensesJe() {
        return expensesJe;
    }

    public void setExpensesJe(Double expensesJe) {
        this.expensesJe = expensesJe;
    }

    public Date getExpensesCnczrq() {
        return expensesCnczrq;
    }

    public void setExpensesCnczrq(Date expensesCnczrq) {
        this.expensesCnczrq = expensesCnczrq;
    }

    public String getExpensesCwcnyj() {
        return expensesCwcnyj;
    }

    public void setExpensesCwcnyj(String expensesCwcnyj) {
        this.expensesCwcnyj = expensesCwcnyj;
    }

    public Date getExpensesLcsqrq() {
        return expensesLcsqrq;
    }

    public void setExpensesLcsqrq(Date expensesLcsqrq) {
        this.expensesLcsqrq = expensesLcsqrq;
    }

    public String getExpensesSm() {
        return expensesSm;
    }

    public void setExpensesSm(String expensesSm) {
        this.expensesSm = expensesSm;
    }

    public String getExpensesCdjsyb() {
        return expensesCdjsyb;
    }

    public void setExpensesCdjsyb(String expensesCdjsyb) {
        this.expensesCdjsyb = expensesCdjsyb;
    }

    public String getExpensesTdrcs() {
        return expensesTdrcs;
    }

    public void setExpensesTdrcs(String expensesTdrcs) {
        this.expensesTdrcs = expensesTdrcs;
    }

    public String getExpensesTdrgh() {
        return expensesTdrgh;
    }

    public void setExpensesTdrgh(String expensesTdrgh) {
        this.expensesTdrgh = expensesTdrgh;
    }

    public String getExpensesHdzt() {
        return expensesHdzt;
    }

    public void setExpensesHdzt(String expensesHdzt) {
        this.expensesHdzt = expensesHdzt;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
