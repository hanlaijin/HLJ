package com.hlj.common.utils;

import com.hlj.common.constants.HljConstant;
import com.hlj.thrift.HljService;
import com.hlj.thrift.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Slf4j
public class LoginUserHelper {

    private static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void setCurrentUser(User user) {
        threadLocal.set(user);
    }

    public static User getCurrentUser() {
        return threadLocal.get();
    }

    public static void setUserToRedis(User user) {
        try {
            service.saveUserToRedis(user);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUserFromRedis(String mobile) {
        try {
            return service.getUserFromRedis(mobile);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUserFromDB(String mobile) {
        try {
            return service.getUserFromDB(mobile);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeLogin(User user, HttpServletResponse response) {
        setCurrentUser(user);
        setUserToRedis(user);
        setCookie(user, response);
    }

    public static void setCookie(User user, HttpServletResponse response) {
        String source = user.getMobile() + HljConstant.SEPARATE + user.getPassword();
        byte[] result = Base64.getEncoder().encode(source.getBytes());
        Cookie cookie = new Cookie(HljConstant.LOGIN_COOKIE_NAME, new String(result));
        cookie.setMaxAge(HljConstant.LOGIN_COOKIE_EXPIRE_TIME);
        response.addCookie(cookie);
    }

    public static void executeLogout(HttpServletResponse response) {

        setCurrentUser(null);
        removeCookie(response);
    }

    public static void removeCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("auth", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }


    public static String getCookie(HttpServletRequest request) {
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(HljConstant.LOGIN_COOKIE_NAME)) {
                cookieValue = cookie.getValue();
            }
        }
        return cookieValue;
    }

    public static boolean validCookie(String cookieValue) {
        if (StringUtils.isBlank(cookieValue)) {
            return false;
        }
        String[] array = cookieValue.split(HljConstant.SEPARATE);
        if (array.length != 2) {
            return false;
        }
        if (StringUtils.isBlank(array[0]) || StringUtils.isBlank(array[1])) {
            return false;
        }
        return true;
    }
}