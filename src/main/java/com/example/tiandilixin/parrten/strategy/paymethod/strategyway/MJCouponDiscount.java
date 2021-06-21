package com.example.tiandilixin.parrten.strategy.paymethod.strategyway;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 满减计算
 * 1. 判断满⾜足x元后-n元，否则不不减 * 2. 最低⽀支付⾦金金额1元
 * @author zhaoliang
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");
        // ⼩小于商品⾦金金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) {
            return skuPrice;
        }
        // 减去优惠⾦金金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
