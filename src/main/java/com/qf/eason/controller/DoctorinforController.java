package com.qf.eason.controller;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.pojo.Talk;
import com.qf.eason.service.DoctorTopicService;
import com.qf.eason.service.DoctorinforServcie;
import com.qf.eason.service.TalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Doctorin")
@ResponseBody
/**
 * caoyang
 * 2019/07/20
 */
public class DoctorinforController {

    @Autowired
    private DoctorinforServcie doctorinforServcie;

    @Autowired
    private DoctorTopicService doctorTopicService;

    @Autowired
    private TalkService talkService;
    @RequestMapping(value="/findall",method = RequestMethod.GET)
    @ApiOperation("根据科室或医生名字或疾病或医院查询 或者医院地区")
    public List<Doctorinfor> findAll(String string){
        return doctorinforServcie.findAll(string);
    }

    @RequestMapping(value="/findById",method = RequestMethod.GET)
    @ApiOperation("根据医生Id查询医生相关信息")
    public Map<String,Object> findById(Integer id){
        /* Doctorinfor byId = doctorinforServcie.findById(id);*/

        List<Talk> talks = talkService.findallProblem(id);
        List<DoctorTopic> topicBydoctorId = doctorTopicService.findTopicBydoctorId(id);
        Map<String,Object> stringListHashMap = new HashMap<>();
        stringListHashMap.put("talks",talks);
        stringListHashMap.put("doctorTopic",topicBydoctorId);
        return stringListHashMap;
    }

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ApiOperation("无条件查询所有医生")
    public List<Doctorinfor> load(){
        return doctorinforServcie.load();
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ApiOperation("根据医院等级查询")
    public List<Doctorinfor> find(String string){
        return doctorinforServcie.find(string);
    }

    @RequestMapping(value = "/findOffice",method = RequestMethod.GET)
    @ApiOperation("查询已有科室")
    public List<String> findOffice(){
        return doctorinforServcie.findOffice();
    }
}
