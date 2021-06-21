package com.example.tiandilixin.parrten.decorator.common;

/**
 * @author zhaoliang
 * 模拟单点登录功能
 */
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(0, 7); // 模拟校验
        return ticket.equals("success");
    }
}