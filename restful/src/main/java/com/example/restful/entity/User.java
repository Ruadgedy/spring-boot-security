package com.example.restful.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yuhao
 * @date: 2021/1/22
 * @description:
 */
@Entity(name = "t_user")
public class User {

    @Id
    private String id;
    private String name;
    private int age;
    private double salary;
    private String phone;

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
