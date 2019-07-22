package com.qf.eason.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by ZhangDian on 2019/7/20.
 */
@Configuration
public class YanZhengCode {

    public static  String getNewcode(){
        String code= String.valueOf((Math.round((Math.random()*9+1)*1000)));  //每次调用生成一位四位数的随机数//生成五位*10000//六位/七位类推
        return  code;
    }
}
