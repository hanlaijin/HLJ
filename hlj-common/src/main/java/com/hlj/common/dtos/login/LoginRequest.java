package com.hlj.common.dtos.login;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class LoginRequest {
    private String mobile;
    private String password;

    public boolean checkParam(LoginRequest loginDto) {
        if (StringUtils.isBlank(loginDto.getMobile()) || StringUtils.isBlank(loginDto.getPassword())) {
            return false;
        }
        return true;
    }
}