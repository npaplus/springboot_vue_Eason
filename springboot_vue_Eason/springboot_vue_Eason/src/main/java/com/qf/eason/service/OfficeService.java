package com.qf.eason.service;

import com.qf.eason.pojo.Office;

import java.util.List;

public interface OfficeService {
    //根据名字俩表联查
    public List<Office> findByName(String officeName);
}
