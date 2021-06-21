package com.example.tiandilixin.parrten.decorator.version3;

import com.example.tiandilixin.parrten.decorator.common.SsoInterceptor;

public class Main {
    public static void main(String[] args) {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验:" + request + (success ? " 放⾏行行" : " 拦截"));
    }
}
