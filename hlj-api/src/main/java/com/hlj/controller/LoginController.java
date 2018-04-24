package com.hlj.controller;

import com.hlj.common.dtos.login.LoginRequest;
import com.hlj.common.dtos.login.LoginResponse;
import com.hlj.common.dtos.response.Response;
import com.hlj.common.enums.ResultEnum;
import com.hlj.common.utils.LoginUserHelper;
import com.hlj.common.utils.ResponseUtil;
import com.hlj.service.UserService;
import com.hlj.thrift.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    //找WEB-INF/view/login.jsp,该路径在spring mvc配置文件中给出
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Response doLogin(@ModelAttribute LoginRequest loginRequest, HttpServletResponse response) {
        try {
            boolean hasIllegalParam = loginRequest.checkParam(loginRequest);
            if (hasIllegalParam) {
                return ResponseUtil.error(ResultEnum.PARAM_ERROR);
            }
            User user = userService.getUser(loginRequest);
            if (user == null) {
                return ResponseUtil.error(ResultEnum.LOGIN_ERROR);
            }
            LoginUserHelper.executeLogin(user, response);
            LoginResponse result = userService.buildLoginResponse(user);
            return ResponseUtil.success(result);
        } catch (TException e) {
            log.error("login error = {}", e);
            return ResponseUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }
}