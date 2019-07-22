package com.qf.eason.service;

import com.qf.eason.pojo.Doctorinfor;

import java.util.List;

/**
 * caoyang
 * 2019/07/20
 */
public interface DoctorinforServcie {
    /**
     * 根据条件查询医生（搜索模糊查询其中条件在xml文件中）
     * @param string 前台传过来的值
     * @return 医生的集合
     */
    public List<Doctorinfor> findAll(String string);
    /**
     * 无条件查询所有医生
     * @return 所有医生
     */
    public List<Doctorinfor> load();
    /**
     * 无条件查询已有的科室
     * @return 科室的集合为Sting
     */
    public List<String> findOffice();

    /**
     * 根据id查询医生(精确查询)
     * @param id 医生的id
     * @return 医生的对象
     */
    public Doctorinfor findById(Integer id);

    /**
     * 根据医院等级查询
     * @param string 医院的等级(三甲)
     * @return 医生的集合
     */
    public List<Doctorinfor> find(String string);
}
