package com.qf.eason.service;
import com.qf.eason.response.QueryResponseResult;

public interface DoctorTopicService {
    //查询含医生信息的全部话题
    public QueryResponseResult findAllTopic();
    //通过医生id查询其发布的所有话题
    public QueryResponseResult findTopicBydoctorId(Integer doctorId);
    //话题阅读量+1
    public boolean addReading(Integer topicId);
    //判断用户是否已经给某话题点赞
    public boolean isGiveStar(Integer userId, Integer topicId);
    //用户给话题点赞
    public boolean giveStar(Integer userId, Integer topicId);

}
