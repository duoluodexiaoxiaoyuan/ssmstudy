package com.xiao.mybatis.dao;

import com.xiao.mybatis.bean.User;

import java.util.List;

public interface IUser {
    public List<User> getUserList();
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUser(int id);
}
