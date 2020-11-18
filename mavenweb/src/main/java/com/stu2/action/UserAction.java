package com.stu2.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    public String execute(){
        return SUCCESS;
    }

    public String login(){

        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();

            // 常见的两行确保为utf-8格式的代码（如果有过滤器则不需要）
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("name->"+username+",password->"+password);

            if("admin".equals(username) && "123456".equals(password)){
                return SUCCESS;
            }else{
                return "login";
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

}