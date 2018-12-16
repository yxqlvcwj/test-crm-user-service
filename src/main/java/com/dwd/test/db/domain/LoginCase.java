package com.dwd.test.db.domain;

import lombok.Data;

@Data
public class LoginCase {
    private Integer id;

    private String userName;

    private String password;

    private String expected;


}