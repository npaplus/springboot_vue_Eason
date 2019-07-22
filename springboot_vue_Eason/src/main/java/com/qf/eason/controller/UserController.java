package com.qf.eason.controller;

import com.aliyuncs.exceptions.ClientException;
import com.qf.eason.config.DuanXinYZ;
import com.qf.eason.config.YanZhengCode;
import com.qf.eason.pojo.User;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.UserServcie;
import com.qf.eason.utils.UploadUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UploadUtils uploadUtils;

    @Autowired
    private UserServcie userServcie;
//查询所有用户信息
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
     @ApiOperation(value = "查询全部")
    public QueryResponseResult findAll(){
        QueryResponseResult all = userServcie.findAll();
        return all;
    }

    //user登录
    @RequestMapping(value = "/loadUser",method = RequestMethod.GET)
    @ApiOperation(value = "用户登录",notes = "text：成功返回1")
    public int loadUser(User user){
        boolean bool = userServcie.loadUser(user);
        if (bool){
            return 1;
        }else {
            return 0;
        }
    }
//短信验证
    @RequestMapping(value = "/yanzheng",method = RequestMethod.GET)
    @ApiOperation(value = "短信验证")
    public int yanzheng(String num) throws ClientException {
        String newcode = YanZhengCode.getNewcode();
        int i = DuanXinYZ.faSong(num, newcode);
        return i;
    }
     //user注册

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    @ApiOperation(value = "注册用户",notes = "text:成功返回1")
    // 设置两个参数，让其昵称默认等于手机号码
    public int registerUser(String UserPhone,String UserPassword){
        User user = new User();
        // 设置一个昵称参数值为手机号码(昵称默认为手机号)
        user.setUserNickname(UserPhone);
        user.setUserPhone(UserPhone);
        user.setUserPassword(UserPassword);
        boolean bool = userServcie.registerUser(user);
        if (bool){
            return 1;
        }else {
            return 0;
        }
    }

//    //根据id查询
//    @RequestMapping(value = "/findById",method = RequestMethod.GET)
//    public int findById(User user, Model model,HttpSession session){
//        int i = (int)session.getAttribute("id");
//        user.setUserId(i);
//        boolean bool = userServcie.updateUser(user);
//        return bool?1:0;
//    }
//    // 根据id修改
//    @ResponseBody
//    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
//    @ApiOperation(value = "根据id修改")
//    public int updateUser(Integer id,Model model,HttpSession session){
//        User user = userServcie.findById(id);
//        session.setAttribute("id",id);
//        model.addAttribute("user",user);
//        return 1;
//    }


    // 根据id修改用户昵称

    @RequestMapping(value = "/updateNickname",method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改用户昵称",notes = "text:成功返回1")
    public int updateNickname(Integer id,String userNickname){
        User user = new User();
        user.setUserId(id);
        user.setUserNickname(userNickname);
        boolean bool = userServcie.updateNickname(user);
        return bool?1:0;
    }

    // 根据id修改用户图片

    @RequestMapping(value = "updateImg",method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改用户图片",notes = "texr:成功返回1")
    public int updateImg(Integer id,@RequestParam("file")MultipartFile file){
        String img=null;
        if (file!=null&&!file.getOriginalFilename().equals("")){
             img = uploadUtils.savePic(file);
        }
        User user = new User();
        user.setUserId(id);
        user.setUserImg(img);
        boolean bool = userServcie.updateImg(user);
        return bool?1:0;
    }

    // 根据id和密码(旧)修改用户密码(新)

    @RequestMapping(value = "updatePassword",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码",notes = "txet:成功返回1")
    public int updatePassword(Integer userId,String userPassword,String newPassWord){
       /* User user = new User();
        user.setUserId(id);
        user.setUserPassword(userPassword);*/
        boolean bool = userServcie.updatePassword(newPassWord,userPassword,userId);
        return bool?1:0;
    }


    @RequestMapping(value = "updatePhone",method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改手机号",notes = "texr:成功返回1")
    // 根据id修改手机号
    public int updatePhone(Integer id,String userPhone){
        User user = new User();
        user.setUserId(id);
        user.setUserPhone(userPhone);
        boolean bool = userServcie.updatePhone(user);
        return bool?1:0;
    }
}
