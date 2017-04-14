package com.open.provider.biz;

import com.open.provider.pojos.User;
import com.open.provider.service.IDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/12.
 */
public class DemoImpl implements IDemo {
    @Override
    public String sayHello(String msg) {
        return "Hello " + msg;
    }

    @Override
    public List getUsers() {
        List list = new ArrayList();
        User u1 = new User();
        u1.setName("zhangsan");
        u1.setSex("男");
        u1.setAge(20);

        User u2 = new User();
        u2.setName("lisi");
        u2.setSex("男");
        u2.setAge(23);

        User u3 = new User();
        u3.setName("xiaoxin");
        u3.setSex("女");
        u3.setAge(18);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }
}
