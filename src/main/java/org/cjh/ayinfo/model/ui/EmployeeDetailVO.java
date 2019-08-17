package org.cjh.ayinfo.model.ui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.cjh.ayinfo.entity.WorkingHistory;

public class EmployeeDetailVO {

    private Integer employeeId;
    private String employeeName;
    private String gender;
    private Date birthday;
    private Integer age;
    private String zodiac;
    private Double height; //cm
    private Double weight; //kg
    private String province;
    private String idNo;
    private String mobileNo;
    private String education;
    private List<String> tags;
    private List<String> workTypes;
    private Double workingAge;
    private List<String> certifications;
    private Double expectedPay;
    private String pictureId;
    private Date addedDate;
    private String addedBy;
    private Date updatedDate;
    private String updatedBy;
    private List<WorkingHistory> workingHistorys;
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
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public List<String> getWorkTypes() {
        return workTypes;
    }
    public void setWorkTypes(List<String> workTypes) {
        this.workTypes = workTypes;
    }
    public Double getWorkingAge() {
        return workingAge;
    }
    public void setWorkingAge(Double workingAge) {
        this.workingAge = workingAge;
    }
    public List<String> getCertifications() {
        return certifications;
    }
    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
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
    public Date getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
    public String getAddedBy() {
        return addedBy;
    }
    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public List<WorkingHistory> getWorkingHistorys() {
        return workingHistorys;
    }
    public void setWorkingHistorys(List<WorkingHistory> workingHistorys) {
        this.workingHistorys = workingHistorys;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeDetailVO [employeeId=");
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
        builder.append(", weight=");
        builder.append(weight);
        builder.append(", province=");
        builder.append(province);
        builder.append(", idNo=");
        builder.append(idNo);
        builder.append(", mobileNo=");
        builder.append(mobileNo);
        builder.append(", education=");
        builder.append(education);
        builder.append(", tags=");
        builder.append(tags);
        builder.append(", workTypes=");
        builder.append(workTypes);
        builder.append(", workingAge=");
        builder.append(workingAge);
        builder.append(", certifications=");
        builder.append(certifications);
        builder.append(", expectedPay=");
        builder.append(expectedPay);
        builder.append(", pictureId=");
        builder.append(pictureId);
        builder.append(", addedDate=");
        builder.append(addedDate);
        builder.append(", addedBy=");
        builder.append(addedBy);
        builder.append(", updatedDate=");
        builder.append(updatedDate);
        builder.append(", updatedBy=");
        builder.append(updatedBy);
        builder.append(", workingHistorys=");
        builder.append(workingHistorys);
        builder.append("]");
        return builder.toString();
    }
}
