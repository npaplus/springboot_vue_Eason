package com.qf.eason.dao;

import com.qf.eason.pojo.Illness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllnessMapper {
    //精确查询
    List<Illness> findByNesCrowd(String nesCrowd);
}
