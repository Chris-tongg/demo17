package com.dong.Dao.Impl;

import com.dong.Dao.IStudentDao;
import com.dong.entity.Student;
import com.dong.utils.DBClose;
import com.dong.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {
    //注册
    @Override
    public Integer addStudent(Student stu) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into student(username,password,sex,hobbys,address) values (?,?,?,?,?)");
            ps.setString(1,stu.getUsername());
            ps.setString(2,stu.getPassword());
            ps.setString(3,stu.getSex());
            ps.setString(4,stu.getHobbys());
            ps.setString(5,stu.getAddrs());
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }
    //检查用户名是否存在
    @Override
    public Integer checkUsername(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select count(*) from student where username = ? ");
            ps.setString(1,username);
            rSet = ps.executeQuery();
            while (rSet.next()){
                count = rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return count;
    }
    //检查登录时的用户名和密码
    @Override
    public Integer checkStudent(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select count(*) from student where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rSet = ps.executeQuery();
            while (rSet.next()){
                count = rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return count;
    }
}
