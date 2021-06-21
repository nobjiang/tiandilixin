package com.example.tiandilixin.parrten.builder.commonway;

import java.math.BigDecimal;

/**
 * @author zhaoliang
 * ⼆二级顶
 */
public class LevelTwoCeiling  implements Matter {
    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司⾃自带";
    }

    @Override
    public String model() {
        return "⼆二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，⼆二级吊顶⾼高度⼀一般就往下吊20cm，要是层⾼高很⾼高，也可增加每级的厚度 "; }
    }
