package com.qf.eason.service.impl;
import com.qf.eason.dao.NewsMapper;
import com.qf.eason.pojo.News;
import com.qf.eason.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    public List<News> findHotNews() {
        return newsMapper.findHotNews();
    }

    @Override
    public List<News> findNewsByType(String type) {
        return newsMapper.findNewsByType(type);
    }

    @Override
    public List<News> myCollectNews(Integer userId) {
        return newsMapper.myCollectNews(userId);
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
    public boolean collectNews(Integer userId, Integer newsId) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String date = sd.format(d);
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

    @Override
    public List<News> aboutFind(String tiaoJian) {
        List<News> news = newsMapper.aboutFind(tiaoJian);
        return news;
    }
}
