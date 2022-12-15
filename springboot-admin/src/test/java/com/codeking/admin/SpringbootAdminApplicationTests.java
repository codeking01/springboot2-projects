package com.codeking.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class SpringbootAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
    }

    @Test
    void jdbcTemplateTest(){
        // jdbcTemplate.queryForObject("select * from account_tbl")
        // jdbcTemplate.queryForList("select * from account_tbl",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from `user`", Long.class);
        log.info("aLong: " + aLong);
    }
}
