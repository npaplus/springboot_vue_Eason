package com.qf.eason.controller;

import com.qf.eason.pojo.Druginfor;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.DrugService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService;
    @RequestMapping(value="/findall",method = RequestMethod.GET)
    @ApiOperation("查询全部")
    public QueryResponseResult findall(){
       QueryResponseResult all= drugService.findall();
       return all;
    }

    @RequestMapping(value="/findallbyid",method = RequestMethod.GET)
    @ApiOperation("通过ID查询对应药品")
    public Druginfor findallbyid(int drugid){
       Druginfor druginfor= drugService.findallbyid(drugid);
        return druginfor;
    }

}
