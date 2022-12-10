package com.codeking.boot.beans;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : codeking
 * @create : 2022/12/10 15:33
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
@ToString
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String,Object> score;
    private Set<Double> salaries;
    private Map<String, List<Pet>> allPets;
}
