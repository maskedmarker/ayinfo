package org.cjh.ayinfo.service;

import java.util.List;

import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.model.ui.EmployeeDetailVO;
import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;

public interface EmployeeService {

    Employee getById(Integer employeeId);
    
    List<Employee> getList(Employee param);

    Employee add(Employee param);

    int update(Employee param);

    int delete(Integer employeeId);

    List<Employee> getList(Integer page, Integer rows, Employee targetParam);

    Integer count(Employee param);

    List<Employee> getFuzzyPageList(UIEmployeePaginationQuery uiQuery);

    Integer countFuzzy(UIEmployeePaginationQuery uiQuery);

    EmployeeDetailVO getEmployeeDetailById(Integer employeeId);

    EmployeeDetailVO addEmployeeDetail(EmployeeDetailVO param);

    void deletedeleteEmployeeDetail(Integer employeeId);

    EmployeeDetailVO updateEmployeeDetail(EmployeeDetailVO param);
}
