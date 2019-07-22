package com.qf.eason.dao;

import com.qf.eason.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DoctorMapper {
    public Doctor loadDoctor(Doctor doctor);
    public List<Doctor> loadAll();
}
