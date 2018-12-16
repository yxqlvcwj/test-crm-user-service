package com.dwd.test.testcase;

import com.dwd.test.db.domain.LoginCase;
import com.dwd.test.db.domain.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * 前置登陆接口
 * Created by Chen WenJie on 2018/12/16.
 */
@Component
public class GetUserInfoAndCookies {

    @Autowired
    private ServerSettings serverSettings;

    public Response login(User user,String testUrl) {
        //格式化请求参数
        Map<String, Object> param = new HashMap<>();
        param.put("userName",user.getUserName());
        param.put("password",user.getPassword());
        Response response =   given().contentType("application/json;charset=UTF-8").body(param).when().post(testUrl);
        return response;
    }
}
