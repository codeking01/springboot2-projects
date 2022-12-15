package com.codeking.admin.service;

import com.codeking.admin.bean.Person;
import com.codeking.admin.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/15 17:51
 */
public interface UserService {
    User getUserService(Integer id);

    User getUserService2(Integer id);
    void saveUser2(Object o);
    Integer savePerson(Person person);
}
