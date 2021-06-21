package com.example.tiandilixin.parrten.strategy;

/**
 * @author zhaoliang
 * 年龄比较器
 */
public class UserCompareWithAge implements Strategy<User> {

    @Override
    public int compare(User t1, User t2) {
        if (t1.getAge() > t2.getAge()) {
            return 1;
        } else if (t1.getAge() < t2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
