package org.cjh.ayinfo.model;

public class WorkingType {

    private Integer typeId;
    private String description;
    
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        builder.append("WokingType [typeId=");
        builder.append(typeId);
        builder.append(", description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}
