package com.example.tiandilixin.parrten.template;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 基础电商推⼴广服务
 * 1. ⽣生成最优价商品海海报 * 2. 海海报含带推⼴广邀请码
 */
@Slf4j
public abstract class NetMall {
    String uId; // ⽤用户ID
    String uPwd; // ⽤用户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * ⽣生成商品推⼴广海海报 *
     *
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海海报图⽚片base64位信息
     */
    public String generateGoodsPoster(String skuUrl) {
        // 1.验证登录
        if (!login(uId, uPwd)) return null;
        // 2. 爬⾍虫商品
        Map<String, String> reptile = reptile(skuUrl);
        // 3. 组装海海报
        return createBase64(reptile);
    }

    // 模拟登录
    protected abstract Boolean login(String uId, String uPwd);

    // 爬⾍虫提取商品信息(登录后的优惠价格)
    protected abstract Map<String, String> reptile(String skuUrl);

    // ⽣生成商品海海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);
}