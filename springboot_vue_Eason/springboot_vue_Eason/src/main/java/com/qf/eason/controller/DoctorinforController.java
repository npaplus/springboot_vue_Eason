package com.qf.eason.controller;

import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.service.DoctorinforServcie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/doctorinfor")
@ResponseBody
/**
 * caoyang
 * 2019/07/20
 */

public class DoctorinforController {

    @Autowired
    private DoctorinforServcie doctorinforServcie;


    @RequestMapping(value="/findall",method = RequestMethod.GET)
    @ApiOperation("根据科室或医生名字或疾病或医院查询 或者医院地区")
    public List<Doctorinfor> findAll(String string){
        return doctorinforServcie.findAll(string);
    }

    @RequestMapping(value="/findById",method = RequestMethod.GET)
    @ApiOperation("根据医生Id查询")
    public Doctorinfor findById(Integer id){
        return doctorinforServcie.findById(id);
    }

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ApiOperation("无条件查询所有医生")
    public List<Doctorinfor> load(){
        return doctorinforServcie.load();
    }

    @RequestMapping(value = "findBytype",method = RequestMethod.GET)
    @ApiOperation("根据医院等级查询")
    public List<Doctorinfor> findBytype(String string){
        return doctorinforServcie.find(string);
    }
}
