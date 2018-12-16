package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User findUserInfoById(@Param("id")String id);

    @Select("select * from user order by id desc limit 0,1")
    User findLastAddUserInfo();

}