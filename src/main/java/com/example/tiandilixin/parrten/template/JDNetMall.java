package com.example.tiandilixin.parrten.template;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JDNetMall extends NetMall {
    public JDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    public Boolean login(String uId, String uPwd) {
        log.info("模拟京东⽤用户登录 uId:{} uPwd:{}", uId, uPwd);
        return true;
    }

    @Override
    public Map<String, String> reptile(String skuUrl) {
/*        String str = "xx";*//*HttpClient.doGet(skuUrl);*//*
        Pattern p9 =new Pattern();*//*Pattern.compile("(?<=title\\>).*(?=</title)");*//*
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "5999.00");
        log.info("模拟京东商品爬⾍虫解析:{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);*/
        return null;
    }

    @Override
    public String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        log.info("模拟⽣生成京东商品base64海海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}