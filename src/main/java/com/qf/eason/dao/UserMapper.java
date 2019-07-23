package com.qf.eason.dao;

import com.qf.eason.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Mapper
public interface UserMapper {
    //查询所有用户信息
    public List<User> findAll();
    //user登录
    public User loadUser(User user);
    //user 注册
    public int registerUser(User user);
//    // 根据id修改
//    public User updateUser(User user);

    // 根据id修改用户昵称
    public int updateNickname(User user);

    // 根据id修改用户图片
    public int updateImg(User user);

    // 根据id和密码(旧)修改用户密码(新)
    public int updatePassword(@Param("newPassWord") String newPassWord,
                              @Param("userPassword") String userPassword,
                              @Param("userId") Integer userId);

    // 根据用户id查找用户
    public User findById(Integer userId);
    // 根据用户手机查找用户
    public User findPhone(String userPhone);

    // 根据用户手机修改手机号
    public int updatePhone(User user);
}
