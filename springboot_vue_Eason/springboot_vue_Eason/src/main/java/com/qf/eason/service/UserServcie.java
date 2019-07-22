package com.qf.eason.service;

import com.qf.eason.pojo.User;
import com.qf.eason.response.QueryResponseResult;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
public interface UserServcie {

    public QueryResponseResult findAll();

    // user登录
    public boolean loadUser(User user);

    // user注册
    public boolean registerUser(User user);

//    // 根据id查询
//    public User findById(Integer id);
//
//    // 根据id修改
//    public boolean updateUser(User user);

    // 根据id修改用户昵称
    public boolean updateNickname(User user);

    // 根据id修改用户图片
    public boolean updateImg(User user);

    // 根据id和密码(旧)修改用户密码(新)
    public boolean updatePassword(@Param("newPassWord") String newPassWord,
                                  @Param("userPassword") String userPassword,
                                  @Param("userId") Integer userId);

    // 根据id修改手机号
    public boolean updatePhone(User user);;


    /**
     * @author Jiang Jingyuan
     * @description:
     * @date 19-07-22
     * @Param:
     * @return
     */
    //判断用户是否已经关注医生
    public boolean isFollowDoctor(Integer userId,Integer doctorId);
    //用户关注医生
    public boolean followDoctor(Integer userId,Integer doctorId);
    //用户取消关注医生
    public boolean reverseFollowDoctor(Integer userId,Integer doctorId);
    //查询用户关注的医生信息
    public QueryResponseResult myDoctor(Integer userId);
    //查询用户关注的医生以及医生发布的话题信息
    public QueryResponseResult myDoctorTopic(Integer userId);
}
