package com.example.tiandilixin.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
/*
* 一对多的理解：

一个老师拥有多个学生

如果对于老师这边，就是一个一对多的现象，即从一个老师下面拥有一群学生（集合）！
* */
public interface TeacherMapper {
    //获取指定老师，及老师下的所有学生
    public Teacher2 getTeacher(int id);

    //方式二
    public Teacher2 getTeacher2(int id);
}