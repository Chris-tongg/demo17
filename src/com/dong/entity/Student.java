package com.dong.entity;

public class Student {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String hobbys;
    private String addrs;
    private Integer is_delete;

    public Student() {
    }

    public Student(Integer id, String username, String password, String sex, String hobbys, String addrs, Integer is_delete) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobbys = hobbys;
        this.addrs = addrs;
        this.is_delete = is_delete;
    }

    public Student(String username, String password, String sex, String hobbys, String addrs) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobbys = hobbys;
        this.addrs = addrs;
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobbys() {
        return hobbys;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hobbys='" + hobbys + '\'' +
                ", addrs='" + addrs + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }
}