package org.cjh.ayinfo.entity;

import java.util.Date;

public class EmployeeBasicInfo extends BaseEntity {

    private Integer employeeId;
    private String employeeName;
    private String gender;
    private Date birthday;
    private Integer age;
    private String zodiac;
    private Double height; //cm
    private Double weigth; //kg
    private String province;
    private String mobileNo;
    private String education;
    private Double workingAge;
    private Double expectedPay;
    private String pictureId;
    
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getZodiac() {
        return zodiac;
    }
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getWeigth() {
        return weigth;
    }
    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public Double getWorkingAge() {
        return workingAge;
    }
    public void setWorkingAge(Double workingAge) {
        this.workingAge = workingAge;
    }
    public Double getExpectedPay() {
        return expectedPay;
    }
    public void setExpectedPay(Double expectedPay) {
        this.expectedPay = expectedPay;
    }
    public String getPictureId() {
        return pictureId;
    }
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeBasicInfo [employeeId=");
        builder.append(employeeId);
        builder.append(", employeeName=");
        builder.append(employeeName);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", birthday=");
        builder.append(birthday);
        builder.append(", age=");
        builder.append(age);
        builder.append(", zodiac=");
        builder.append(zodiac);
        builder.append(", height=");
        builder.append(height);
        builder.append(", weigth=");
        builder.append(weigth);
        builder.append(", province=");
        builder.append(province);
        builder.append(", mobileNo=");
        builder.append(mobileNo);
        builder.append(", education=");
        builder.append(education);
        builder.append(", workingAge=");
        builder.append(workingAge);
        builder.append(", expectedPay=");
        builder.append(expectedPay);
        builder.append(", pictureId=");
        builder.append(pictureId);
        builder.append("]");
        return builder.toString();
    }
}
