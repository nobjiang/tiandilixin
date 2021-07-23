package com.example.tiandilixin.pool;

import java.util.concurrent.CountDownLatch;

public class WrongPoll {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            new Thread(new Hold()).start();
        }

        }
    }

     class Hold extends Thread {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        public Hold() {
            this.setDaemon(true);
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
