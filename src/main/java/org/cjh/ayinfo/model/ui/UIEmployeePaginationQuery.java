package org.cjh.ayinfo.model.ui;

import java.util.Date;

public class UIEmployeePaginationQuery extends UIPaginationQuery {

    private String employeeName;
    private String gender;
    private Date birthdayMin;
    private Date birthdayMax;
    private Integer ageMin;
    private Integer ageMax;
    private String zodiac;
    private Double heightMin; //cm
    private Double heightMax; //cm
    private Double weightMin; //kg
    private Double weightMax; //kg
    private String province;
    private String idNo;
    private String mobileNo;
    private String education;
    private String tag;
    private String workType;
    private Double workingAgeMin;
    private Double workingAgeMax;
    private String certification;
    private Double expectedPayMin;
    private Double expectedPayMax;
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
    public Date getBirthdayMin() {
        return birthdayMin;
    }
    public void setBirthdayMin(Date birthdayMin) {
        this.birthdayMin = birthdayMin;
    }
    public Date getBirthdayMax() {
        return birthdayMax;
    }
    public void setBirthdayMax(Date birthdayMax) {
        this.birthdayMax = birthdayMax;
    }
    public Integer getAgeMin() {
        return ageMin;
    }
    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }
    public Integer getAgeMax() {
        return ageMax;
    }
    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }
    public String getZodiac() {
        return zodiac;
    }
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
    public Double getHeightMin() {
        return heightMin;
    }
    public void setHeightMin(Double heightMin) {
        this.heightMin = heightMin;
    }
    public Double getHeightMax() {
        return heightMax;
    }
    public void setHeightMax(Double heightMax) {
        this.heightMax = heightMax;
    }
    public Double getWeightMin() {
        return weightMin;
    }
    public void setWeightMin(Double weightMin) {
        this.weightMin = weightMin;
    }
    public Double getWeightMax() {
        return weightMax;
    }
    public void setWeightMax(Double weightMax) {
        this.weightMax = weightMax;
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
    public Double getWorkingAgeMin() {
        return workingAgeMin;
    }
    public void setWorkingAgeMin(Double workingAgeMin) {
        this.workingAgeMin = workingAgeMin;
    }
    public Double getWorkingAgeMax() {
        return workingAgeMax;
    }
    public void setWorkingAgeMax(Double workingAgeMax) {
        this.workingAgeMax = workingAgeMax;
    }
    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
    }
    public Double getExpectedPayMin() {
        return expectedPayMin;
    }
    public void setExpectedPayMin(Double expectedPayMin) {
        this.expectedPayMin = expectedPayMin;
    }
    public Double getExpectedPayMax() {
        return expectedPayMax;
    }
    public void setExpectedPayMax(Double expectedPayMax) {
        this.expectedPayMax = expectedPayMax;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UIEmployeePaginationQuery [");
        builder.append(super.toString());
        builder.append(" , employeeName=");
        builder.append(employeeName);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", birthdayMin=");
        builder.append(birthdayMin);
        builder.append(", birthdayMax=");
        builder.append(birthdayMax);
        builder.append(", ageMin=");
        builder.append(ageMin);
        builder.append(", ageMax=");
        builder.append(ageMax);
        builder.append(", zodiac=");
        builder.append(zodiac);
        builder.append(", heightMin=");
        builder.append(heightMin);
        builder.append(", heightMax=");
        builder.append(heightMax);
        builder.append(", weightMin=");
        builder.append(weightMin);
        builder.append(", weightMax=");
        builder.append(weightMax);
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
        builder.append(", workingAgeMin=");
        builder.append(workingAgeMin);
        builder.append(", workingAgeMax=");
        builder.append(workingAgeMax);
        builder.append(", certification=");
        builder.append(certification);
        builder.append(", expectedPayMin=");
        builder.append(expectedPayMin);
        builder.append(", expectedPayMax=");
        builder.append(expectedPayMax);
        builder.append("]");
        return builder.toString();
    }
}
