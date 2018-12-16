package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * Created by Chen WenJie on 2018/12/15.
 */
@SpringBootApplication(scanBasePackages = {"com.dwd.test.*"},exclude = MongoAutoConfiguration.class)
@MapperScan("com.dwd.test.db.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
