package com.qf.eason.service;

import com.qf.eason.pojo.User;
import com.qf.eason.response.QueryResponseResult;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
public interface UserServcie {

    public List<User> findAll();

    // user登录
    public boolean loadUser(User user);

    // user注册
    public boolean registerUser(User user);

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


    // 根据用户id查找用户
    public User findById(int userId);

    // 根据用户手机查找用户
    public User findPhone(String userPhone);

    // 根据用户手机修改手机号
    public int updatePhone(User user);
}
