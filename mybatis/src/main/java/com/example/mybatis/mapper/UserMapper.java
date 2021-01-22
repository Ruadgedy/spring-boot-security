package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<User> getAllUsers();

    @Select("select * from t_user where id=#{id}")
    User getUserById(String id);

    @Insert("insert into t_user(id,name,age,salary,phone) values(#{id},#{name},#{age},#{salary},#{phone})")
    void addUser(User user);

    @Update("update t_user set name=#{name},age=#{age},salary=#{salary},phone=#{phone} where id=#{id}")
    void updateUserById(User user);

    @Delete("delete from t_user where id=#{id}")
    Integer deleteUserById(String id);
}
