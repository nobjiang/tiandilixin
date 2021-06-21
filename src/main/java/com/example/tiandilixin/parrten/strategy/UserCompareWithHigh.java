package com.example.tiandilixin.parrten.strategy;

/**
 * @author zhaoliang
 * 比较身高
 */
public class UserCompareWithHigh implements Strategy<User> {
    @Override
    public int compare(User t1, User t2) {
        if (t1.getHigh() > t2.getHigh()) {
            return 1;
        } else if (t1.getHigh() < t2.getHigh()) {
            return -1;
        } else {
            return 0;
        }
    }
}
