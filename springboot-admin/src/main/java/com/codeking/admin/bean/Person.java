package com.codeking.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : codeking
 * @create : 2022/12/15 21:50
 */

@Data
@NoArgsConstructor
@TableName("user") // 可以去对应数据库的表名
public class Person {
    private Integer id;
    private String userName;
    @TableField(exist = false) //可以在数据库里面不存在
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
