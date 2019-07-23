package com.qf.eason.service.impl;

import com.qf.eason.dao.DoctorTopicMapper;
import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.service.DoctorTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springboot
 * @description: 处理医生话题相关业务
 * @author: Jiang Jingyuan
 * @create: 2019-07-20
 */
@Service
public class DoctorTopicServiceImpl implements DoctorTopicService {
    @Autowired(required = false)
    private DoctorTopicMapper doctorTopicMapper;
    @Override
    public List<DoctorTopic> findAllTopic() {
        List<DoctorTopic> allTopic = doctorTopicMapper.findAllTopic();
//        QueryResult<DoctorTopic> doctorTopicQueryResult=new QueryResult<>();
//        doctorTopicQueryResult.setList(allTopic);
//        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorTopicQueryResult);
        return allTopic;
    }

    @Override
    public List<DoctorTopic> findTopicBydoctorId(Integer doctorId) {
        List<DoctorTopic> allTopic = doctorTopicMapper.findTopicBydoctorId(doctorId);
//        QueryResult<DoctorTopic> doctorTopicQueryResult=new QueryResult<>();
//        doctorTopicQueryResult.setList(allTopic);
//        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorTopicQueryResult);
        return allTopic;
    }

    @Override
    public boolean addReading(Integer topicId) {
        return doctorTopicMapper.addReading(topicId)>0;
    }

    @Override
    public boolean isGiveStar(Integer userId, Integer topicId) {
        return doctorTopicMapper.isGiveStar(userId,topicId)>0;
    }

    @Override
    @Transactional
    public boolean giveStar(Integer userId, Integer topicId) {
        if(doctorTopicMapper.addStar(topicId)>0&&doctorTopicMapper.recordAddStar(userId,topicId)>0){
            return true;
        }
        return false;
    }


    @Override
    public boolean isFollowDoctor(Integer userId, Integer doctorId) {
        return doctorTopicMapper.isFollowDoctor(userId,doctorId)>0;
    }

    @Override
    public boolean followDoctor(Integer userId, Integer doctorId) {
        return doctorTopicMapper.followDoctor(userId,doctorId)>0;
    }

    @Override
    public boolean reverseFollowDoctor(Integer userId, Integer doctorId) {
        return doctorTopicMapper.reverseFollowDoctor(userId,doctorId)>0;
    }


    @Override
    public List<Doctorinfor> myDoctor(Integer userId) {
        List<Doctorinfor> all = doctorTopicMapper.myDoctor(userId);
//        QueryResult<Doctorinfor> doctorinforQueryResult=new QueryResult<>();
//        doctorinforQueryResult.setList(all);
//        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorinforQueryResult);
        return all;
    }

    @Override
    public List<DoctorTopic> myDoctorTopic(Integer userId) {
        List<DoctorTopic> doctorTopics = doctorTopicMapper.myDoctorTopic(userId);
//        QueryResult<DoctorTopic> doctorTopicQueryResult = new QueryResult<>();
//        doctorTopicQueryResult.setList(doctorTopics);
//        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorTopicQueryResult);
        return doctorTopics;
    }


    @Override
    public List<DoctorTopic> aboutFindByName(String tiaoJian) {
        List<DoctorTopic> doctorTopics = doctorTopicMapper.aboutFindByName(tiaoJian);
        return doctorTopics;
    }

    @Override
    public List<DoctorTopic> findallbyname(String drugname) {
        return doctorTopicMapper.findallbyname(drugname);
    }
}
