package com.qf.eason.dao;

import com.qf.eason.pojo.DoctorTopic;
import com.qf.eason.pojo.Doctorinfor;
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
//    // 根据id查询
//    public User findById(Integer id);
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

    // 根据id修改手机号
    public int updatePhone(User user);


    /**
     * @author Jiang Jingyuan
     * @description: 判断用户是否关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int isFollowDoctor(@Param("userId") Integer userId, @Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int followDoctor(@Param("userId") Integer userId, @Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 用户取消关注医生
     * @date 19-07-20
     * @Param: userId
     * @Param: doctorId
     * @return int
     */
    public int reverseFollowDoctor(@Param("userId") Integer userId, @Param("doctorId") Integer doctorId);
    /**
     * @author Jiang Jingyuan
     * @description: 查询用户关注的医生信息
     * @date 19-07-20
     * @Param: userId
     * @return 医生信息
     */
    public List<Doctorinfor> myDoctor(@Param("userId") Integer userId);
    /**
     * @author Jiang Jingyuan
     * @description: 查询用户关注的医生以及医生发布的话题信息
     * @date 19-07-21
     * @Param: userId
     * @return 话题
     */
    public List<DoctorTopic> myDoctorTopic(@Param("userId") Integer userId);

}
