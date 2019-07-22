package com.qf.eason.controller;

import com.qf.eason.pojo.Talk;
import com.qf.eason.service.TalkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/add")
public class TalkController {
    @Autowired
    private TalkService talkService;
    @RequestMapping(value = "/addproblem",method = RequestMethod.PUT)
    @ApiOperation(value = "添加医生用户对话记录")
    public int addproblem(Talk talk){
        String userImg = talk.getUserImg();
        return  talkService.addtalk(talk);
    }
    @ApiOperation(value = "医生回答用户问题")
    @RequestMapping(value = "/answer",method = RequestMethod.POST)
    public int doctorAnswer(@RequestParam Integer udId,@RequestParam String doctorAnswer){
        return  talkService.doctoranswer(udId,doctorAnswer);
    }
    @ApiOperation(value = "展示所有对话信息")
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public List<Talk> findall(){
        return  talkService.findall();
    }
}
