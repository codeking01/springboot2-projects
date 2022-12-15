package com.codeking.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : codeking
 * @create : 2022/12/15 21:50
 */

@Data
@NoArgsConstructor
public class Person {
    private Integer id;
    private String userName;
    private String password;

    public Person(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
