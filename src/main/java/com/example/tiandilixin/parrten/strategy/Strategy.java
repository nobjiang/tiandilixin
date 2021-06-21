package com.example.tiandilixin.parrten.strategy;

/**
 * @author zhaoliang
 */
public interface Strategy<T> {
    int compare(T t1, T t2);
}
