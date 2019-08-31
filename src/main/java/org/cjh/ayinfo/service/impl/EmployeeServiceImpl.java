package org.cjh.ayinfo.service.impl;

import java.util.List;

import org.cjh.ayinfo.dao.CertificationPictureDao;
import org.cjh.ayinfo.dao.EmployeeDao;
import org.cjh.ayinfo.dao.WorkingHistoryDao;
import org.cjh.ayinfo.entity.CertificationPicture;
import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.entity.WorkingHistory;
import org.cjh.ayinfo.model.factory.EmployeeFactory;
import org.cjh.ayinfo.model.factory.EmployeeVOFactory;
import org.cjh.ayinfo.model.ui.EmployeeDetailVO;
import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;
import org.cjh.ayinfo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private WorkingHistoryDao workingHistoryDao;
    
    @Autowired
    private CertificationPictureDao certificationPictureDao;
    
    @Override
    public Employee getById(Integer employeeId) {
        return employeeDao.getById(employeeId);
    }

    @Override
    public List<Employee> getList(Employee param) {
        return employeeDao.getList(param);
    }

    @Override
    public Employee add(Employee param) {
        employeeDao.add(param);
        return param;
    }

    @Override
    public int update(Employee param) {
        return employeeDao.update(param);
    }

    @Override
    public int delete(Integer employeeId) {
        return employeeDao.delete(employeeId);
    }

    @Override
    public List<Employee> getList(Integer page, Integer rows, Employee targetParam) {
        return employeeDao.getPageList(page, rows, targetParam);
    }

    @Override
    public Integer count(Employee param) {
        return employeeDao.count(param);
    }

    @Override
    public List<Employee> getFuzzyPageList(UIEmployeePaginationQuery uiQuery) {
        return employeeDao.getFuzzyPageList(uiQuery);
    }

    @Override
    public Integer countFuzzy(UIEmployeePaginationQuery uiQuery) {
        return employeeDao.countFuzzy(uiQuery);
    }

    @Override
    public EmployeeDetailVO getEmployeeDetailById(Integer employeeId) {
        Employee em = getById(employeeId);
        List<WorkingHistory> workingHistorys = workingHistoryDao.getById(employeeId);
        List<CertificationPicture> certificationPictures = certificationPictureDao.getById(employeeId);
        EmployeeDetailVO detail = EmployeeVOFactory.get(em, workingHistorys, certificationPictures);
        return detail;
    }

    @Override
    @Transactional
    public EmployeeDetailVO addEmployeeDetail(EmployeeDetailVO param) {
        Employee employeeEntity = EmployeeFactory.get(param);
        employeeEntity = add(employeeEntity);
        
        List<WorkingHistory> workingHistorys = param.getWorkingHistorys();
        if (!CollectionUtils.isEmpty(workingHistorys)) {
            for (WorkingHistory workingHistory : workingHistorys) {
                workingHistory.setEmployeeId(employeeEntity.getEmployeeId());
            }
            workingHistoryDao.addBatch(workingHistorys);
        }
        
        List<CertificationPicture> certificationPictures = param.getCertificationPictures();
        if (!CollectionUtils.isEmpty(certificationPictures)) {
            for (CertificationPicture certificationPicture : certificationPictures) {
                certificationPicture.setEmployeeId(employeeEntity.getEmployeeId());
            }
            certificationPictureDao.addBatch(certificationPictures);
        }
        return null;
    }

    @Override
    @Transactional
    public void deletedeleteEmployeeDetail(Integer employeeId) {
        employeeDao.delete(employeeId);
        workingHistoryDao.delete(employeeId);
        certificationPictureDao.delete(employeeId);
    }

    @Override
    @Transactional
    public EmployeeDetailVO updateEmployeeDetail(EmployeeDetailVO param) {
        Employee em = EmployeeFactory.get(param);
        employeeDao.update(em);
        
        workingHistoryDao.delete(param.getEmployeeId());
        List<WorkingHistory> workingHistorys = param.getWorkingHistorys();
        if (!CollectionUtils.isEmpty(workingHistorys)) {
            for (WorkingHistory workingHistory : workingHistorys) {
                workingHistory.setEmployeeId(em.getEmployeeId());
            }
            workingHistoryDao.addBatch(workingHistorys);
        }
        
        certificationPictureDao.delete(param.getEmployeeId());
        List<CertificationPicture> certificationPictures = param.getCertificationPictures();
        if (!CollectionUtils.isEmpty(certificationPictures)) {
            for (CertificationPicture certificationPicture : certificationPictures) {
                certificationPicture.setEmployeeId(em.getEmployeeId());
            }
            certificationPictureDao.addBatch(certificationPictures);
        }
        
        return param;
    }
}
