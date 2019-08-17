package org.cjh.ayinfo.dao.impl;

import java.util.List;

import org.cjh.ayinfo.dao.UserDao;
import org.cjh.ayinfo.entity.AyinfoUser;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends BaseDao implements UserDao {

    private static final String MYBATIS_NAME_SPACE = "org.cjh.ayinfo.entity.AyinfoUser";
    
    @Override
    public AyinfoUser getById(String userId) {
        return sqlSession.selectOne(MYBATIS_NAME_SPACE + ".getById", userId);
    }

    @Override
    public List<AyinfoUser> getList(AyinfoUser param) {
        return sqlSession.selectList(MYBATIS_NAME_SPACE + "getList", param);
    }

}
