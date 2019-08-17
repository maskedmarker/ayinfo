package org.cjh.ayinfo.entity;

import java.util.Date;

public class WorkingHistory extends BaseEntity{

    private Integer employeeId;
    private String des; //discription short name
    private Date startDate; //start date
    private Date endDate; //end date
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WorkingHistory [");
        builder.append(super.toString());
        builder.append(" , employeeId=");
        builder.append(employeeId);
        builder.append(", des=");
        builder.append(des);
        builder.append(", startDate=");
        builder.append(startDate);
        builder.append(", endDate=");
        builder.append(endDate);
        builder.append("]");
        return builder.toString();
    }
}
