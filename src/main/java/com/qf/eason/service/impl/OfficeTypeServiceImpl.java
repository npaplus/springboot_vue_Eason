package com.qf.eason.service.impl;

import com.qf.eason.dao.OfficeTypeMapper;
import com.qf.eason.pojo.OfficeType;
import com.qf.eason.service.OfficeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeTypeServiceImpl implements OfficeTypeService {
    @Autowired(required = false)
    private OfficeTypeMapper officeTypeMapper;

    @Override
    public List<OfficeType> findByName(String name) {
        List<OfficeType> officeTypeList = officeTypeMapper.findByName(name);
        return officeTypeList;
    }
}
