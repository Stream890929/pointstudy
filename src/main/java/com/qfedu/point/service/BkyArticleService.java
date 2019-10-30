package com.qfedu.point.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.point.entity.BkyArticle;

public interface BkyArticleService extends IService<BkyArticle> {

    boolean saveEntity(BkyArticle article);
}
