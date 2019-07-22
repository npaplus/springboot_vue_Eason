package com.qf.eason.service.impl;

import com.qf.eason.dao.NewsMapper;
import com.qf.eason.pojo.News;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: springboot
 * @description: 科普新闻业务
 * @author: Jiang Jingyuan
 * @create: 2019-07-21
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired(required = false)
    private NewsMapper newsMapper;
    @Override
    public QueryResponseResult findHotNews() {
        List<News> all = newsMapper.findHotNews();
        QueryResult<News> a=new QueryResult<>();
        a.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,a);
    }

    @Override
    public QueryResponseResult findNewsByType(String type) {
        List<News> all = newsMapper.findNewsByType(type);
        QueryResult<News> a=new QueryResult<>();
        a.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,a);
    }

    @Override
    public QueryResponseResult myCollectNews(Integer userId) {
        List<News> all = newsMapper.myCollectNews(userId);
        QueryResult<News> a=new QueryResult<>();
        a.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,a);
    }

    @Override
    public boolean addReading(Integer newsId) {
        return newsMapper.addReading(newsId)>0;
    }

    @Override
    @Transactional
    public boolean giveStar(Integer userId, Integer newsId) {
        if(newsMapper.addStar(newsId)>0&&newsMapper.recordAddStar(userId,newsId)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean collectNews(Integer userId, Integer newsId, Date date) {
        if(newsMapper.addCollect(newsId)>0&&newsMapper.recordAddCollect(userId,newsId,date)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean reverseCollectNews(Integer userId, Integer newsId) {
        if(newsMapper.reduceCollect(newsId)>0&&newsMapper.recordReduceCollect(userId,newsId)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isCollectNews(Integer userId, Integer newsId) {
        return newsMapper.isCollectNews(userId,newsId)>0;
    }

    @Override
    public boolean isGiveStar(Integer userId, Integer newsId) {
        return newsMapper.isGiveStar(userId,newsId)>0;
    }
}
