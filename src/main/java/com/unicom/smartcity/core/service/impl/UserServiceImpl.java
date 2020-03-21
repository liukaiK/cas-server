package com.unicom.smartcity.core.service.impl;

import com.unicom.smartcity.core.pojo.User;
import com.unicom.smartcity.core.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();

        User liukai = new User();
        liukai.setUsername("liukai");
        liukai.setPassword("123456");

        users.add(liukai);

        return users;
    }

}
