package com.qf.eason.service.impl;

import com.qf.eason.dao.DrugMapper;
import com.qf.eason.pojo.Druginfor;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired(required = false)
    private DrugMapper drugMapper;


    @Override
    public QueryResponseResult findall() {
        List<Druginfor> druginforList= drugMapper.findall();
        QueryResult<Druginfor> queryResult=new QueryResult<>();
        queryResult.setList(druginforList);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public Druginfor findallbyid(int drugid) {
        return drugMapper.findallbyid(drugid);
    }

    @Override
    public List<Druginfor> findallbytypeid(int typeid) {
        return drugMapper.findallbytypeid(typeid);
    }

    @Override
    public List<Druginfor>findallbyname(String drugname) {
        return drugMapper.findallbyname(drugname);
    }
}
