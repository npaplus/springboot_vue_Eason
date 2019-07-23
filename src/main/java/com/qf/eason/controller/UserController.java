package com.qf.eason.controller;

import com.aliyuncs.exceptions.ClientException;
import com.qf.eason.config.DuanXinYZ;
import com.qf.eason.config.YanZhengCode;
import com.qf.eason.pojo.User;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.service.UserServcie;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private UserServcie userServcie;

    //查询所有用户信息
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部")
    public List<User> findAll() {
        List<User> all = userServcie.findAll();
        return all;
    }

    //user登录
    @ResponseBody
    @RequestMapping(value = "/loadUser", method = RequestMethod.GET)
    @ApiOperation(value = "用户登录", notes = "text：成功返回1")
    public int loadUser(String userPhone,String password) {
        User user = new User();
        user.setUserPhone(userPhone);
        user.setUserPassword(password);
        boolean bool = userServcie.loadUser(user);
        if (bool) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/registerYZ",method = RequestMethod.GET)
    @ApiOperation(value = "用户注册手机短信验证")
    public int registerYZ(String num,HttpSession session) throws ClientException {
        User user = userServcie.findPhone(num);
            if (user!=null){
                return 0;
            }else {
                String code = YanZhengCode.getNewcode();
               // int i = DuanXinYZ.faSong(num,code);
                session.setAttribute("num",num);
                session.setAttribute("code",code);
                System.out.println(code);
                return 1;
            }
    }

    //user注册
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户", notes = "text:成功返回1")
    // 设置两个参数，让其昵称默认等于手机号码
    public int registerUser(String code, String UserPassword, HttpSession session) {
        User user = new User();
        // 设置一个昵称参数值为手机号码(昵称默认为手机号)
        String num =(String) session.getAttribute("num");
        System.out.println(num);
        String newcode1 =(String)session.getAttribute("code");
        System.out.println(code);
        if (code.equals(newcode1)){
            user.setUserNickname(num);
            user.setUserPhone(num);
            user.setUserPassword(UserPassword);
            userServcie.registerUser(user);
            return 1;
        }else {
            return 0;
        }

    }


    // 根据id修改用户昵称
    @ResponseBody
    @RequestMapping(value = "/updateNickname", method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改用户昵称", notes = "text:成功返回1")
    public int updateNickname(Integer id, String userNickname) {
        User user = new User();
        user.setUserId(id);
        user.setUserNickname(userNickname);
        boolean bool = userServcie.updateNickname(user);
        return bool ? 1 : 0;
    }

    // 根据id修改用户图片
    @ResponseBody
    @RequestMapping(value = "updateImg", method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改用户图片", notes = "texr:成功返回1")
    public int updateImg(Integer id, String userImg) {
        User user = new User();
        user.setUserId(id);
        user.setUserImg(userImg);
        boolean bool = userServcie.updateImg(user);
        return bool ? 1 : 0;
    }

    // 根据id和密码(旧)修改用户密码(新)
    @ResponseBody
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码", notes = "txet:成功返回1")
    public int updatePassword(Integer userId, String userPassword, String newPassWord) {
       /* User user = new User();
        user.setUserId(id);
        user.setUserPassword(userPassword);*/
        boolean bool = userServcie.updatePassword(newPassWord, userPassword, userId);
        return bool ? 1 : 0;
    }


    // 根据用户id查找密码
    @RequestMapping(value = "findPassword", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查找密码", notes = "texr:正确返回1")
    public int findPassword(Integer id,String password,HttpSession session) {
        User byId = userServcie.findById(id);
        String userPassword = byId.getUserPassword();
        session.setAttribute("userid",id);
        System.out.println(userPassword.equals(password));
        if (userPassword.equals(password)) {
            return 1;
        }
        return 0;
    }
//    // 根据用户手机查找用户
//    @RequestMapping(value = "findPhone",method = RequestMethod.GET)
//    @ApiOperation(value = "根据用户手机号查找用户",notes = "texr:成功返回1")
//    public int findPhone(String userPhone,HttpSession session) throws ClientException {
//        User user = userServcie.findPhone(userPhone);
//        if(user!=null){
//            return 0;
//        }else {
//            session.setAttribute("userPhone", userPhone);
//            //发送验证吗  并存入session
//            String newcode = YanZhengCode.getNewcode();
//            int i = DuanXinYZ.faSong(userPhone, newcode);
//            session.setAttribute("newcode", newcode);
//            return 1;
//        }
//    }

    @RequestMapping(value = "/updateYZ",method = RequestMethod.GET)
    @ApiOperation(value = "用户修改手机短信验证")
    public int updateYZ(String num,HttpSession session) throws ClientException {
        User user = userServcie.findPhone(num);
        if (user!=null){
            return 0;
        }else {
            String newcode = YanZhengCode.getNewcode();
            System.out.println(newcode);
            int i = DuanXinYZ.faSong(num, newcode);
            session.setAttribute("num",num);
            session.setAttribute("newcode",newcode);
            return i;
        }
    }
//     根据id修改手机号
     @RequestMapping(value = "updatePhone", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户id修改手机号", notes = "texr:成功返回1")
    public int updatePhone(String newcode, HttpSession session) throws ClientException {
            //发送验证吗  并存入session
            String num =(String) session.getAttribute("num");
            String newcode1 =(String)session.getAttribute("newcode");
            int b=0;
            if (newcode.equals(newcode1)){
                int userid =(int)session.getAttribute("userid");
                User user = new User();
                user.setUserId(userid);
                user.setUserPhone(num);
                b = userServcie.updatePhone(user);
                return b;
            }
            return b;

    }
}