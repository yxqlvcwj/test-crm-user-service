package com.dwd.test.testcase;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Chen WenJie on 2018/12/15.
 */
@Configuration
@PropertySource({"classpath:application.properties"})
/*@ConfigurationProperties(prefix="test")
 * 加上prefix这个下面就不用加value了，但是需要名称和属性对应
 * 如果不加，属性名字和键名字不一致，那属性还是需要加value的
 */
@ConfigurationProperties
@Data
public class ServerSettings {

    @Value(value = "${test.url}")
    public String testUrl;
    @Value(value = "${login.uri}")
    public String loginUri;
    @Value(value = "${add.user.uri}")
    public String addUserUri;
    @Value(value = "${get.user.info.uri}")
    public String getUserInfoUri;
    @Value(value = "${get.user.list.uri}")
    public String getUserListUri;
    @Value("${update.userInfo.uri}")
    public String updateUserInfoUri;
    @Value("${login.get.user.info.uri}")
    public String loginGetUserInfoUri;

}


