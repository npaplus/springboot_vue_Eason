package com.qf.eason.dao;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorTopicMapper {
    /**
     * @author Jiang Jingyuan
     * @description: 查询含医生信息的全部话题
     * @date 19-07-20
     * @Param:
     * @return 全部话题
     */
    public List<DoctorTopic> findAllTopic();
    /**
     * @author Jiang Jingyuan
     * @description: 通过医生id查询其发布的所有话题
     * @date 19-07-20
     * @Param: 医生id
     * @return 某医生发布的话题
     */
    public List<DoctorTopic> findTopicBydoctorId(@Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 话题阅读量+1
     * @date 19-07-20
     * @Param: 话题id
     * @return int
     */
    public int addReading(@Param("topicId") Integer topicId);


    /**
     * @author Jiang Jingyuan
     * @description: 判断用户是否已经给某话题点赞
     * @date 19-07-21
     * @Param: userId
     * @Param: topicId
     * @return int
     */
    public int isGiveStar(@Param("userId") Integer userId, @Param("topicId") Integer topicId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户点赞话题增加点赞数
     * @date 19-07-20
     * @Param: 话题id
     * @return int
     */

    public int addStar(@Param("topicId") Integer topicId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户点赞话题时，在关联表中记录已点赞
     * @date 19-07-20
     * @Param1: 用户id
     * @Param2: 话题id
     * @return int
     */
    public int recordAddStar(@Param("userId") Integer userId, @Param("topicId") Integer topicId);



    /**
     * @author Jiang Jingyuan
     * @description: 判断用户是否关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int isFollowDoctor(@org.springframework.data.repository.query.Param("userId") Integer userId, @org.springframework.data.repository.query.Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int followDoctor(@org.springframework.data.repository.query.Param("userId") Integer userId, @org.springframework.data.repository.query.Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户取消关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int reverseFollowDoctor(@org.springframework.data.repository.query.Param("userId") Integer userId, @org.springframework.data.repository.query.Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 查询用户关注的医生信息
     * @date 19-07-20
     * @Param: userId
     * @return 医生信息
     */
    public List<Doctorinfor> myDoctor(@org.springframework.data.repository.query.Param("userId") Integer userId);
    /**
     * @author Jiang Jingyuan
     * @description: 查询用户关注的医生以及医生发布的话题信息
     * @date 19-07-21
     * @Param: userId
     * @return 话题
     */
    public List<DoctorTopic> myDoctorTopic(@org.springframework.data.repository.query.Param("userId") Integer userId);


    List<DoctorTopic> findallbyname(@Param("drugname") String drugname);

    public List<DoctorTopic> aboutFindByName(@Param("tiaoJian") String tiaoJian);
}
