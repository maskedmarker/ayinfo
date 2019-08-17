package org.cjh.ayinfo.dao;

import java.util.List;

import org.cjh.ayinfo.entity.AyinfoUser;

public interface UserDao {

    List<AyinfoUser> getList(AyinfoUser param);

    AyinfoUser getById(String userId);
}
