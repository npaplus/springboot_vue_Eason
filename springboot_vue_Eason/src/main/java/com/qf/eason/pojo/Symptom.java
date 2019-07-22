package com.qf.eason.pojo;

import lombok.Data;

@Data
public class Symptom {

    private Integer id;//症状id
    private String name;//症状名称
    private String badyParts;//症状所属身体部位
    private String percent;//百分比
    private String symptoms1;//在症状中点进去之后的展示
    private String symptoms2;//
    private String symptoms3;//
}
