package com.example.tiandilixin.juc.callable;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread); // 适配类
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start(); // 结果会被缓存，效率高
        Object o = futureTask.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<UUID> {
    @Override
    public UUID call() {
        System.out.println("call()"); // 会打印几个call // 耗时的操作
        return UUID.randomUUID();
    }
}