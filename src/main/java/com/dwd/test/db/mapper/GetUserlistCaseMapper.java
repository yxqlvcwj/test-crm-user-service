package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.GetUserlistCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GetUserlistCaseMapper {

    @Select("select * from get_userlist_case where id=#{id}")
    GetUserlistCase findGetUserListCaseById(@Param("id") String id);
}