package com.example.tiandilixin.pool;

import com.example.tiandilixin.mybatis.User;
import com.example.tiandilixin.mybatis.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("redis")
@Slf4j
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserMapper userMapper;

    @GetMapping("test1")
    public void test1() {
        Long s = System.currentTimeMillis();
        for (int i = 0; i <= 1000; i++) {
            stringRedisTemplate.opsForSet().add("test", i + "");
        }
        Long e = System.currentTimeMillis();
        System.out.println(e - s);//34136
    }

    @GetMapping("test2")
    public void test2() {
        Long s = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i <= 1000; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + " 办理业务");
                    stringRedisTemplate.opsForSet().add("test", finalI + "");
                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        Long e = System.currentTimeMillis();
        System.out.println(e - s);//
    }

    @GetMapping("test3")
    public void test3() {
        Long s = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        try {
            for (int i = 0; i <= 1000000; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + " 办理业务");
                    stringRedisTemplate.opsForSet().add("test", finalI + "");
                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        Long e = System.currentTimeMillis();
        System.out.println(e - s);//
    }


    @GetMapping("test4")
    public void test4(){
        Long s = System.currentTimeMillis();
        List<User> users=userMapper.selectUser();
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        try {
            threadPool.execute(() -> {
                for (User user: users) {
                    userMapper.updateUser(new User(user.getId(),"1"+user.getName(),user.getPwd()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        Long e = System.currentTimeMillis();
        System.out.println(e - s);
    }


    @GetMapping("test5")
    public void test5(){
        ForkJoinPool forkJoinPool = new ForkJoinPool(32);
        Long s = System.currentTimeMillis();
        List<User> users=userMapper.selectUser();
       BatchUpdateUser batchUpdateUser=new BatchUpdateUser(userMapper,users);
        Integer invoke = forkJoinPool.invoke(batchUpdateUser);
        Long e = System.currentTimeMillis();
        log.info("openid单次插入总和 sum: " + invoke + "时间 in：" + (e - s) + " ms.");
        //openid单次插入总和 sum: 10000时间 in：311699 ms.   1
        //openid单次插入总和 sum: 10000时间 in：71373 ms.    4
        //openid单次插入总和 sum: 10000时间 in：35332 ms.    8
        //openid单次插入总和 sum: 10000时间 in：25103 ms.    16
        //openid单次插入总和 sum: 10000时间 in：23949 ms.    32
        //openid单次插入总和 sum: 10000时间 in：23088 ms.    64
        //openid单次插入总和 sum: 10000时间 in：24268 ms.    128

    }



}
