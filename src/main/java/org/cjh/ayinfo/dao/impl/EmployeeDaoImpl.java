package org.cjh.ayinfo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cjh.ayinfo.dao.EmployeeDao;
import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    private static final String MYBATIS_NAME_SPACE = "org.cjh.ayinfo.entity.Employee";
    
    @Override
    public Employee getById(Integer employeeId) {
        return sqlSession.selectOne(MYBATIS_NAME_SPACE + ".getById", employeeId);
    }

    @Override
    public List<Employee> getList(Employee param) {
        return sqlSession.selectList(MYBATIS_NAME_SPACE + ".getBasicInfoList", param);
    }

    @Override
    public int add(Employee param) {
        return sqlSession.insert(MYBATIS_NAME_SPACE + ".add", param);
    }
    
    @Override
    public int update(Employee param) {
        return sqlSession.insert(MYBATIS_NAME_SPACE + ".update", param);
    }
    
    @Override
    public int count(Employee param) {
        return sqlSession.selectOne(MYBATIS_NAME_SPACE + ".count", param);
    }

    @Override
    public int delete(Integer employeeId) {
        return sqlSession.insert(MYBATIS_NAME_SPACE + ".delete", employeeId);
    }

    @Override
    public List<Employee> getPageList(Integer page, Integer rows, Employee targetParam) {
        Map<String, Object> param = new HashMap<>();
        Integer offset = rows * (page - 1);
        param.put("offset", offset);
        param.put("rows", rows);
        param.put("param", targetParam);
        return sqlSession.selectList(MYBATIS_NAME_SPACE + ".getPageList", param);
    }

    @Override
    public List<Employee> getFuzzyPageList(UIEmployeePaginationQuery uiQuery) {
        Map<String, Object> param = new HashMap<>();
        Integer offset = uiQuery.getRows() * (uiQuery.getPage() - 1);
        param.put("offset", offset);
        param.put("count", uiQuery.getRows());
        param.put("param", uiQuery);
        return sqlSession.selectList(MYBATIS_NAME_SPACE + ".getFuzzyPageList", param);
    }

    @Override
    public Integer countFuzzy(UIEmployeePaginationQuery uiQuery) {
        Map<String, Object> param = new HashMap<>();
        param.put("param", uiQuery);
        return sqlSession.selectOne(MYBATIS_NAME_SPACE + ".countFuzzy", param);
    }
}
