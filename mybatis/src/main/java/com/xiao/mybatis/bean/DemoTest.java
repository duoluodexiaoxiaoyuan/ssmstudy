package com.xiao.mybatis.bean;

import com.xiao.mybatis.dao.IUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;

public class DemoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> t=new ThreadLocal<SqlSession>();

    static {
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("mybatis-remote-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SqlSession session=sqlSessionFactory.openSession();

        try{
            getUserList();
        }finally {
            session.close();
        }
    }

    public static void getUserList(){
        try{
            SqlSession session = sqlSessionFactory.openSession();
            IUser iuser = session.getMapper(IUser.class);
            //显示user信息
            System.out.println("Test Get Start>>>>>>>>>>>>");
            printUsers(iuser.getUserList());
            System.out.println("Test get finished>>>>>>>>>>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void printUsers(final List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format(
                    "============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Age: " + user.getAge());
            System.out.println("User Sex: " + user.getSex());
            System.out.println("User school:" + user.getSchool());
        }
    }



}