package com.example.tiandilixin.mybatis;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"ALL", "AlibabaLowerCamelCaseVariableNaming"})
@Mapper
public interface UserMapper {

   //获取所有
   List<User> selectUser();

   //获取单个
   User getUser(int id);

   //param传参
   @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
   User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);

   //map传参
   @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
   User selectUserByNP2(Map<String,Object> map);

   //添加一个用户
   int addUser(User user);

   //修改一个用户
   int updateUser(User user);

   //根据id删除用户
   int deleteUser(int id);

   //模糊查询 手动的去添加“%”通配符。
   List<User> type1(String pattren);

   //模糊查询 sql语句中加%
   List<User> type2(String pattren);

   int insertBatch(@Param("list") List<User> list);


   //获取所有
   //ResultMap   实体类和数据库命名不一
   //解决方案  一：sql起别名  二：resultMap
   // Mapper上的resultType要换成ResultMAP
   List<User2> selectUser2();

   //分页查询
   //方式一：手动传分页参数
   List<User> selectUserLimit(Map map);

   //方式二：rowbounds
   List<User> selectUserRowB(String s, Object o, RowBounds rowBounds);
   //方式二：pagehelper

}