package cn.superbio.business.DO.business_user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("business_report_staff_accout")
public class BusinessUser {

    @TableField("account")
    private String userCode;
    private String passWord;

    @TableField("levelname")
    private String name;

    @TableField("level")
    private String type;
    private String currentAuthority;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }

    @Override
    public String toString() {
        return "BusinessUser{" +
                "userCode='" + userCode + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", currentAuthority='" + currentAuthority + '\'' +
                '}';
    }
}
