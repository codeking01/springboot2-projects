package com.codeking.boot.controller;

import com.codeking.boot.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : codeking
 * @create : 2022/12/10 15:51
 */
@RestController
public class PersonController {
    @Autowired
    private Person person;

    @GetMapping("/getPerson")
    public Person getPerson() {
        return person;
    }
}
