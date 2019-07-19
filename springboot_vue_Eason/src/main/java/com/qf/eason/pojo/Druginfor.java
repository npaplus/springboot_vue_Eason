package com.qf.eason.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Druginfor implements Serializable {
    private Integer drugId;
    private String drugName;
    private String drugStandard;
    private String drugImg;
    private String drugPrice;
    private String drugElement;
    private String drugFunction;
    private String drugUsage;
}
