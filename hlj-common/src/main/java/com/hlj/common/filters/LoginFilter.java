package com.hlj.common.filters;

import com.hlj.common.constants.HljConstant;
import com.hlj.common.utils.LoginUserHelper;
import com.hlj.thrift.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String cookieValue = LoginUserHelper.getCookie(request);
        if (LoginUserHelper.validCookie(cookieValue)) {
            byte[] values = Base64.getDecoder().decode(cookieValue.getBytes());
            String[] array = new String(values).split(HljConstant.SEPARATE);
            String mobile = array[0];
            String password = array[1];
            User user = LoginUserHelper.getUserFromRedis(mobile);
            if (user == null) { //分布式缓存挂了
                user = LoginUserHelper.getUserFromDB(mobile);
            }
            if (user.getPassword().equals(password)) {
                LoginUserHelper.executeLogin(user, response);
                return;
            } else {
                LoginUserHelper.removeCookie(response);
                response.sendRedirect("/login.jsp");
            }
        } else {
            LoginUserHelper.removeCookie(response);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}