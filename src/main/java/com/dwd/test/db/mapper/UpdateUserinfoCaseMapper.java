package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.UpdateUserinfoCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UpdateUserinfoCaseMapper {

    @Select("select * from update_userinfo_case where id=#{id}")
    UpdateUserinfoCase finUpdateUserInfoCaseById(@Param("id") String id);
}