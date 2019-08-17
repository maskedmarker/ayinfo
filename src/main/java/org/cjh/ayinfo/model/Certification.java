package org.cjh.ayinfo.model;

public class Certification {

    private Integer certId;
    private String description;
    public Integer getCertId() {
        return certId;
    }
    public void setCertId(Integer certId) {
        this.certId = certId;
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
        builder.append("Certification [certId=");
        builder.append(certId);
        builder.append(", description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}
