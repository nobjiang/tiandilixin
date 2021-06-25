package com.example.tiandilixin.base.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class map2Set {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        Set set = map.entrySet();
        set.stream().forEach(System.out::println);
        Set keyset = map.keySet();
        keyset.stream().forEach(System.out::println);
        HashSet set1 = new HashSet<>(map.values());
        set1.stream().forEach(System.out::println);

    }
}
