package com.qf.eason.service;

import com.qf.eason.pojo.OfficeType;

import java.util.List;

public interface OfficeTypeService {
    //根据名称俩表查询
    public List<OfficeType> findByName(String name);
}
