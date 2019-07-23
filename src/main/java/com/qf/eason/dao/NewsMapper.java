package com.qf.eason.dao;


import com.qf.eason.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsMapper {

    //科普-热点：(数据库并无“热点”的分类,属于前端自定义)；
    // （全类型查询后展示，按阅读量逆序，发布时间逆序排序，前端不用给参数）；
    //数据库可以给定生活，睡眠，母婴，两性四个分类，所以前端请给此字段请求。
    //查找热点新闻
    List<News> findHotNews();

    //科普（除热点和话题外的类型）：按类型查询科普新闻（按阅读量逆序，发布时间逆序排序）
    List<News> findNewsByType(@Param("type") String type);

    //个人中心--我的收藏--科普：查询用户收藏的所有新闻（按阅读量逆序，收藏时间逆序排序）
    List<News> myCollectNews(@Param("userId") Integer userId);

    //阅读量：tb_news阅读量+1。
    int addReading(@Param("newsId") Integer newsId);

    //点赞1：默认值为0，该用户只能点赞一次，tb_news中点赞数+1，操作不可逆；
    int addStar(@Param("newsId") Integer newsId);
    //点赞2：点赞同时用户新闻点赞记录表tb_user_news_thumbup中添加用户id和新闻id记录已经点赞。
    int recordAddStar(@Param("userId") Integer userId, @Param("newsId") Integer newsId);


    //用户收藏1： tb_news收藏数+1；
    int addCollect(@Param("newsId") Integer newsId);
    //用户收藏2：用户新闻收藏记录表tb_user_news_collect添加用户id和科普id以及收藏日期。
    int recordAddCollect(@Param("userId") Integer userId, @Param("newsId") Integer newsId, @Param("date") String date);

    //用户取消收藏1： tb_news收藏数-1；
    int reduceCollect(@Param("newsId") Integer newsId);
    //用户取消收藏2： 用户新闻收藏记录表tb_user_news_collect删除含用户id和科普id的一条数据。
    int recordReduceCollect(@Param("userId") Integer userId, @Param("newsId") Integer newsId);

    //判断用户是否收藏该新闻：用户新闻收藏记录表tb_user_news_collect查询。
    int isCollectNews(@Param("userId") Integer userId, @Param("newsId") Integer newsId);
    //判断用户是否点赞该新闻：用户新闻点赞记录表tb_user_news_thumbup查询。
    int isGiveStar(@Param("userId") Integer userId, @Param("newsId") Integer newsId);

    public List<News> aboutFind(@Param("tiaoJian") String tiaoJian);

}
