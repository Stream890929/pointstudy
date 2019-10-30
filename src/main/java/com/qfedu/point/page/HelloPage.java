package com.qfedu.point.page;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class HelloPage implements PageProcessor {
    private Site site = Site.me ().setTimeOut (6000).setSleepTime (2000);

    //页面处理 对爬取的内容做出处理
    @Override
    public void process(Page page) {
        List<String> titles = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/h3/a/text()").all ();
        List<String> urls = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/h3/a/@href").all ();
        List<String> infos = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/p[@class='post_item_summary']/text()").all ();

        for (int i = 0; i < titles.size (); i++) {
            System.out.println ("标题：" + titles.get (i));
            System.out.println ("摘要：" + infos.get (i));
            System.out.println ("详情路径：" + urls.get (i));
        }
    }

    //生成网站的站点信息 比如可以设置Cookie 设置超时 重试次数等
    @Override
    public Site getSite() {
        return site;
    }

}
