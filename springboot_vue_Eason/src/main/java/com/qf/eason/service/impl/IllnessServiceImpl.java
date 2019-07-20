package com.qf.eason.service.impl;

import com.qf.eason.dao.IllnessMapper;
import com.qf.eason.pojo.Illness;
import com.qf.eason.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired(required = false)
    private IllnessMapper illnessMapper;
    @Override
    public List<Illness> findByNesCrowd(String nesCrowd) {
        List<Illness> illnessList = illnessMapper.findByNesCrowd(nesCrowd);
        return illnessList;
    }
}
