package com.example.tiandilixin.parrten.strategy.paymethod.strategyway;

import java.math.BigDecimal;

/**
 * @author zhaoliang
 * 策略略控制类
 */
public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
