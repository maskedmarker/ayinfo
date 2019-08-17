package org.cjh.ayinfo.service;

import java.util.List;

import org.cjh.ayinfo.entity.AyinfoUser;

public interface UserService {

    AyinfoUser getUserById(String userId);
    
    List<AyinfoUser> getList(AyinfoUser param);
}
