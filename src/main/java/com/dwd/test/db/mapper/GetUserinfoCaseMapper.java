package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.GetUserinfoCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GetUserinfoCaseMapper {

    @Select("select * from get_userinfo_case where id=#{id}")
    GetUserinfoCase findGetUserinfoCaseById(@Param("id") String id);
}