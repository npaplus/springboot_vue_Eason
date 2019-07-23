package com.qf.eason.service;

import com.qf.eason.pojo.Druginfor;
import com.qf.eason.response.QueryResponseResult;

import java.util.List;

public interface DrugService {
    public  QueryResponseResult findall();

    Druginfor findallbyid(int drugid);

    List<Druginfor> findallbytypeid(int typeid);

    List<Druginfor> findallbyname(String drugname);
}
