package cn.superbio.business.DO.judicial_user;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_upc_users")
public class JudicialUser {
    private String userid;
    private String username;
    private String userCode;
    private String password;
    private String webchart;
    private String usertype;
    private String telphone;
    private String deptcode;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }


    public String getWebchart() {
        return webchart;
    }

    public void setWebchart(String webchart) {
        this.webchart = webchart;
    }
}
