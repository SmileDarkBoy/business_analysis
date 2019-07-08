package cn.superbio.business.entity.judicial_user;

public class CurrentUser {
    private String name;
    private String webchart;
    private String type;
    private String currentAuthority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebchart() {
        return webchart;
    }

    public void setWebchart(String webchart) {
        this.webchart = webchart;
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

    public void setCurrentUser(CurrentUser currentUser){
        this.name = currentUser.getName();
        this.webchart = currentUser.getWebchart();
        this.type = currentUser.getType();
        this.currentAuthority = currentUser.getCurrentAuthority();
    }
}
