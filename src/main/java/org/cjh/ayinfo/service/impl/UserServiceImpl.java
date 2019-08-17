package org.cjh.ayinfo.service.impl;

import java.util.List;

import org.cjh.ayinfo.dao.UserDao;
import org.cjh.ayinfo.entity.AyinfoUser;
import org.cjh.ayinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public AyinfoUser getUserById(String userId) {
        return userDao.getById(userId);
    }

    @Override
    public List<AyinfoUser> getList(AyinfoUser param) {
        return userDao.getList(param);
    }

}
