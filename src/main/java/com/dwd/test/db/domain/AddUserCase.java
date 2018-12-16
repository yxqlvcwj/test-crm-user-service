package com.dwd.test.db.domain;

import lombok.Data;

@Data
public class AddUserCase {
    private Integer id;

    private String userName;

    private String password;

    private String age;

    private String sex;

    private String permission;

    private String isDelete;

    private String expected;

}