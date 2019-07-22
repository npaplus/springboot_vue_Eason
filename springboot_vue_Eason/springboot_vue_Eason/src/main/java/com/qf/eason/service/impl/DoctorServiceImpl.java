package com.qf.eason.service.impl;

import com.qf.eason.dao.DoctorMapper;
import com.qf.eason.pojo.Doctor;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired(required = false)
    private DoctorMapper doctorMapper;

    //登录
    @Override
    public Boolean loadDoctor(Doctor doctor) {
        Doctor b = doctorMapper.loadDoctor(doctor);
        return b!=null?true:false;
    }
    //查所有
    @Override
    public QueryResponseResult loadAll() {
        List<Doctor> all = doctorMapper.loadAll();
        QueryResult<Doctor> doctorQueryResult=new QueryResult<>();
        doctorQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,doctorQueryResult);
    }
}
