package org.cjh.ayinfo.entity;

public class AyinfoUser extends BaseEntity {

    private Integer userId;
    private String userName;
    private String password;
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", name=");
        builder.append(userName);
        builder.append(", password=");
        builder.append(password);
        builder.append("]");
        return builder.toString();
    }
}
