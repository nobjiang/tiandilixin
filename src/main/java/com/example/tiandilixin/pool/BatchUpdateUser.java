package com.example.tiandilixin.pool;

import com.example.tiandilixin.mybatis.User;
import com.example.tiandilixin.mybatis.UserMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class BatchUpdateUser extends RecursiveTask<Integer> {


    // 临界值
    private final int MEDIAN_SIZE = 100;

    private UserMapper userMapper;
    private List<User> openIdList;

    public BatchUpdateUser(UserMapper userMapper, List<User> openIdList) {
        this.userMapper = userMapper;
        this.openIdList = openIdList;
    }

    @Override
    protected Integer compute() {
        if (openIdList.size() <= MEDIAN_SIZE) {
            return execute(userMapper, openIdList);
        }
        // 任务太大，一分为二
        int middle = openIdList.size() / 2;
        BatchUpdateUser left = new BatchUpdateUser(userMapper, openIdList.subList(0, middle));
        left.fork();
        BatchUpdateUser right = new BatchUpdateUser(userMapper, openIdList.subList(middle, openIdList.size()));
        right.fork();
        Integer leftResult = left.join();
        Integer rightResult = right.join();
        return leftResult + rightResult;
    }

    public Integer execute(UserMapper userMapper, List<User> openIdList) {
        for (User user:openIdList) {
            log.info(Thread.currentThread().getName());
            userMapper.updateUser(new User(user.getId(),3+user.getName(),user.getPwd()));
        }
       
        return openIdList.size();
    }
}