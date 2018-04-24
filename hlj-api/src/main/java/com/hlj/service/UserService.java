package com.hlj.service;

import com.google.common.collect.Lists;
import com.hlj.common.dtos.login.FunctionDto;
import com.hlj.common.dtos.login.LoginDto;
import com.hlj.common.dtos.login.LoginRequest;
import com.hlj.common.dtos.login.LoginResponse;
import com.hlj.common.utils.ThriftClientFactory;
import com.hlj.thrift.Function;
import com.hlj.thrift.HljService;
import com.hlj.thrift.Role;
import com.hlj.thrift.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    public static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    public User getUser(LoginRequest loginRequest) {
        return null;
    }

    public LoginResponse buildLoginResponse(User user) {
        LoginResponse response = new LoginResponse();
        response.setUser(user);
        List<LoginDto> dtos = Lists.newArrayList();
        List<Role> roles = null;
        for (Role role : roles) {
            LoginDto dto = new LoginDto();
            dto.setRole(role);
            List<Function> functions = null;
            dto.setFunctionList(FunctionDto.build(functions));
            dtos.add(dto);
        }
        response.setPermissions(dtos);
        return response;
    }
}