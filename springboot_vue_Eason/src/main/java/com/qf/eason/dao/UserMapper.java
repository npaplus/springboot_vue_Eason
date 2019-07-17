package com.qf.eason.dao;

import com.qf.eason.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Mapper
public interface UserMapper {
    //查询所有用户信息
    public List<User> findAll();

}
