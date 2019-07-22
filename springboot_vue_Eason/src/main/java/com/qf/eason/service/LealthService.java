package com.qf.eason.service;

import com.qf.eason.pojo.Lealth;
import com.qf.eason.response.QueryResponseResult;


public interface LealthService {
    //查所有
    public QueryResponseResult findAll();
    //删除
    public Boolean deleteById(Integer id);
    //根据id查询用户
    public Lealth findById(Integer id);
    //修改
    public Boolean updataLerlth(Lealth lealth);
}
