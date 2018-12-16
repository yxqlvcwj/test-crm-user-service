package com.dwd.test;

import com.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by Chen WenJie on 2018/12/15.
 */
@SpringBootTest(classes = {Application.class})
public class BaseCase extends AbstractTestNGSpringContextTests {

}
