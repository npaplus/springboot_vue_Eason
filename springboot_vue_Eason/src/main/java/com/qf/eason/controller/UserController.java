package com.qf.eason.controller;

import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.UserServcie;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServcie userServcie;
//查询所有用户信息
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
     @ApiOperation(value = "查询全部")
    public QueryResponseResult findAll(){
        QueryResponseResult all = userServcie.findAll();
        return all;
    }


}
