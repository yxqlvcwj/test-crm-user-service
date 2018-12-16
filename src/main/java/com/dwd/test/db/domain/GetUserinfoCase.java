package com.dwd.test.db.domain;

import lombok.Data;

@Data
public class GetUserinfoCase {
    private Integer id;

    private Integer userId;

    private String expected;


}