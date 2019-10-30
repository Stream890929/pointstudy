package com.qfedu.point.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration //配置文件
public class SwaggerConfig {
    //创建文档说明
    public ApiInfo createAI() {
        return new ApiInfoBuilder ().title ("文章接口").description ("一个基于java的爬虫项目")
                .contact (new Contact ("stream", "http://www.17feri.top", "13781150893@163.com")).build ();
    }

    //创建Swagger扫描信息
    @Bean
    public Docket createD() {
        return new Docket (DocumentationType.SWAGGER_2).apiInfo (createAI ()).select ().
                apis (RequestHandlerSelectors.basePackage ("com.qfedu.point.controller")).build ();
    }
}
