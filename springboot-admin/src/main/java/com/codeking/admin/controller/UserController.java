package com.codeking.admin.controller;

import com.codeking.admin.bean.Person;
import com.codeking.admin.bean.User;
import com.codeking.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : codeking
 * @create : 2022/12/15 17:56
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userService.getUserService(id);
        return user;
    }

    @ResponseBody
    @GetMapping("/getUser2/{id}")
    public User getUser2(@PathVariable("id") Integer id){
        User user = userService.getUserService(id);
        return user;
    }
    @ResponseBody
    @GetMapping("/saveUser2")
    public void saveUser2(){
        User user1 = new User("user","aa");
        userService.saveUser2(user1);
        System.out.println("添加成功！");
    }
    @ResponseBody
    @GetMapping("/savaPerson")
    public void  savaPerson(){
        Person person = new Person("1sdafcas","fads");
        Integer number = userService.savePerson(person);
        System.out.println(number);
    }
}
