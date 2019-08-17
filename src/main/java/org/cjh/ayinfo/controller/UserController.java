package org.cjh.ayinfo.controller;

import org.cjh.ayinfo.entity.AyinfoUser;
import org.cjh.ayinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/getUserById.do")
    public AyinfoUser getUserById(@RequestParam(name = "id") String id) {
        return userService.getUserById(id);
    }
}
