package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.LoginCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginCaseMapper {

    @Select("select * from login_case where id=#{id}")
    LoginCase finLoginCaseById(@Param("id") String id);
}