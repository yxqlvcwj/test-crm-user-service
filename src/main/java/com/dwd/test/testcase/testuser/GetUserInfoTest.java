package com.dwd.test.testcase.testuser;

import com.alibaba.fastjson.JSONPath;
import com.dwd.test.BaseCase;
import com.dwd.test.db.domain.GetUserinfoCase;
import com.dwd.test.db.domain.User;
import com.dwd.test.db.mapper.GetUserinfoCaseMapper;
import com.dwd.test.db.mapper.UserMapper;
import com.dwd.test.testcase.GetUserInfoAndCookies;
import com.dwd.test.testcase.ServerSettings;
import com.mongodb.util.JSON;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * 获取用户信息接口
 * Created by Chen WenJie on 2018/12/16.
 */
@Slf4j
public class GetUserInfoTest extends BaseCase {

    @Autowired
    private ServerSettings serverSettings;

    @Autowired
    private GetUserinfoCaseMapper getUserinfoCaseMapper;

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private GetUserInfoAndCookies getUserInfoAndCookies;

    @Test(description = "获取用户信息接口")
    public void getUserInfoCase(){
        //获取入参信息
        GetUserinfoCase getUserinfoCase =getUserinfoCaseMapper.findGetUserinfoCaseById("1");
        if(getUserinfoCase==null){
            log.info("入参数据不存在");
            return;
        }
        //前置登陆接口，获取cookie
        User user = userMapper.findUserInfoById(String.valueOf(getUserinfoCase.getUserId()));
        Response response = getUserInfoAndCookies.login(user,serverSettings.testUrl+serverSettings.loginGetUserInfoUri);
        //获取用户信息
        Map<String,Object> param = new HashMap<>();
        param.put("id",getUserinfoCase.getUserId());
        Response responseForGetUserInfo = given().contentType("application/json;charset=UTF-8").cookies(response.getCookies())
                .params(param).when().get(serverSettings.testUrl+serverSettings.getUserInfoUri);
        Object json = JSON.parse(responseForGetUserInfo.asString());
        Assert.assertEquals(JSONPath.eval(json,"$.userName"),user.getUserName());

    }

}
