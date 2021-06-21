package com.example.tiandilixin.parrten.strategy.paymethod.strategyway;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {
    /**
     * 优惠券⾦金金额计算
     *
     * @param couponInfo 券折扣信息;直减、满减、折扣、N元购 *
     * @param skuPrice sku⾦金金额
     * @return 优惠后⾦金金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}