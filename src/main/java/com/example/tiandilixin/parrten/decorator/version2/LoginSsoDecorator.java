package com.example.tiandilixin.parrten.decorator.version2;

import com.example.tiandilixin.parrten.decorator.common.SsoInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaoliang
 * 第二版：功能迭代，要求在SSO中增加一些功能，比如判断cookie获取的userid和请求中的ID是否相同,相同才放行
 * 因为不能更改原来的SSO需求，所以只能继承，然后再扩展。如果再有需求，就又要继承，又更改。
 * 缺点：功能不断扩展，子类不断膨胀。
 *
 */
public class LoginSsoDecorator extends SsoInterceptor {
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    //模拟cookie
    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object
            handler) {
// 模拟获取cookie
        String ticket = request.substring(0, 7);
// 模拟校验
        boolean success = ticket.equals("success");
        if (!success) {
            return false;
        }
        String userId = request.substring(9);
        String method = authMap.get(userId);
// 模拟⽅方法校验
        return "queryUserInfo".equals(method);
    }
}