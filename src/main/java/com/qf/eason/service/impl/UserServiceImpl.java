package com.qf.eason.service.impl;

import com.qf.eason.dao.UserMapper;
import com.qf.eason.pojo.User;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Service
public class UserServiceImpl implements UserServcie{

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
       /* QueryResult<User> userQueryResult = new QueryResult<>();
        userQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);*/
       return all;
    }

    //user 登录
    @Override
    public boolean loadUser(User user) {
        User u = userMapper.loadUser(user);
        return u!= null?true : false;
    }

    //user注册
    @Override
    public boolean registerUser(User user) {
        return userMapper.registerUser(user)>0?true:false;
    }

//    //根据id修改
//    @Override
//    public boolean updateUser(User user) {
//        User updateUser = userMapper.updateUser(user);
//        return false;
//    }

    // 根据id修改用户昵称
    @Override
    public boolean updateNickname(User user) {
        return userMapper.updateNickname(user)!=0?true:false;
    }

    // 根据id修改用户图片
    @Override
    public boolean updateImg(User user) {
        return userMapper.updateImg(user)!=0?true:false;
    }

    // 根据id和密码(旧)修改用户密码(新)
    @Override
    public boolean updatePassword(String newPassWord, String userPassword, Integer userId) {
        return userMapper.updatePassword(newPassWord, userPassword, userId)!=0?true:false;
    }

    // 根据用户id查找密码
    @Override
    public User findById(int userId) {
        User byId = userMapper.findById(userId);
        System.out.println(byId);
        return byId;
    }

    // 根据用户手机查找用户
    @Override
    public User findPhone(String userPhone) {
        //System.out.println(userPhone);
        return userMapper.findPhone(userPhone);
    }


    // 根据用户手机号修改手机号
    @Override
    public int updatePhone(User user) {
        return userMapper.updatePhone(user);
    }

}
