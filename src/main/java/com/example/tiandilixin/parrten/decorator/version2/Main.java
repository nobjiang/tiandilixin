package com.example.tiandilixin.parrten.decorator.version2;

public class Main {
    public static void main(String[] args) {
      LoginSsoDecorator loginSsoDecorator=new LoginSsoDecorator();
        String request = "successhuahua";
        boolean success = loginSsoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验:" + request + (success ? " 放行" : " 拦 截"));
    }
}
