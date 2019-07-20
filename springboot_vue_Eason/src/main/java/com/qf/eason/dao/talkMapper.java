package com.qf.eason.dao;

import com.qf.eason.pojo.Talk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface talkMapper {
    public int addTalk(Talk talk);//添加用户提问记录
    public  int answer(Integer udId, String doctorAnswer);//医生回答用户提问
    public List<Talk> showall();//展示所有医生医生对话
}
