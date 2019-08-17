package org.cjh.ayinfo.model.factory;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.model.ui.EmployeeDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

public class EmployeeFactory {

    public static Employee get(EmployeeDetailVO param) {
        Employee employeeEntity = new Employee();
        BeanUtils.copyProperties(param, employeeEntity);
        
        List<String> workTypes = param.getWorkTypes();
        List<String> tags = param.getTags();
        List<String> certifications = param.getCertifications();
        if (!CollectionUtils.isEmpty(workTypes)) {
            String tmp = StringUtils.join(workTypes.toArray(), "|");
            employeeEntity.setWorkType(tmp);
        }
        if (!CollectionUtils.isEmpty(tags)) {
            String tmp = StringUtils.join(tags.toArray(), "|");
            employeeEntity.setTag(tmp);
        }
        if (!CollectionUtils.isEmpty(certifications)) {
            String tmp = StringUtils.join(certifications.toArray(), "|");
            employeeEntity.setCertification(tmp);
        }
        
        return employeeEntity;
    }
}
