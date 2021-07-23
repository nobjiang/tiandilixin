package com.example.tiandilixin.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper {

    //新增一个博客
    int addBlog(Blog blog);


    //if语句需求：根据作者名字和博客名字来查询博客！如果作者名字为空，那么只根据博客名字查询，反之，则根据作者名来查询
    //需求1
    List<Blog> queryBlogIf(Map map);

//set
    int updateBlog(Map map);

}