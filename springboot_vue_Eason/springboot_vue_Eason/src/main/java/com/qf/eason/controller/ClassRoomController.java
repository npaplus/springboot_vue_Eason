package com.qf.eason.controller;

import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.ClassRoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/classRoom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询所有")
    public QueryResponseResult findAll(){
        QueryResponseResult all = classRoomService.findAll();
        return all;
    }


}
