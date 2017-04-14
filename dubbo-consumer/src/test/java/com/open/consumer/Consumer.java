package com.open.consumer;

import com.open.provider.service.IDemo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/4/12.
 */
public class Consumer {
    @Test
    public void test0100() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring/dubbo-consumer.xml"});
        context.start();

        IDemo demoService = (IDemo) context.getBean("demoService");
        String hello = demoService.sayHello("tom");
        System.out.println(hello);

        List list = demoService.getUsers();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        System.in.read();
    }
}
