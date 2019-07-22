package com.qf.eason.dao;

import com.qf.eason.pojo.Lealth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LealthMapper {
    //查所有
    public List<Lealth> findAll();
    //删除
    public int deleteById(Integer id);
    //根据id查询用户
    public Lealth findById(Integer id);
    //修改
    public int updataLerlth(Lealth lealth);
    public Lealth findOne(@Param("name")String name,@Param("pwa")String pwa);
}
