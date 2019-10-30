package com.qfedu.point.page;

import com.qfedu.point.dao.BkyArticleDao;
import com.qfedu.point.entity.BkyArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * 保存获取结果
 */
@Repository
public class BkyArticlePipeline implements Pipeline {
    @Autowired
    private BkyArticleDao bkyArticleDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<BkyArticle> articleList = resultItems.get ("list");
        System.out.println ("爬取数据：" + articleList.size ());
        for (BkyArticle a : articleList) {
            bkyArticleDao.save (a);
        }
    }

}
