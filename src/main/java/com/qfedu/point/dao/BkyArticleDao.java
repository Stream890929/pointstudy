package com.qfedu.point.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.point.entity.BkyArticle;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface BkyArticleDao extends BaseMapper<BkyArticle> {

    @Insert("insert into t_bkyarticle(title,summary,detailurl,pubtime,ctime) values(#{title},#{summary},#{detailurl},#{pubtime},now())")
    int save(BkyArticle article);

}
