package com.qfedu.point.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.qfedu.point.page.BkyArticlePage;
import com.qfedu.point.page.BkyArticlePipeline;
import com.qfedu.point.service.BkyArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/30 19:07
 */
@RestController
@Api(value = "Java实现爬虫", tags = "爬取数据操作接口，例如数据查询")
public class BkyArticleController {
    @Autowired
    private BkyArticlePage page;
    @Autowired
    private BkyArticlePipeline pipeline;
    @Autowired
    private BkyArticleService bkyArticleService;

    /**
     * 启动爬虫
     * @return 爬取数据
     */
    @GetMapping(value = "/spider/start")
    @ApiOperation(value = "start", notes = "启动爬虫，爬取数据")
    public R start() {
        Spider.create (page).addPipeline (pipeline).addUrl ("https://www.cnblogs.com/").thread (5).run ();
        return R.ok ("爬虫启动成功");
    }

    @GetMapping(value = "/bkyArticle/selectAll")
    @ApiOperation(value = "selectAll", notes = "查询爬取的数据")
    public R selectAll(){
        return R.ok (bkyArticleService.list ());
    }

}
