package com.example.tiandilixin.base.collection;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class map2Set {
    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        Set set = map.entrySet();
        set.stream().forEach(System.out::println);
        Set keyset = map.keySet();
        keyset.stream().forEach(System.out::println);
        HashSet set1 = new HashSet<>(map.values());
        set1.stream().forEach(System.out::println);

        List list =new ArrayList();
        list.add("A");
        list.add("A");
        list.stream().forEach(System.out::println);
        HashSet set2 = new HashSet<>(list);
        set2.stream().forEach(System.out::println);

        WeakHashMap<String,String> map1=new WeakHashMap<>();
        map1.put("1","2");
        System.out.println(map1.size()+"111");
        System.gc();
        Thread.sleep(500);
        System.out.println(map1.size()+"");

    }
}
