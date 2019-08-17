package org.cjh.ayinfo.entity;

import java.util.Date;

public class BaseEntity {

    private Date addedDate;
    private String addedBy;
    private Date updatedDate;
    private String updatedBy;
    
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
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseEntity [addedDate=");
        builder.append(addedDate);
        builder.append(", addedBy=");
        builder.append(addedBy);
        builder.append(", updatedDate=");
        builder.append(updatedDate);
        builder.append(", updatedBy=");
        builder.append(updatedBy);
        builder.append("]");
        return builder.toString();
    }
}
