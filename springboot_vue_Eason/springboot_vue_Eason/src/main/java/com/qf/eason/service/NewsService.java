package com.qf.eason.service;

import com.qf.eason.response.QueryResponseResult;

import java.util.Date;


public interface NewsService {
    //科普-热点：(数据库并无“热点”的分类,属于前端自定义)；
    // （全类型查询后展示，按阅读量逆序，发布时间逆序排序，前端不用给参数）；
    //数据库可以给定生活，睡眠，母婴，两性四个分类，所以前端请给此字段请求。
    //查找热点新闻
    QueryResponseResult findHotNews();

    //科普（除热点和话题外的类型）：按类型查询科普新闻（按阅读量逆序，发布时间逆序排序）
    QueryResponseResult findNewsByType(String type);

    //个人中心--我的收藏--科普：查询用户收藏的所有新闻（按收藏时间逆序排序）
    QueryResponseResult myCollectNews(Integer userId);

    //阅读量：tb_news阅读量+1。
    boolean addReading(Integer newsId);

    //点赞新闻 addStar，recordAddStar
    boolean giveStar(Integer userId, Integer newsId);

    //收藏新闻 addCollect,recordAddCollect
    boolean collectNews(Integer userId, Integer newsId, Date date);

    //取消收藏新闻 reduceCollect,recordReduceCollect
    boolean reverseCollectNews(Integer userId, Integer newsId);

    //判断用户是否收藏该新闻
    boolean isCollectNews(Integer userId, Integer newsId);
    //判断用户是否点赞该新闻
    boolean isGiveStar(Integer userId, Integer newsId);
}
