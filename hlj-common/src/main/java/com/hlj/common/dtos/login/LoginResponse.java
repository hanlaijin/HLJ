package com.hlj.common.dtos.login;

import com.hlj.thrift.User;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private User user;
    private List<LoginDto> permissions;
}