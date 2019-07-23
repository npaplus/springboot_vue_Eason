package com.qf.eason.controller;

import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.pojo.Lealth;
import com.qf.eason.pojo.User;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.DoctorinforServcie;
import com.qf.eason.service.LealthService;
import com.qf.eason.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/22.
 */
@Controller
public class BackstageController {

    @Autowired
    private UserServcie userServcie;
    @Autowired
    private LealthService lealthService;
    @Autowired
    private DoctorinforServcie doctorinforServcie;

    @RequestMapping(value = "/logins",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    //管理员登录
    @ResponseBody
    @RequestMapping(value = "/mains",method = RequestMethod.POST)
    public int login(String name,String pow){
        if ("admin".equals(name)&&"admin".equals(pow)){
            return 1;
        }
        return 0;
    }
//展示所有账户信息
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView findUser(){
        ModelAndView mav = new ModelAndView();
        List<User> all = userServcie.findAll();

        mav.addObject("userAll",all);
        mav.setViewName("user");
        return mav;
    }

    //展示所有用户健康信息
    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public ModelAndView findLealth(){
        List<Lealth> all = lealthService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("lealth",all);
        mav.setViewName("role");
        return mav;
    }

    //展示所有医师信息
     @RequestMapping(value = "/doctors",method = RequestMethod.GET)
    public ModelAndView findDoctor(){
         ModelAndView mav = new ModelAndView();
         List<Doctorinfor> load = doctorinforServcie.load();
         mav.addObject("doctor",load);
         mav.setViewName("doctor");
         return mav;
     }
}
