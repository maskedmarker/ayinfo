package org.cjh.ayinfo.entity;

public class Role extends BaseEntity {

    private String roleId;
    private String roleName;
    
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [roleId=");
        builder.append(roleId);
        builder.append(", roleName=");
        builder.append(roleName);
        builder.append("]");
        return builder.toString();
    }
}
