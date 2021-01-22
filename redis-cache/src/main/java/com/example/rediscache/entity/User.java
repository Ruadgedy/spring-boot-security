package com.example.rediscache.entity;

import java.io.Serializable;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private Sex sex;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public User(Integer id, String username, Sex sex) {
        this.id = id;
        this.username = username;
        this.sex = sex;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                '}';
    }
}
