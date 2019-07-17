package com.qf.eason.service.impl;

import com.qf.eason.dao.UserMapper;
import com.qf.eason.pojo.User;
import com.qf.eason.response.CommonCode;
import com.qf.eason.response.QueryResponseResult;
import com.qf.eason.response.QueryResult;
import com.qf.eason.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Service
public class UserServiceImpl implements UserServcie{

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public QueryResponseResult findAll() {
        List<User> all = userMapper.findAll();
        QueryResult<User> userQueryResult = new QueryResult<>();
        userQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);
    }
}
