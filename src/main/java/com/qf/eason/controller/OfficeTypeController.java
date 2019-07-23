package com.qf.eason.controller;

import com.qf.eason.pojo.OfficeType;
import com.qf.eason.service.OfficeTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@RequestMapping("/officeType")
@Controller
public class OfficeTypeController {
    @Autowired
    private OfficeTypeService officeTypeService;
    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    @ApiOperation("根据名称俩表查询")
    public List<OfficeType> findByName(String name){
        List<OfficeType> name1 = officeTypeService.findByName(name);
        return name1;
    }
}
