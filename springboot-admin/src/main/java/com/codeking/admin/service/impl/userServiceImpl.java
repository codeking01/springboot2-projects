package com.codeking.admin.service.impl;

import com.codeking.admin.bean.Person;
import com.codeking.admin.bean.User;
import com.codeking.admin.mapper.UserMapper;
import com.codeking.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/15 17:52
 */
@Service
public class userServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserService(Integer id) {
        return userMapper.getUser(id);
    }
    @Override
    public User getUserService2(Integer id) {
        return userMapper.getUser2(id);
    }

    @Override
    public void saveUser2(Object o) {
        userMapper.saveUser2(o);
    }

    @Override
    public Integer savePerson(Person person) {
        return userMapper.savePerson(person);
    }
}
