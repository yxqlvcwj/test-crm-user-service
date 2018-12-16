package com.dwd.test.testcase.testuser;

import com.dwd.test.BaseCase;
import com.dwd.test.db.domain.LoginCase;
import com.dwd.test.db.mapper.LoginCaseMapper;
import com.dwd.test.testcase.ServerSettings;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * 用户登陆测试用例
 * Created by Chen WenJie on 2018/12/15.
 */
@Slf4j
public class loginTest extends BaseCase{

    @Autowired
    private LoginCaseMapper loginCaseMapper;
    @Autowired
    private ServerSettings serverSettings;

    @Test(description = "成功登陆")
    public void checkLoginTrue(){
        //获取参数登录信息
        LoginCase loginCase =  loginCaseMapper.finLoginCaseById("1");
        //封装请求参数
        Map<String, Object> param = new HashMap<>();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        //发起post请求
        Response response = given().contentType("application/json;charset=UTF-8").body(param).when().post(serverSettings.testUrl+serverSettings.loginUri);
        //请求结果校验
        Assert.assertEquals(response.asString(),loginCase.getExpected());
    }

    @Test(description = "登陆失败")
    public void checkLoginFalse() {
        LoginCase loginCase =  loginCaseMapper.finLoginCaseById("2");
        //封装请求参数
        Map<String, Object> param = new HashMap<>();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        //发起post请求
        Response response = given().contentType("application/json;charset=UTF-8").body(param).when().post(serverSettings.testUrl+serverSettings.loginUri);
        //请求结果校验
        Assert.assertEquals(response.asString(),loginCase.getExpected());
    }
}
