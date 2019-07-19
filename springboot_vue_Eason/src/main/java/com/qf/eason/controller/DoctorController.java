package com.qf.eason.controller;

import com.qf.eason.pojo.Doctor;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping(value = "/loadDoctor",method = RequestMethod.GET)
    @ApiOperation(value = "登录")
    public String loadDoctor(Doctor doctor, Model model){
        Boolean b = doctorService.loadDoctor(doctor);
        if (b){
            model.addAttribute("doctor",doctor);
            return "成功";
        }else {
            return "失败";
        }
    }
    @RequestMapping(value = "loadAll",method = RequestMethod.GET)
    @ApiOperation(value = "查所有")
    public QueryResponseResult loadAll(){
        QueryResponseResult all = doctorService.loadAll();
        return all;
    }

}