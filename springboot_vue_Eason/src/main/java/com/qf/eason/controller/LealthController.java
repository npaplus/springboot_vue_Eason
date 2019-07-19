package com.qf.eason.controller;

import com.qf.eason.pojo.Lealth;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.LealthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/lealth")
public class LealthController {
    @Autowired
    private LealthService lealthService;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation(value = "查询全部")
    public QueryResponseResult findAll(){
        QueryResponseResult all = lealthService.findAll();
        return all;
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除")
    public String deleteById(Integer id){
        Boolean b = lealthService.deleteById(id);
        return b?"成功":"失败";
    }
    @RequestMapping(value = "/updataLerlth",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public String updataLerlth(Lealth lealth){
        Boolean b = lealthService.updataLerlth(lealth);
        return b?"成功":"失败";
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ApiOperation(value = "根据id查找信息")
    public Lealth findById(Integer id){
        Lealth lealth = lealthService.findById(id);
        return lealth;
    }
}
