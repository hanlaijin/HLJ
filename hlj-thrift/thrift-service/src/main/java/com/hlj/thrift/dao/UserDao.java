package com.hlj.thrift.dao;

import com.hlj.thrift.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Long, User> {
}