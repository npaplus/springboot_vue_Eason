package com.qf.eason.service.impl;

import com.qf.eason.dao.SymptomMapper;
import com.qf.eason.pojo.Symptom;
import com.qf.eason.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired(required = false)
    private SymptomMapper symptomMapper;
    @Override
    public List<Symptom> findByBadyParts(String badyParts) {
        return symptomMapper.findByBadyParts(badyParts);
    }

    @Override
    public List<Symptom> findByName(String name) {
        List<Symptom> byName = symptomMapper.findByName(name);
        return byName;
    }


}
