package com.qfedu.point.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.point.dao.BkyArticleDao;
import com.qfedu.point.entity.BkyArticle;
import com.qfedu.point.service.BkyArticleService;
import org.springframework.stereotype.Service;

@Service
public class BkyArticleServiceImpl extends ServiceImpl<BkyArticleDao, BkyArticle> implements BkyArticleService {

    @Override
    public boolean saveEntity(BkyArticle article) {
        return getBaseMapper().save(article)>0;
    }

}
