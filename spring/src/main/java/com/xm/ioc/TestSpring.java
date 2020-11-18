package com.xm.ioc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {


    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂创建对象
        UserDao userDao= (UserDao) context.getBean("bean1");
        //调用方法
        userDao.save("你好世界");

    }

}
