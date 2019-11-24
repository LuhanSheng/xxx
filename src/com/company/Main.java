package com.company;

import com.company.JDBCConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception {
        JDBCConnectionUtil db= new JDBCConnectionUtil();

        //准备用户数据
        String username = "xxxx";
        String password= "xxxxx";
        String studentname= "LuhanSheng";
        String subject="math";
        User user=new User(username,password,studentname,subject);

        //数据库链接
        Connection con=db.getConnection();

        String sql="insert into student(userName,password,studentname,subject)values(?,?,?,?)";
        String sql1 = "delete from student where studentname='" + studentname + "'";
        String sql2 = "update student set password='" + password + "' where Name='" + username + "'";
        String sql3 = "select * from student";

        PreparedStatement p = null;

        p = con.prepareStatement(sql3);
//        p.setString(1, user.getUserName());
//        p.setString(2, user.getPassword());
//        p.setString(3, user.getStudentName());
//        p.setString(4, user.getSubject());
//        p.executeUpdate();
        ResultSet resultSet = p.executeQuery(sql3);
        while(resultSet.next()){ //遍历结果集，取出数据
            String student_username = resultSet.getString("username");
            String student_password= resultSet.getString("password");
            String student_name = resultSet.getString("studentname");
            String student_subject = resultSet.getString("subject");
            //输出数据
            System.out.print("账号："+student_username+" ");
            System.out.print("密码："+student_password+" ");
            System.out.print("姓名："+student_name+" ");
            System.out.print("课程："+student_subject);
            System.out.println();
        }
    }
}
