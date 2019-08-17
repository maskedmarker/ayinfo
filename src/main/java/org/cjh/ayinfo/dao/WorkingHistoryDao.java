package org.cjh.ayinfo.dao;

import java.util.List;

import org.cjh.ayinfo.entity.WorkingHistory;

public interface WorkingHistoryDao {

    List<WorkingHistory> getById(Integer employeeId);
    int add(WorkingHistory param);
    int update(WorkingHistory param);
    int delete(Integer employeeId);
    int addBatch(List<WorkingHistory> hs);
}
