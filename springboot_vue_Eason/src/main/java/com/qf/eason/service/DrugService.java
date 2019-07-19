package com.qf.eason.service;

import com.qf.eason.pojo.Druginfor;
import com.qf.eason.response.QueryResponseResult;

public interface DrugService {
    public  QueryResponseResult findall();


    Druginfor findallbyid(int drugid);
}
