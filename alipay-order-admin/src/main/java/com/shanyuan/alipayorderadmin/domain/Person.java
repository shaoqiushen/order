package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 17:49
 * <p>
 * desc
 **/
@Data
public class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;

    public Person(String firstName, String lastName, String job, String gender, int salary, int age) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.job=job;
        this.gender=gender;
        this.salary=salary;
        this.age=age;
    }
}
