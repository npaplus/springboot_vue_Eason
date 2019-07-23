package com.qf.eason.service;

import com.qf.eason.pojo.Talk;

import java.util.List;

public interface TalkService {
    public int addtalk(Talk talk);
    public int doctoranswer(Integer udId, String doctorAnswer);
    public List<Talk> findall();

    //通过医生id查询用户提问的所有问题
    public  List<Talk> findallProblem(Integer doctorId);


    List<Talk> findallbyname( String drugname);

    public List<Talk> aboutFind(String tiaoJian);

}
