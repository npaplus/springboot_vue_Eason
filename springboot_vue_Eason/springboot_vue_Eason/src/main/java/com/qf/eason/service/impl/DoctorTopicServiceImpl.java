package com.qf.eason.service.impl;

import com.qf.eason.dao.DoctorTopicMapper;
import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
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
    public QueryResponseResult findAllTopic() {
        List<DoctorTopic> allTopic = doctorTopicMapper.findAllTopic();
        QueryResult<DoctorTopic> doctorTopicQueryResult=new QueryResult<>();
        doctorTopicQueryResult.setList(allTopic);
        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorTopicQueryResult);

    }

    @Override
    public QueryResponseResult findTopicBydoctorId(Integer doctorId) {
        List<DoctorTopic> allTopic = doctorTopicMapper.findTopicBydoctorId(doctorId);
        QueryResult<DoctorTopic> doctorTopicQueryResult=new QueryResult<>();
        doctorTopicQueryResult.setList(allTopic);
        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorTopicQueryResult);
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
}
