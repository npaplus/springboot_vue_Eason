package com.qf.eason.dao;

import com.qf.eason.pojo.OfficeType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficeTypeMapper {
    //根据名称俩表查询
    public List<OfficeType> findByName(String name);
}
