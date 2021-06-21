package com.example.tiandilixin.parrten.strategy.paymethod.strategyway;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
// 满100减10，商品100元
        Context<Map<String, String>> context = new Context<Map<String, String>>
                (new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<String, String>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new
                BigDecimal(100));
        System.out.println("测试结果:满减优惠后⾦金金额" + discountAmount);


    }
}
