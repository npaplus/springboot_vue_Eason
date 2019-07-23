package com.qf.eason.service.impl;

import com.qf.eason.dao.ClassRoomMapper;
import com.qf.eason.pojo.ClassRoom;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired(required = false)
    private ClassRoomMapper classRoomMapper;
    @Override
    public QueryResponseResult findAll() {
        List<ClassRoom> all = classRoomMapper.findAll();
        QueryResult<ClassRoom> queryResult=new QueryResult<>();
        queryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }
}
