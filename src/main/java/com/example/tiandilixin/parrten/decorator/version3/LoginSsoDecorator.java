package com.example.tiandilixin.parrten.decorator.version3;


import com.example.tiandilixin.parrten.decorator.common.HandlerInterceptor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaoliang
 */
@Slf4j
public class LoginSsoDecorator extends SsoDecorator {
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object
            handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("模拟单点登录⽅方法访问拦截校验:{} {}", userId, method);
        // 模拟⽅方法校验
        return "queryUserInfo".equals(method);
    }

}
