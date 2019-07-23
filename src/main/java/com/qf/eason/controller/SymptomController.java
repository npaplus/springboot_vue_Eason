package com.qf.eason.controller;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.News;
import com.qf.eason.pojo.Symptom;
import com.qf.eason.pojo.Talk;
import com.qf.eason.service.DoctorTopicService;
import com.qf.eason.service.NewsService;
import com.qf.eason.service.SymptomService;
import com.qf.eason.service.TalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping(value ="/symptom")
@ResponseBody
public class SymptomController {

    @Autowired(required = false)
    private SymptomService symptomService;

    @Autowired
    private TalkService talkService;

    @Autowired
    private DoctorTopicService doctorTopicService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/findByBadyParts",method = RequestMethod.GET)
    @ApiOperation(value = "人体图中'全身症状'等查症状（id,症状）")
    public List<Symptom> findByBadyParts(String badyParts) {
        return symptomService.findByBadyParts(badyParts);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ApiOperation(value = "根据症状Id查症状的相关信息")
    public Map<String, Object> findById(String tiaoJian) {
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        List<Talk> talks = talkService.aboutFind(tiaoJian);
        List<Symptom> byName = symptomService.findByName(tiaoJian);
        List<News> news = newsService.aboutFind(tiaoJian);
        List<DoctorTopic> doctorTopics = doctorTopicService.aboutFindByName(tiaoJian);
        stringObjectHashMap.put("talks",talks);
        stringObjectHashMap.put("symptom",byName);
        stringObjectHashMap.put("news",news);
        stringObjectHashMap.put("doctorTopic",doctorTopics);
        return stringObjectHashMap;
    }



}
