package com.example.tiandilixin.parrten.decorator.version1;

import com.example.tiandilixin.parrten.decorator.common.SsoInterceptor;

/**
 * @author zhaoliang
 * 第一版：就是普通的SSO校验
 */

public class Main {
    public static void main(String[] args) {
        SsoInterceptor ssoInterceptor=new SsoInterceptor();
        String request = "successhuahua";
        boolean success = ssoInterceptor.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验:" + request + (success ? " 放行" : " 拦 截"));
    }
}
