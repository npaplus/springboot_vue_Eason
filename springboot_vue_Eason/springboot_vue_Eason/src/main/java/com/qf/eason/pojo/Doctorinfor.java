package com.qf.eason.pojo;

import lombok.Data;

/**
 * 时间：20190718
 * 作者：曹阳
 */
@Data
public class Doctorinfor {
    private Integer id;
    private String realaName;
    private String phone;//电话
    private String email;//邮箱
    private String hospital;//医院名称
    private String office;//科室
    private String title;//职称
    private String officePhone;//科室电话
    private String adept;//擅长及诊所介绍
    private String impSrc;//图片地址
    private String sendWord;//医生寄语
    private String hospiTaltype;//医院类型
    private String workTime;//从业时间
    private String city;//所在省份
    private int peopleNumint;//咨询人数
    private int goodRateint;//好评数
    private int degreeint;//同行认可
    private int printreferint;//图片咨询人数
    private int phonereferint;//电话咨询人数
    private int privatereferint;//私人医生价格
    private Integer backyardint;//院后指导价
    private String honor;//学术荣誉
}
