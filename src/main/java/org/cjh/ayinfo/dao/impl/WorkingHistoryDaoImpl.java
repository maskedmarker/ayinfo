package org.cjh.ayinfo.dao.impl;

import java.util.List;

import org.cjh.ayinfo.dao.WorkingHistoryDao;
import org.cjh.ayinfo.entity.WorkingHistory;
import org.springframework.stereotype.Repository;

@Repository
public class WorkingHistoryDaoImpl extends BaseDao implements WorkingHistoryDao {

    private static final String MYBATIS_NAME_SPACE = "org.cjh.ayinfo.entity.WorkingHistory";
    
    @Override
    public List<WorkingHistory> getById(Integer employeeId) {
        return sqlSession.selectList(MYBATIS_NAME_SPACE + ".getById", employeeId);
    }

    @Override
    public int add(WorkingHistory param) {
        return sqlSession.insert(MYBATIS_NAME_SPACE + ".add", param);
    }

    @Override
    public int update(WorkingHistory param) {
        return sqlSession.update(MYBATIS_NAME_SPACE + ".update", param);
    }

    @Override
    public int delete(Integer employeeId) {
        return sqlSession.delete(MYBATIS_NAME_SPACE + ".delete", employeeId);
    }

    @Override
    public int addBatch(List<WorkingHistory> hs) {
        for (WorkingHistory workingHistory : hs) {
            add(workingHistory);
        }
        return hs.size();
    }
}
