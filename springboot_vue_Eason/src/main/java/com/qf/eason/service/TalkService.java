package com.qf.eason.service;

import com.qf.eason.pojo.Talk;

import java.util.List;

public interface TalkService {
    public int addtalk(Talk talk);
    public int doctoranswer(Integer udId, String doctorAnswer);
    public List<Talk> findall();
}
