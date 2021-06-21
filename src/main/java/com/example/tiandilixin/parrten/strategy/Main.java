package com.example.tiandilixin.parrten.strategy;

public class Main {
    public static void main(String[] args) {
        User[] userArr = {new User("zhangsan", 3, 11)
                , new User("lisi", 2, 22)
                , new User("wangwu", 1, 33)};
        CompareUtil<User> sort = new CompareUtil<User>();
        //以不同的策略排序
        sort.sort(userArr, new UserCompareWithHigh());
        for (User user : userArr) {
            System.out.println(user.toString());
        }
    }
}
