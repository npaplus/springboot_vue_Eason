package com.qf.eason.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Talk implements Serializable {
    private  Integer udId;
    private  Integer userId;
    private String userImg;
    private  Integer doctorId;
    private  String userProblem;//用户提问
    private  String doctorAnswer;//医生回答
    private String userAppraise;//用户评价

}
