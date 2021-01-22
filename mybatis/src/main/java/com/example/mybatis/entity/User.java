package com.example.mybatis.entity;

import java.io.Serializable;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public class User implements Serializable {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String phone;

    public User(String name, int age, double salary, String phone) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
