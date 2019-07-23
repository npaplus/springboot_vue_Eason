package com.qf.eason.service;
import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import java.util.List;

public interface DoctorTopicService {
    //查询含医生信息的全部话题
    public List<DoctorTopic> findAllTopic();
    //通过医生id查询其发布的所有话题
    public List<DoctorTopic> findTopicBydoctorId(Integer doctorId);
    //话题阅读量+1
    public boolean addReading(Integer topicId);
    //判断用户是否已经给某话题点赞
    public boolean isGiveStar(Integer userId, Integer topicId);
    //用户给话题点赞
    public boolean giveStar(Integer userId, Integer topicId);

    //判断用户是否已经关注医生
    public boolean isFollowDoctor(Integer userId, Integer doctorId);
    //用户关注医生
    public boolean followDoctor(Integer userId, Integer doctorId);
    //用户取消关注医生
    public boolean reverseFollowDoctor(Integer userId, Integer doctorId);
    //查询用户关注的医生信息
    public List<Doctorinfor> myDoctor(Integer userId);
    //查询用户关注的医生以及医生发布的话题信息
    public List<DoctorTopic> myDoctorTopic(Integer userId);


    List<DoctorTopic> findallbyname(String drugname);

    public List<DoctorTopic> aboutFindByName(String tiaoJian);

}
