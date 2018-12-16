package com.dwd.test.db.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Integer id;

    private String userName;

    private String password;

    private String age;

    private String sex;

    private String permission;

    private String isDelete;

}