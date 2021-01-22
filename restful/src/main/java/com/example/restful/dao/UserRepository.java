package com.example.restful.dao;

import com.example.restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author yuhao
 * @date: 2021/1/22
 * @description:
 */
public interface UserRepository extends JpaRepository<User, String> {

    @RestResource(path = "salary_than")
    List<User> findUsersBySalaryGreaterThan(@Param("salary") double salary);
}
