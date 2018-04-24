package com.hlj.thrift.dao;

import com.hlj.thrift.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select m from User m where m.mobile = :mobile and m.password = :password ")
    List<User> getUserByMobileAndPassword(@Param("mobile") String mobile, @Param("password") String password);
}