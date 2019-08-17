package org.cjh.ayinfo.entity;

public class EmployeeTag {

    private Integer employeeId;
    private String description;
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeTag [employeeId=");
        builder.append(employeeId);
        builder.append(", description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}
