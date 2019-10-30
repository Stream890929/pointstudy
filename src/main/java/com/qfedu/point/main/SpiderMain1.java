package com.qfedu.point.main;

import com.qfedu.point.page.HelloPage;
import us.codecraft.webmagic.Spider;

public class SpiderMain1 {
    public static void main(String[] args) {
        Spider.create(new HelloPage ()).addUrl("https://www.cnblogs.com/").thread(5).run();

        /*String s=" 发布于 2019-10-29 17:03";
        String s1=s.trim();
        System.out.println(s1.substring(s1.indexOf(' ')+1));*/
    }

}