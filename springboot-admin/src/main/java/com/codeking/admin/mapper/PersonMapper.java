package com.codeking.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.admin.bean.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/15 22:50
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
}
