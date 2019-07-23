package com.qf.eason.controller;

import com.qf.eason.pojo.News;
import com.qf.eason.service.NewsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description: 科普新闻业务控制器
 * @author: Jiang Jingyuan
 * @create: 2019-07-21
 */
@Controller
@ResponseBody
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping(value = "/findHotNews")
    @ApiOperation(value = "科普--热点：查询所有新闻，按阅读量逆序、发布时间逆序排序")
    //查询科普新闻“热点”栏
    List<News> findHotNews(){
        return newsService.findHotNews();
    }

    @GetMapping(value = "/findNewsByType/{type}")
    @ApiOperation(value = "科普--生活/睡眠/母婴/减肥：分栏查询除热点栏和话题栏之外的科普新闻，按阅读量逆序、发布时间逆序排序")
    @ApiImplicitParam(name = "type",value = "新闻类型：生活/睡眠/母婴/减肥",required = true)
    //分栏查询除热点栏和话题栏之外的科普新闻
    List<News> findNewsByType(@PathVariable("type") String type){
        return newsService.findNewsByType(type);
    }

    @GetMapping(value = "/myCollectNews/{userId}")
    @ApiOperation(value = "个人中心--我的收藏--科普：查询用户收藏的所有新闻,按收藏日期,阅读量逆序排序")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true)
    //个人中心--我的收藏--科普：查询用户收藏的所有新闻（按收藏日期,阅读量逆序排序）
    List<News> myCollectNews(@PathVariable("userId")Integer userId){
        return newsService.myCollectNews(userId);
    }

    @PutMapping(value = "/addReading/{newsId}")
    @ApiOperation(value = "用户操作：新闻阅读量+1")
    @ApiImplicitParam(name = "newsId",value = "新闻id",required = true)
    //阅读量：tb_news阅读量+1。
    boolean addReading(@PathVariable("newsId")Integer newsId){
        return newsService.addReading(newsId);
    }


    @PostMapping(value = "/giveStar/{userId}/{newsId}")
    @ApiOperation(value = "用户操作：点赞新闻，只一次，不可逆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "newsId",value = "新闻id",required = true)
    })
    //点赞新闻 addStar，recordAddStar
    boolean giveStar(@PathVariable("userId")Integer userId,@PathVariable("newsId")Integer newsId){
        return newsService.giveStar(userId,newsId);
    }

    @PostMapping(value = "/collectNews/{userId}/{newsId}")
    @ApiOperation(value = "用户操作：收藏新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "newsId",value = "新闻id",required = true),
    })
    //收藏新闻 addCollect,recordAddCollect
    boolean collectNews(@PathVariable("userId")Integer userId,@PathVariable("newsId") Integer newsId){
        return newsService.collectNews(userId,newsId);
    }


    @DeleteMapping(value = "/reverseCollectNews/{userId}/{newsId}")
    @ApiOperation(value = "用户操作：取消收藏新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "newsId",value = "新闻id",required = true)
    })
    //取消收藏新闻 reduceCollect,recordReduceCollect
    boolean reverseCollectNews(@PathVariable("userId")Integer userId,@PathVariable("newsId")Integer newsId){
        return newsService.reverseCollectNews(userId,newsId);
    }

    @GetMapping(value = "/collectAndStar/{userId}/{newsId}")
    @ApiOperation(value = "页面载入：判断用户是否收藏该新闻，以及是否点赞该新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "newsId",value = "新闻id",required = true)
    })
    //判断用户是否收藏该新闻，以及是否点赞该新闻
    Map<String,Object> collectAndStar(@PathVariable("userId")Integer userId,@PathVariable("newsId")Integer newsId){
        Map<String,Object> map=new HashMap<>();
        map.put("isCollect",newsService.isCollectNews(userId,newsId));
        map.put("isGiveStar",newsService.isGiveStar(userId,newsId));
        return map;
    }
}
