package com.qf.eason.service.impl;

import com.qf.eason.dao.LealthMapper;
import com.qf.eason.pojo.Lealth;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.LealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LealthServiceImpl implements LealthService {
    @Autowired(required = false)
    private LealthMapper lealthMapper;


    @Override
    public List<Lealth> findAll() {
        List<Lealth> all = lealthMapper.findAll();
        /*QueryResult<Lealth> queryResult=new QueryResult<>();
        queryResult.setList(all);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);*/
        return all;
    }

    @Override
    public Boolean deleteById(Integer id) {

        return lealthMapper.deleteById(id)>0?true:false;
    }

    @Override
    public Lealth findById(Integer id) {

        return lealthMapper.findById(id);
    }

    @Override
    public Boolean updataLerlth(Lealth lealth) {
        return lealthMapper.updataLerlth(lealth)>0?true:false;
    }
}
