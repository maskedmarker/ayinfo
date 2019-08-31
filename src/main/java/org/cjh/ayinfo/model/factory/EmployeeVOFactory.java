package org.cjh.ayinfo.model.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cjh.ayinfo.entity.CertificationPicture;
import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.entity.WorkingHistory;
import org.cjh.ayinfo.model.ui.EmployeeDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

public class EmployeeVOFactory {

    public static EmployeeDetailVO get(Employee em, List<WorkingHistory> workingHistorys, List<CertificationPicture> certificationPictures) {
        EmployeeDetailVO detail = new EmployeeDetailVO();
        BeanUtils.copyProperties(em, detail);
        
        if (CollectionUtils.isEmpty(workingHistorys)) {
            workingHistorys = new ArrayList<>();
        }
        detail.setWorkingHistorys(workingHistorys);
        detail.setCertificationPictures(certificationPictures);
        
        if(!StringUtils.isBlank(em.getTag())) {
            String[] strings = StringUtils.split(em.getTag(), '|');
            detail.setTags(Arrays.asList(strings));
        }
        if(!StringUtils.isBlank(em.getWorkType())) {
            String[] strings = StringUtils.split(em.getWorkType(), '|');
            detail.setWorkTypes(Arrays.asList(strings));
        }
        if(!StringUtils.isBlank(em.getCertification())) {
            String[] strings = StringUtils.split(em.getCertification(), '|');
            detail.setCertifications(Arrays.asList(strings));
        }
        
        return detail;
    }
}
