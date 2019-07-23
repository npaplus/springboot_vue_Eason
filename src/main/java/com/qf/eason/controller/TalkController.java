package com.qf.eason.controller;

import com.qf.eason.pojo.Talk;
import com.qf.eason.service.TalkService;
import com.qf.eason.utils.UploadUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/add")
public class TalkController {
   /* private  Integer udId;
    private  Integer userId;
    private String userImg;
    private  Integer doctorId;
    private String neckName;
    private  String userProblem;//用户提问
    private  String doctorAnswer;//医生回答
    private String userAppraise;//用户好评*/
   @Autowired
   private UploadUtils uploadUtils;
    @Autowired
    private TalkService talkService;
    @RequestMapping(value = "/addproblem",method = RequestMethod.PUT)
    @ApiOperation(value = "添加用户提问医生对话记录")
    public int addproblem(@RequestParam String userProblem ,@RequestParam Integer userId,@RequestParam(value = "doctorIdList")  List<Integer> doctorIdList ,@RequestParam("file") MultipartFile file){
        String pic=null;
        if (file!=null&&!file.getOriginalFilename().equals("")){
            pic = uploadUtils.savePic(file);
        }
        for ( int doctorid:doctorIdList) {
            Talk talk = new Talk();
            talk.setDoctorId(doctorid);
            talk.setUserId(userId);
            talk.setUserProblem(userProblem);
            talk.setUserImg(pic);
            talkService.addtalk(talk);
        }
       return 0;
     /*   return  talkService.addtalk(talk);*/
    }
    @ApiOperation(value = "医生回答用户问题")
    @RequestMapping(value = "/answer",method = RequestMethod.PUT)
    public int doctorAnswer(@RequestParam Integer udId,@RequestParam String doctorAnswer){

        return  talkService.doctoranswer(udId,doctorAnswer);
    }
    @ApiOperation(value = "展示所有对话信息")
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public List<Talk> findall(){
        return  talkService.findall();
    }
}
