package com.example.tiandilixin.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo{
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(5);// mian do thing. . . . ..
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data: "+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data: "+atomicInteger.get());
    }
}