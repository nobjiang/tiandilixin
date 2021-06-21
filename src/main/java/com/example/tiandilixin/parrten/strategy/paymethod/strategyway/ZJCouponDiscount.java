package com.example.tiandilixin.parrten.strategy.paymethod.strategyway;

import java.math.BigDecimal;

/**
 * 直减计算
 * 1. 使⽤用商品价格减去优惠价格 * 2. 最低⽀支付⾦金金额1元
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal
            skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return
                BigDecimal.ONE;
        return discountAmount;
    }
}
