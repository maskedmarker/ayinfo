package org.cjh.ayinfo.entity;

public class CertificationPicture extends BaseEntity{

    private Integer employeeId;
    private String pictureType;
    private String pictureId;
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getPictureType() {
        return pictureType;
    }
    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
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
        builder.append("CertificationPicture [");
        builder.append(super.toString());
        builder.append(" , employeeId=");
        builder.append(employeeId);
        builder.append(", pictureType=");
        builder.append(pictureType);
        builder.append(", pictureId=");
        builder.append(pictureId);
        builder.append("]");
        return builder.toString();
    }
}
