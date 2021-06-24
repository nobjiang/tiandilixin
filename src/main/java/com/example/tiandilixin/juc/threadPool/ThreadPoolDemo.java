package com.example.tiandilixin.juc.threadPool;

import com.alibaba.fastjson.serializer.AtomicCodec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

    	// 创建一个拥有N个线程的线程池，根据调度创建合适的线程
    	ExecutorService threadPool = Executors.newWorkStealingPool(10);
        // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
        try {

            // 循环十次，模拟业务办理，让5个线程处理这10个请求
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                   // System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                    System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data: "+atomicInteger.get());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}