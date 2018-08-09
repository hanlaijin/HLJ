package com.hlj.common.dtos.login;

import com.hlj.thrift.Role;
import lombok.Data;

import java.util.List;

@Data
public class LoginDto {
    private Role role;
    private List<FunctionDto> functionList;
}