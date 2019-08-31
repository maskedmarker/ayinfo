package org.cjh.ayinfo.dao.impl;

import java.util.List;

import org.cjh.ayinfo.dao.CertificationPictureDao;
import org.cjh.ayinfo.entity.CertificationPicture;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationPictureDaoImpl extends BaseDao implements CertificationPictureDao {

    private static final String MYBATIS_NAME_SPACE = "org.cjh.ayinfo.entity.CertificationPicture";
    
    @Override
    public List<CertificationPicture> getById(Integer employeeId) {
        return sqlSession.selectList(MYBATIS_NAME_SPACE + ".getById", employeeId);
    }

    @Override
    public int add(CertificationPicture param) {
        return sqlSession.insert(MYBATIS_NAME_SPACE + ".add", param);
    }

    @Override
    public int delete(Integer employeeId) {
        return sqlSession.delete(MYBATIS_NAME_SPACE + ".delete", employeeId);
    }

    @Override
    public int addBatch(List<CertificationPicture> param) {
        for (CertificationPicture cp : param) {
            add(cp);
        }
        return param.size();
    }
}
