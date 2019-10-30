package com.qfedu.point.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_bkyarticle")
public class BkyArticle {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String summary;
    private String detailurl;
    private Date pubtime;
    private Date ctime;

    public BkyArticle() {
    }

}