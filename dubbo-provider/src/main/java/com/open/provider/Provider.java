package com.open.provider;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by admin on 2017/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dubbo-spring.xml"})
public class Provider {
    @Test
    public  void provider() throws IOException {
        System.in.read();//为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
