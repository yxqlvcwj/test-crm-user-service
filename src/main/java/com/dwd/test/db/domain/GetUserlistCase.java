package com.dwd.test.db.domain;

import lombok.Data;

@Data
public class GetUserlistCase {
    private Integer id;

    private String userName;

    private Integer age;

    private String sex;

    private String expected;


}