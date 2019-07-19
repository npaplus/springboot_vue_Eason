package com.qf.eason.dao;

import com.qf.eason.pojo.Druginfor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugMapper {
    public List<Druginfor> findall();

    Druginfor findallbyid(int drugid);
}
