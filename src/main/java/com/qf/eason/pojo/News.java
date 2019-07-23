package com.qf.eason.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: springboot
 * @description: 除医生话题外的科普新闻
 * @author: Jiang Jingyuan
 * @create: 2019-07-21
 */
@Data
public class News implements Serializable {
    private Integer id;
    private String type;//分类(数据库并无“热点”的分类)（生活，睡眠，母婴，两性）
    private String writer;//作者
    private String title;//标题
    private Date date;//发布日期
    private String text;//文本内容
    private String img;//图片地址
    private String reference;//引用介绍
    private int collect;//收藏数
    private int forwardNumber;//转发数
    private int reading;//阅读量
    private int star;//点赞数
}
