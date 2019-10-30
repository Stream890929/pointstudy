package com.qfedu.point.page;

import com.qfedu.point.entity.BkyArticle;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BkyArticlePage implements PageProcessor {
    private Site site = Site.me ().setTimeOut (6000).setSleepTime (2000);
    private String baseUrl = "https://www.cnblogs.com/";

    @Override
    public void process(Page page) {
        //1、解析当前页面的内容
        List<String> titles = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/h3/a/text()").all ();
        List<String> urls = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/h3/a/@href").all ();
        List<String> infos = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/p[@class='post_item_summary']/text()").all ();
        List<String> times = page.getHtml ().xpath ("div[@id='post_list']/div[@class='post_item']/div[@class='post_item_body']/div[@class='post_item_foot']/a/text()").all ();
        //2、组装解析的结果
        List<BkyArticle> articles = new ArrayList<> ();
        for (int i = 0; i < titles.size (); i++) {
            BkyArticle article = new BkyArticle ();
            article.setTitle (titles.get (i));
            article.setSummary (infos.get (i));
            article.setDetailurl (urls.get (i));
            article.setPubtime (parseTime (getTimeStr (times.get (i))));
            articles.add (article);
        }
        //3、传递给了结果处理器
        page.putField ("list", articles);

        //4、分页查询 获取分页的路径并标记继续爬取
        if (page.getUrl ().get ().equals (baseUrl)) {
            //计算所有的分页请路径
            List<String> pageurls = new ArrayList<> ();
            List<String> allpages = page.getHtml ().xpath ("div[@id='paging_block']/div[@class='pager']/a/text()").all ();
            int maxPage = Integer.parseInt (allpages.get (allpages.size () - 2));
            for (int i = 2; i <= maxPage; i++) {
                pageurls.add (baseUrl + "/sitehome/p/" + i);
            }
            //设置继续爬取的网页
            page.addTargetRequests (pageurls);
        }
    }

    private String getTimeStr(String s) {
        String s1 = s.trim ();
        if (s1.indexOf (" ") > 0) {
            return s.substring (s.indexOf (' ') + 1);
        } else {
            return null;
        }
    }

    private Date parseTime(String time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
            try {
                return sdf.parse (time);
            } catch (ParseException e) {
                e.printStackTrace ();
                return new Date ();
            }
        } else {
            return new Date ();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
