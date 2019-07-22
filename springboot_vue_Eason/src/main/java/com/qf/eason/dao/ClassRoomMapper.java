package com.qf.eason.dao;

import com.qf.eason.pojo.ClassRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassRoomMapper {
    //查询所有
    public List<ClassRoom> findAll();
}
