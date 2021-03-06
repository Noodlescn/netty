package com.noodles.demo.dao;

import com.noodles.demo.po.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @Author noodles
 * @Description 接口
 */
public interface ArticleDao {

    List<Article> findByAuthorAndCreateTime(@Param("author") String author, @Param("createTime") String createTime);

    Article findOne(@Param("id") Integer id);


}
