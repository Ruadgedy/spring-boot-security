package com.example.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@ApiModel
public class User {
    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty(value = "用户地址", required = true)
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
