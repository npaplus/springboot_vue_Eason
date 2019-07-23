package com.qf.eason.service;

import com.qf.eason.pojo.Lealth;
import com.qf.eason.response.QueryResponseResult;

import java.util.List;


public interface LealthService {
    //查所有
    public List<Lealth> findAll();
    //删除
    public Boolean deleteById(Integer id);
    //根据id查询用户
    public Lealth findById(Integer id);
    //修改
    public Boolean updataLerlth(Lealth lealth);
}
