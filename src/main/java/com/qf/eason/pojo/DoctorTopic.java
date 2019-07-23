package com.qf.eason.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: springboot_vue_Eason
 * @description: 医生所发布的话题
 * @author: Jiang Jingyuan
 * @create: 2019-07-20
 */
@Data
public class DoctorTopic {
    private Integer id;//话题id
    private Doctorinfor doctorinfor;//发布该话题的医生
    private String name;//话题名字
    private String text;//话题文本内容
    private String img;//话题图片地址
    private Date date;//话题发布日期
    private int reading;//话题阅读量
    private int star;//话题点赞数
}
