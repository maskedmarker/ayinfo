package org.cjh.ayinfo.dao;

import java.util.List;

import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;

public interface EmployeeDao {

    Employee getById(Integer employeeId);

    List<Employee> getList(Employee param);

    int add(Employee param);

    int update(Employee param);

    int count(Employee param);

    int delete(Integer employeeId);

    List<Employee> getPageList(Integer page, Integer rows, Employee targetParam);

    List<Employee> getFuzzyPageList(UIEmployeePaginationQuery uiQuery);

    Integer countFuzzy(UIEmployeePaginationQuery uiQuery);
}
