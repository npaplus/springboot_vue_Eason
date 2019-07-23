package com.qf.eason.controller;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.service.DoctorTopicService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: springboot
 * @description: 医生话题业务控制器
 * @author: Jiang Jingyuan
 * @create: 2019-07-20
 */
@Controller
@ResponseBody
@RequestMapping("/doctorTopic")
public class DoctorTopicController {
    @Autowired
    private DoctorTopicService doctorTopicService;

    @GetMapping(value = "/findAllTopic")
    @ApiOperation(value = "春雨--医生话题/科普--话题：查询含医生信息的全部话题，按发布日期逆序")
    List<DoctorTopic> findAllTopic(){
        return doctorTopicService.findAllTopic();
    }

    @GetMapping(value = "/findTopicBydoctorId/{doctorId}")
    @ApiOperation(value = "医生服务综合展示页--医生话题：通过医生id查询其发布的所有话题，按发布日期逆序")
    @ApiImplicitParam(name = "doctorId",value = "医生id",required = true)
    List<DoctorTopic> findTopicBydoctorId(@PathVariable("doctorId")Integer doctorId){
        return doctorTopicService.findTopicBydoctorId(doctorId);
    }

    @PutMapping(value = "/addReading/{topicId}")
    @ApiOperation(value = "用户操作：话题阅读量+1")
    @ApiImplicitParam(name = "topicId",value = "话题id",required = true)
    boolean addReading(@PathVariable("topicId")Integer topicId) {
        return doctorTopicService.addReading(topicId);
    }

    @GetMapping(value = "/isGiveStar/{userId}/{topicId}")
    @ApiOperation(value = "页面载入：判断用户是否已经给某话题点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "topicId",value = "话题id",required = true)
    })
    boolean isGiveStar(@PathVariable("userId")Integer userId,@PathVariable("topicId")Integer topicId){
        return doctorTopicService.isGiveStar(userId,topicId);
    }

    @PostMapping(value = "/giveStar/{userId}/{topicId}")
    @ApiOperation(value = "用户操作：用户给话题点赞，只一次，不可逆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "topicId",value = "话题id",required = true)
    })
    boolean giveStar(@PathVariable("userId")Integer userId,@PathVariable("topicId")Integer topicId){
        return doctorTopicService.giveStar(userId,topicId);
    }

    @GetMapping(value = "/isFollowDoctor/{userId}/{doctorId}")
    @ApiOperation(value = "页面载入：判断用户是否已经关注医生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "doctorId",value = "医生id",required = true)
    })
    public boolean isFollowDoctor(@PathVariable("userId")Integer userId, @PathVariable("doctorId")Integer doctorId){
        return doctorTopicService.isFollowDoctor(userId,doctorId);
    }

    @PostMapping(value = "/followDoctor/{userId}/{doctorId}")
    @ApiOperation(value = "用户操作：用户关注医生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "doctorId",value = "医生id",required = true)
    })
    public boolean followDoctor(@PathVariable("userId")Integer userId, @PathVariable("doctorId")Integer doctorId){
        return doctorTopicService.followDoctor(userId,doctorId);
    }

    @DeleteMapping(value = "/reverseFollowDoctor/{userId}/{doctorId}")
    @ApiOperation(value = "用户操作：用户取消关注医生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "doctorId",value = "医生id",required = true)
    })
    public boolean reverseFollowDoctor(@PathVariable("userId")Integer userId, @PathVariable("doctorId")Integer doctorId){
        return doctorTopicService.reverseFollowDoctor(userId,doctorId);
    }
    @GetMapping(value = "/myDoctor/{userId}")
    @ApiOperation(value = "我的咨询--我的医生：查询用户关注的医生信息")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true)
    public List<Doctorinfor> myDoctor(@PathVariable("userId")Integer userId){
        return doctorTopicService.myDoctor(userId);
    }

    @GetMapping(value = "/myDoctorTopic/{userId}")
    @ApiOperation(value = "我的咨询--我的医生--医生动态：查询用户关注的医生以及医生发布的话题信息，按发布日期逆序")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true)
    public List<DoctorTopic> myDoctorTopic(@PathVariable("userId")Integer userId){
        return doctorTopicService.myDoctorTopic(userId);
    }

}
