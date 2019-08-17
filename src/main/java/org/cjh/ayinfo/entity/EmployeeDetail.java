package org.cjh.ayinfo.entity;

import java.util.Arrays;

public class EmployeeDetail extends EmployeeBasicInfo {

    private String[] tags;
    private String[] workingTypes;
    private String[] certifications;
    private String[] workingExperiences;
    
    public String[] getTags() {
        return tags;
    }
    public void setTags(String[] tags) {
        this.tags = tags;
    }
    public String[] getWorkingTypes() {
        return workingTypes;
    }
    public void setWorkingTypes(String[] workingTypes) {
        this.workingTypes = workingTypes;
    }
    public String[] getCertifications() {
        return certifications;
    }
    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }
    public String[] getWorkingExperiences() {
        return workingExperiences;
    }
    public void setWorkingExperiences(String[] workingExperiences) {
        this.workingExperiences = workingExperiences;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeDetail [tags=");
        builder.append(Arrays.toString(tags));
        builder.append(", workingTypes=");
        builder.append(Arrays.toString(workingTypes));
        builder.append(", certifications=");
        builder.append(Arrays.toString(certifications));
        builder.append(", workingExperiences=");
        builder.append(Arrays.toString(workingExperiences));
        builder.append("]");
        return builder.toString();
    }
}
