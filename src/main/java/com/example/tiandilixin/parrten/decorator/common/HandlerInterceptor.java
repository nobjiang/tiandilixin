package com.example.tiandilixin.parrten.decorator.common;

/**
 * @author zhaoliang
 * 模拟Spring的HandlerInterceptor
 */
public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}