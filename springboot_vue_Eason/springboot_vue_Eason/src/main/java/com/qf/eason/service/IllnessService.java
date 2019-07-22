package com.qf.eason.service;

import com.qf.eason.pojo.Illness;

import java.util.List;

public interface IllnessService {
    //精确查询
    List<Illness> findByNesCrowd(String nesCrowd);

}
