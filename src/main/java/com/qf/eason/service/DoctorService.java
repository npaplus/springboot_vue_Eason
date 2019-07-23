package com.qf.eason.service;

import com.qf.eason.pojo.Doctor;
import com.qf.eason.response.QueryResponseResult;

import java.util.List;

public interface DoctorService {
    public Boolean loadDoctor(Doctor doctor);
    public QueryResponseResult loadAll();
}
