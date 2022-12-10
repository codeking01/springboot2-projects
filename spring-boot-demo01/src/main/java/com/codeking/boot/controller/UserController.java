package com.codeking.boot.controller;

import org.springframework.web.bind.annotation.*;


/**
 * @author : codeking
 * @create : 2022/12/11 0:05
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "putUser";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser() {
        return "deleteUser";
    }

    @GetMapping("/user")
    public String getUser() {
        return "getUser";
    }

    @PostMapping("/user")
    public String postUser() {
        return "postUser";
    }
}
