package com.qf.eason.controller;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.pojo.Druginfor;
import com.qf.eason.pojo.Talk;
import com.qf.eason.service.DoctorTopicService;
import com.qf.eason.service.DoctorinforServcie;
import com.qf.eason.service.DrugService;
import com.qf.eason.service.TalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("druginfor")
public class DruginforController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private TalkService talkService;
    @Autowired
    private DoctorinforServcie doctorinforServcie;
    @Autowired
    private DoctorTopicService doctorTopicService;
    @RequestMapping(value = "druginforbyname",method = RequestMethod.GET)
    @ApiOperation("通过药品Name查询对应的药品信息（包括话题、药物详情等）")
    public Object druginforbyid(String drugname){
        List<Druginfor> druginforList=drugService.findallbyname(drugname);
        List<Doctorinfor> doctorinforList = doctorinforServcie.load();
        List<DoctorTopic> doctorTopic=doctorTopicService.findallbyname(drugname);
        List<Talk> talkList=talkService.findallbyname(drugname);

        List<Object> objectList=new ArrayList<>();
        objectList.add(druginforList);
        objectList.add(talkList);
        objectList.add(doctorinforList);
        objectList.add(doctorTopic);
        return objectList;
    }
}
