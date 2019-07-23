package com.qf.eason.controller;

import com.qf.eason.pojo.Illness;
import com.qf.eason.service.IllnessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@RequestMapping("/illness")
@Controller
public class IllnessController {
    @Autowired
    private IllnessService illnessService;
    @RequestMapping(value = "/findByNesCrowd",method = RequestMethod.GET)
    @ApiOperation("精确查询")
    public List<Illness> findByNesCrowd(String nesCrowd){
        List<Illness> illnessList = illnessService.findByNesCrowd(nesCrowd);

        return illnessList;
    }

}
