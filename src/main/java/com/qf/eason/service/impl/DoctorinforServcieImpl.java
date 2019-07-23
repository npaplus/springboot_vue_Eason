package com.qf.eason.service.impl;

import com.qf.eason.dao.DoctorinforMapper;
import com.qf.eason.pojo.Doctorinfor;
import com.qf.eason.service.DoctorinforServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * caoyang
 * 2019/07/20
 */
@Service
public class DoctorinforServcieImpl implements DoctorinforServcie {

    @Autowired(required = false)
    private DoctorinforMapper doctorinforMapper;

    public List<Doctorinfor> findAll(String string) {
        return doctorinforMapper.findAll(string);
    }

    @Override
    public List<Doctorinfor> load() {
        return doctorinforMapper.load();
    }

    @Override
    public List<String> findOffice() {
        return doctorinforMapper.findOffice();
    }

    @Override
    public Doctorinfor findById(Integer id) {
        return doctorinforMapper.findById(id);
    }

    @Override
    public List<Doctorinfor> find(String string) {
        return doctorinforMapper.find(string);
    }
}