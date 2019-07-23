package com.qf.eason.dao;

import com.qf.eason.pojo.Talk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface talkMapper {
    //添加用户提问记录
    public int addTalk(Talk talk);
    public  int answer(@Param("udId") Integer udId,@Param("doctorAnswer") String doctorAnswer);//医生回答用户提问
    //展示所有医生医生对话
    public List<Talk> showall();
    //通过医生id查询用户提问的所有问题
    public  List<Talk> gerallProblem(Integer doctorId);

    public List<Talk> aboutFind(@Param("tiaoJian") String tiaoJian);

    List<Talk> findallbyname(@Param("drugname")String drugname);
}
