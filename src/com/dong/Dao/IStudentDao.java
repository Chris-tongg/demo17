package com.dong.Dao;

import com.dong.entity.Student;

public interface IStudentDao {
    //注册
    Integer addStudent(Student stu);
    //检查用户名是否存在
    Integer checkUsername(String username);
    //检查登录的用户名和密码
    Integer checkStudent(String username,String password);

}
