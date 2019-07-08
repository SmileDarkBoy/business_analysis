package cn.superbio.business.DO.report;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("business_report_info_expenses")
public class ReportInfoExpenses {
    private String id;
    private String infoId;
    private String expensesLcbh;
    private String expensesLcsqr;
    private String expensesCdsyb;
    private String expensesCdejbm;
    private String expensesCdsjbm;
    private String expensesCdr;
    private String expensesCdrgh;
    private String expensesFykm;
    private Double expensesJe;
    private Date expensesCnczrq;
    private String expensesCwcnyj;
    private Date expensesLcsqrq;
    private String expensesSm;
    private String expensesCdjsyb;
    private String expensesTdrcs;
    private String expensesTdrgh;
    private String expensesHdzt;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
