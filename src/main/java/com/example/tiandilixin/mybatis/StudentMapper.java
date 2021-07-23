package com.example.tiandilixin.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoliang
 */
@Mapper

/*
* 多对一的理解：

多个学生对应一个老师

如果对于学生这边，就是一个多对一的现象，即从学生这边关联一个老师！


* */
public interface StudentMapper {
    //查出所有学生对应的所有老师
    //方式一 map
    List<Map> selectAll1();

    //方式二
    //获取所有学生及对应老师的信息
    public List<Student> getStudents();

    //方式三
    //获取所有学生及对应老师的信息
   public List<Student> getStudents2();

   //方式四
   public List<Student> getStudents3();
}