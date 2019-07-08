package cn.superbio.business.entity.report;

public class NewPassword {
    private String id;
    private String oldPassword;
    private String npw;
    private String password;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNpw() {
        return npw;
    }

    public void setNpw(String npw) {
        this.npw = npw;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewPassword{" +
                "id='" + id + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", npw='" + npw + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
