package com.qf.eason.service.impl;

import com.qf.eason.dao.talkMapper;
import com.qf.eason.pojo.Talk;
import com.qf.eason.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class talkServiceImp implements TalkService {
    @Autowired(required = false)
    private talkMapper talkmapper;
    @Override
    public int addtalk(Talk talk) {
        return talkmapper.addTalk(talk);
    }

    @Override
    public int doctoranswer(Integer udId, String doctorAnswer) {
        return talkmapper.answer(udId,doctorAnswer);
    }

    @Override
    public List<Talk> findall() {
        return talkmapper.showall();
    }

    @Override
    public List<Talk> findallProblem(Integer doctorId) {
        return talkmapper.gerallProblem(doctorId);
    }

    @Override
    public List<Talk> findallbyname(String drugname) {
        return talkmapper.findallbyname(drugname);
    }

    @Override
    public List<Talk> aboutFind(String tiaoJian) {
        List<Talk> talks = talkmapper.aboutFind(tiaoJian);
        return talks;
    }


}
