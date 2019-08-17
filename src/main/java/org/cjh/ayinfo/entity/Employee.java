package org.cjh.ayinfo.entity;

import java.util.Date;

public class Employee extends BaseEntity {

    private Integer employeeId;
    private String employeeName;
    private String gender;
    private Date birthday; //yyyymmdd
    private Integer age;
    private String zodiac;
    private Double height; //cm
    private Double weight; //kg
    private String province;
    private String idNo;
    private String mobileNo;
    private String education;
    private String tag;
    private String workType;
    private Double workingAge;
    private String certification;
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
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getIdNo() {
        return idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
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
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getWorkType() {
        return workType;
    }
    public void setWorkType(String workType) {
        this.workType = workType;
    }
    public Double getWorkingAge() {
        return workingAge;
    }
    public void setWorkingAge(Double workingAge) {
        this.workingAge = workingAge;
    }
    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
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
        builder.append("Employee [");
        builder.append(super.toString());
        builder.append(" , employeeId=");
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
        builder.append(weight);
        builder.append(", province=");
        builder.append(province);
        builder.append(", idNo=");
        builder.append(idNo);
        builder.append(", mobileNo=");
        builder.append(mobileNo);
        builder.append(", education=");
        builder.append(education);
        builder.append(", tag=");
        builder.append(tag);
        builder.append(", workType=");
        builder.append(workType);
        builder.append(", workingAge=");
        builder.append(workingAge);
        builder.append(", certification=");
        builder.append(certification);
        builder.append(", expectedPay=");
        builder.append(expectedPay);
        builder.append(", pictureId=");
        builder.append(pictureId);
        builder.append("]");
        return builder.toString();
    }
}
