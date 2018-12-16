package com.dwd.test.testcase.testuser;

import com.dwd.test.BaseCase;
import com.dwd.test.db.domain.AddUserCase;
import com.dwd.test.db.domain.User;
import com.dwd.test.db.mapper.AddUserCaseMapper;
import com.dwd.test.db.mapper.UserMapper;
import com.dwd.test.testcase.GetUserInfoAndCookies;
import com.dwd.test.testcase.ServerSettings;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * 添加用户接口
 * Created by Chen WenJie on 2018/12/16.
 */
@Slf4j
public class AddUserTest extends BaseCase{

    @Autowired
    private AddUserCaseMapper addUserCaseMapper;

    @Autowired
    private ServerSettings serverSettings;

    @Autowired
    private UserMapper userMapper;

    @Test(description = "添加用户用例")
    public void addUser(){
        //获取请求参数
        AddUserCase addUserCase = addUserCaseMapper.findAddUserCaseInfoById("1");
        //获取登录骑手
        User user = userMapper.findUserInfoById("1");
        //拼接请求参数
        Map<String,Object> param = new HashMap<>();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        //调用前置登陆接口登陆获取cookie
        GetUserInfoAndCookies getUserInfoAndCookies = new GetUserInfoAndCookies();
        Response response = getUserInfoAndCookies.login(user,serverSettings.testUrl+serverSettings.loginGetUserInfoUri);
        System.out.println(response.asString());
        System.out.println(response.getCookies());
        //请求添加用户接口
        Response responseForAddUser = given().contentType("application/json;charset=UTF-8").cookies(response.getCookies())
                .body(param).when().post(serverSettings.testUrl+serverSettings.addUserUri);
        //获取添加成功后的用户信息
        user = userMapper.findLastAddUserInfo();
        Assert.assertEquals(responseForAddUser.asString(),"true");
        //校验是否添加成功
        Assert.assertEquals(addUserCase.getUserName(),user.getUserName());
        Assert.assertEquals(addUserCase.getPassword(),user.getPassword());
    }
}
