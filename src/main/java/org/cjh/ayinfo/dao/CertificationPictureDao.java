package org.cjh.ayinfo.dao;

import java.util.List;

import org.cjh.ayinfo.entity.CertificationPicture;

public interface CertificationPictureDao {

    List<CertificationPicture> getById(Integer employeeId);
    int add(CertificationPicture param);
    int delete(Integer employeeId);
    int addBatch(List<CertificationPicture> param);
}
