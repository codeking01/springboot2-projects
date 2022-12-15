package com.codeking.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.admin.bean.Person;
import com.codeking.admin.mapper.PersonMapper;
import com.codeking.admin.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/15 22:47
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper,Person> implements PersonService {
}
