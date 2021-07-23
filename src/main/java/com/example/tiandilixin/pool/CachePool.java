package com.example.tiandilixin.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachePool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            RequestRunable requestRunable = new RequestRunable("请求id" + i);
            executorService.submit(requestRunable);
        }
        executorService.shutdown();

    }

    static class RequestRunable implements Runnable {
        private String requestId;

        public RequestRunable(String requestId) {
            this.requestId = requestId;
        }

        @Override
        public void run() {
            System.out.println(requestId + "," + Thread.currentThread().getName());
        }
    }
}
