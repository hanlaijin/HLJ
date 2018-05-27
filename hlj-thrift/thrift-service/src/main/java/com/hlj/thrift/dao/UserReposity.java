package com.hlj.thrift.dao;

import com.hlj.thrift.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposity extends JpaRepository<User, Long> {
    User getByMobile(String mobile);
}
