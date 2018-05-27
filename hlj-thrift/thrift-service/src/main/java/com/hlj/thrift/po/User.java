package com.hlj.thrift.po;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "password")
    private String password;
}
