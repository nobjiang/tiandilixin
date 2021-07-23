package com.example.tiandilixin;

import com.example.tiandilixin.mybatis.*;
import com.example.tiandilixin.util.BatchUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TiandilixinApplicationTests {
    @Resource
    UserMapper userMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    BatchUtils batchUtils;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    BlogMapper blogMapper;


    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectUser();
        List<User> user2 = userMapper.selectUser();
        System.out.println(users.size());
    }

    @Test
    //循环插入
    public void contextLoads4() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            User user1 = new User(i, "tom" + i, "xxxx");
            userMapper.addUser(user1);
        }
        long end = System.currentTimeMillis();
        System.out.println("-------时间375353--------" + (start - end) + "---------------");
    }

    @Test
    //sqlsession插入
    public void testInsertBatch2() {
        long start = System.currentTimeMillis();
        //跟上述sql区别，将session设置为批量形式
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory()
                .openSession(ExecutorType.BATCH, false);
        for (int i = 0; i < 10000; i++) {
            User user1 = new User(i, "tom" + i, "xxxx");
            userMapper.addUser(user1);
        }
        sqlSession.commit();
        long end = System.currentTimeMillis();
        System.out.println("----时间376148----------" + (start - end) + "---------------");
    }


    @Test
    //sqlbanch插入
    public void testInsertBatch3() {
        long start = System.currentTimeMillis();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user1 = new User(i, "tom" + i, "xxxx");
            list.add(user1);
        }
        int i = userMapper.insertBatch(list);
        System.out.println(i);
        long end = System.currentTimeMillis();
        System.out.println("----时间824-----------" + (start - end) + "---------------");
    }





    @Test
    public void testInsertBatch4() {
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




    @Test
    //线程池分页处理
    public void testInsertBatch6() throws InterruptedException {
        Long s = System.currentTimeMillis();
        List<User> users = userMapper.selectUser();
        batchUtils.batchDeal(users,100);
        Long e = System.currentTimeMillis();
        System.out.println(e - s);//

    }

}
