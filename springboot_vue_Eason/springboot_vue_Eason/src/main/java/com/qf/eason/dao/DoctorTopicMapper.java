package com.qf.eason.dao;

import com.qf.eason.pojo.DoctorTopic;
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
}
