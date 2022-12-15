package com.codeking.admin.mapper;

import com.codeking.admin.bean.Person;
import com.codeking.admin.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * @author : codeking
 * @create : 2022/12/15 17:25
 */
@Mapper
public interface UserMapper {
    User getUser(@Param("id") Integer id);

    @Select("select * from `user` where id=#{id}")
    User getUser2(Integer id);

    @Insert("insert into user(`user_name`) values(#{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveUser2(Object o);

    @Insert("insert into user(`user_name`) values(#{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer savePerson(Person person);
}
