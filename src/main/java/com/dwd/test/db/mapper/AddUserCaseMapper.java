package com.dwd.test.db.mapper;

import com.dwd.test.db.domain.AddUserCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AddUserCaseMapper {

    @Select("select * from add_user_case where id=#{id}")
    AddUserCase findAddUserCaseInfoById(@Param("id") String id);

}