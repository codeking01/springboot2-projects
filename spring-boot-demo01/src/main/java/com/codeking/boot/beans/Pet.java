package com.codeking.boot.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : codeking
 * @create : 2022/12/10 15:38
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private Double weight;
}
